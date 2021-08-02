package com;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.zip.GZIPInputStream;

import static com.google.common.io.ByteStreams.toByteArray;

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
    private static List<String> menuTransList = new ArrayList<>();
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
        Map<String, String> baseInfoMap = (Map) JSONUtil.parse(rsaDecrypt);
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
        menuTransList = authInfoMap.get("MENU_TRANS");
        if (CollectionUtil.isNotEmpty(menuTransList)) {
            menuCodeList = new ArrayList<>(getMenuFromMenuTrans(menuTransList));
            subTransList = new ArrayList<>(getSubTransFromMenuTrans(menuTransList));
        } else {
            menuCodeList = authInfoMap.get("MENU");
            subTransList = authInfoMap.get("TRANS");
            menuTransList = new ArrayList<>();
        }

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
        byte[] doFinal = cipher.doFinal(cn.hutool.core.codec.Base64.decode(data));
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
        return signature.verify(cn.hutool.core.codec.Base64.decode(sign));
    }

    /**
     * 获取公钥
     *
     * @param publicKeyStr 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(KeyFactory keyFactory, String publicKeyStr) throws Exception {
        return keyFactory.generatePublic(new X509EncodedKeySpec(cn.hutool.core.codec.Base64.decode(publicKeyStr)));
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
        byte[] doFinal = cipher.doFinal(cn.hutool.core.codec.Base64.decode(data));
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
        return cn.hutool.core.codec.Base64.encode(md.digest());
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

    public static Set<String> getMenuTransCodeSet() {
        return new HashSet<>(menuTransList);
    }

    private static Set<String> getMenuFromMenuTrans(List<String> menuTrans) {
        Set<String> result = new HashSet<>();
        for (String menuTran : menuTrans) {
            result.add(menuTran.split("#")[0]);
        }
        return result;
    }
    private static Set<String> getSubTransFromMenuTrans(List<String> menuTrans) {
        Set<String> result = new HashSet<>();
        for (String menuTran : menuTrans) {
            result.add(menuTran.split("#")[1]);
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSE5eJ0QNOjOlQIg1+ABnIRfa2clpJYGWqFgi8H4jw0s4MJei6lgmtu5lLkRff9oyCElV+qmIDzE8T235VqN3kUafJv36sskvzp91Qc95vUoWDPipsPZbVWJkkPSBqdsxs8SyLsm4cOviFPmlNWVhhVWZEFgs/I00DGgFCDdg9jwIDAQAB";
            StringBuilder stringBuilder = new StringBuilder();
            String l3 = "Hb4Z2qvuiZorTJpCTCau+SxY4a1LUFFkZInP0e5JCQorxOvpr1sDfa5XfmWYTYqO2l6vpXDTNQZaieDKQwyEgT9sLJdtZC+cXFzBhVYPqF1R4qXB1zMQzmn2x7rcJ+eJ26Uwc7b1MtWPogU5SVML83Id88eUWXDX85zJLuGp98A=&HNRfdDOFI8jrOD+gXYbIlMNYCV28mkGoJJjX9sB4sO8WysfVNZ77pVV+pT5AR0QKY7NLpvwfgtk09n8r+SUQgoVlX/a/j6txklZZkyN7t+juwHkp4Gx7hPRwSKJWxghj7oKXkFH9Kn61bKOu9Bhi4UDqdr9xkZyYcH+ImTJT2Ho=&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";
            stringBuilder.append(l3);
//            stringBuilder.append(l2);
            Map<String, Object> map = decrypt(stringBuilder.toString(), publicKey);
//            System.out.println(LicenseDecryptUtil.getMenuCodeSet());
//            System.out.println(LicenseDecryptUtil.getTransCodeSet());
            System.out.println(map);
//			System.out.println(licenseSwitch());

/*            Date bb = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-25");
            System.out.println(new Date().compareTo(bb));
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            String end = "2020年12月30日";
            Date endDate = format.parse(end);
            Date now = new Date();
            long a = DateUtil.between(now, endDate, DateUnit.DAY, true);
            String info = format.format(endDate);
            System.out.println("info: " + info);
            System.out.println("a: " + a);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
