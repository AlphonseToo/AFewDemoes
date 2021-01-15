package com;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * license解析工具类
 * license: 序列号，由 RSA密文&RSA签名&AES密文 拼接而成
 * 客户方需要 1,客户编号（客户唯一识别码）CID; 2,产品编号（产品唯一识别码）PID; 3,RSA公钥publicKey； 4,客户产品名称
 * Created by zzk on 2019/3/8.
 */
public class LicenseDecryptUtil {

    private static final String SEPARATOR = "&";

    private static final String RSA_KEY_ALGORITHM = "RSA";

    private static final String AES_KEY_ALGORITHM = "AES";

    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static List<String> menuCodeList = new ArrayList<>();
    private static List<String> subTransList = new ArrayList<>();
	private static String enabledLicense = "1";

    /**
     * 解析序列号license
     *
     * @param license      序列号
     * @param publicKeyStr 公钥
     * @return map(客户编号CID, 产品编号PID, 过期时间END, 版本号VER, 客户产品名称)
     * @throws Exception
     */
    public static Map<String, Object> decrypt(String license, String publicKeyStr) throws Exception {
        // license = RSA密文 & RSA签名 & AES密文
        String[] split = license.split(SEPARATOR);
        // RSA公钥解密
        String rsaDecrypt = decryptByPubKey(split[0], publicKeyStr);
        // RSA公钥验签
        boolean verify = verify(rsaDecrypt, split[1], publicKeyStr);
        if (!verify) {
            throw new RuntimeException("验签失败！");
        }
		// 基本信息集合
        Map<String, String> baseInfoMap = (Map) JSONObject.parse(rsaDecrypt);
        // AES解密key
        String signKey = MD5Sign(rsaDecrypt).replaceAll("\r\n", "");
        // AES解密
        String aesDecrypt = AESDecrypt(split[2], signKey);
        // 解压
        String unCompress = unCompress(aesDecrypt);
        // AES密文是否压缩
        //String aesDecrypt;
        //if (split.length > 3 && "T".equals(split[3])) {
        //    aesDecrypt = AESDecryptAndUnCompress(split[2], signKey);
        //} else {
        //    aesDecrypt = AESDecrypt(split[2], signKey);
        //}
        Map<String, List<String>> authInfoMap = (Map) JSONUtil.parse(unCompress);

        Map<String, Object> map = new HashMap<>();
        map.putAll(baseInfoMap);
        map.putAll(authInfoMap);
        menuCodeList = authInfoMap.get("MENU");
        subTransList = authInfoMap.get("TRANS");

		// 获取是否开启license控制的信息
        List<String> enabledLicenseList = authInfoMap.get("ENABLED_LICENSE");
        if (enabledLicenseList != null && enabledLicenseList.size() > 0) {
            enabledLicense = enabledLicenseList.get(0);
        }
        return map;
    }

    /**
     * 公钥解密
     *
     * @param data         解密前的字符串
     * @param publicKeyStr 公钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decryptByPubKey(String data, String publicKeyStr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, getPublicKey(keyFactory, publicKeyStr));
        byte[] doFinal = cipher.doFinal(Base64.decodeBase64(data));
        return new String(doFinal, StandardCharsets.UTF_8);
    }

    /**
     * 字符串的解压
     * 压缩字符串以以ISO-8859-1格式解压，然后以UTF-8格式输出原始字符串
     *
     * @param str 对字符串解压
     * @return 返回解压缩后的字符串
     * @throws IOException
     */
    public static String unCompress(String str) throws IOException {
        if (null == str || str.length() <= 0) {
            return str;
        }
        // 创建一个新的 byte 数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1));
        // 使用默认缓冲区大小创建新的输入流
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;
        while ((n = gzip.read(buffer)) >= 0) {// 将未压缩数据读入字节数组
            // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte数组输出流
            out.write(buffer, 0, n);
        }
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
        return out.toString(StandardCharsets.UTF_8.name());
    }

    /**
     * MD5withRSA验签
     *
     * @param data         待校验数据
     * @param sign         签名
     * @param publicKeyStr 公钥
     * @return 校验成功返回true，失败返回false
     */
    public static boolean verify(String data, String sign, String publicKeyStr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(getPublicKey(keyFactory, publicKeyStr));
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.decodeBase64(sign));
    }

    /**
     * 获取公钥
     *
     * @param publicKeyStr 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(KeyFactory keyFactory, String publicKeyStr) throws Exception {
        return keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr)));
    }

    /**
     * AES解密
     *
     * @param data 待解密数据
     * @param key  解密密钥
     * @return
     * @throws Exception
     */
    public static String AESDecrypt(String data, String key) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(AES_KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        keygen.init(128, random);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keygen.generateKey().getEncoded(), AES_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] doFinal = cipher.doFinal(Base64.decodeBase64(data));
        return new String(doFinal, StandardCharsets.UTF_8);
    }

    /**
     * 获取MD5签名
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String MD5Sign(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(md.digest());
    }

    /**
     * 获取menuCodeSet
     *
     * @return
     */
    public static Set<String> getMenuCodeSet() {
        return new HashSet<>(menuCodeList);
    }

    /**
     * 获取transCodeSet
     *
     * @return
     */
    public static Set<String> getTransCodeSet() {
        return new HashSet<>(subTransList);
    }

    public static void main(String[] args) {
        try {
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSE5eJ0QNOjOlQIg1+ABnIRfa2clpJYGWqFgi8H4jw0s4MJei6lgmtu5lLkRff9oyCElV+qmIDzE8T235VqN3kUafJv36sskvzp91Qc95vUoWDPipsPZbVWJkkPSBqdsxs8SyLsm4cOviFPmlNWVhhVWZEFgs/I00DGgFCDdg9jwIDAQAB";
            String license = "gbarE8rbQlhwILcufSwELBUHCJshQ2DOqaE276QElVkSK4ZpQ5yRHAhEKldBq9qWsSFMtFtNHapvy/7s3htZMgjoQMBr2EsKrcTVMutbIjJzCPk5fAoszzAX7iWJn7SxoSRYUiNoMeLLLoVl8Wh7DFNNeNKbkDD76SQzAly+TRM=&ELYSyB6OeHZdKSLEfThcBw9DJlXM4NYSJkgvDQSkUXjF2f4i+ULm2iOqYFgHYZGKIxYQDCgQfWEzIF1WUjlWLl0da5TYJA9x0mC2b97wujEV/FmbHPoXJDFPWHLQfkqSUPVR44y9SW46+eiCf52DDrxgr7wSZ0HQI5GaooQBidc=&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";
            Map<String, Object> map = decrypt(license, publicKey);
            System.out.println(LicenseDecryptUtil.getMenuCodeSet());
            System.out.println(LicenseDecryptUtil.getTransCodeSet());
            System.out.println(map);
//			System.out.println(licenseSwitch());

            Date bb = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-25");
            System.out.println(new Date().compareTo(bb));
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            String end = "2020年12月30日";
            Date endDate = format.parse(end);
            Date now = new Date();
            long a = DateUtil.between(now, endDate, DateUnit.DAY, true);
            String info = format.format(endDate);
            System.out.println("info: " + info);
            System.out.println("a: " + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
