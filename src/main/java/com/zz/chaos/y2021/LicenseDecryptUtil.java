package com.zz.chaos.y2021;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
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
        if (split.length != 3) {
            throw new Exception("license无效！");
        }
        if (StrUtil.isBlank(split[0]) || StrUtil.isBlank(split[1]) || StrUtil.isBlank(split[2])) {
            throw new Exception("license无效！");
        }
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
        PublicKey publicKey = getPublicKey(keyFactory, publicKeyStr);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] dataBytes = Base64Utils.decodeFromString(data);
        byte[] enBytes = null;
        // 解密时超过128字节就报错。为此采用分段解密的办法来解密
        for (int i = 0; i < dataBytes.length; i += 128) {
            byte[] doFinal = cipher.doFinal(ArrayUtil.sub(dataBytes, i, i + 128));
            enBytes = ArrayUtil.addAll(enBytes, doFinal);
        }
        return new String(enBytes, StandardCharsets.UTF_8);
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
            String l3 = "B0jGHmZMeJrEjS8hUUD0mMbTxzn6g37uE4A9cr0i8305rbVBxjk1bxNwPJZxIMTtKdhoGnbzH/GsVUytDWTGbTPftmTpOxU20QcpFTDLkCWoFxi9tFpngPKg+tgaIpGZEMghWewErdxzQ4nZXW6gXAihuZpYdqcRIsfh4dqwBk0=&KQQWb/FEraso1dYYwaZcdJYWPlSN/4SThdDswj+0lPUytV98wxXxmLOtdG8jEskP+q51Qk8ca3JLGuAr7LcHESWhNv61rVE2ndblBHFn5uL43XTQtnmWQkozAGlC5vXw/pMTD8kgvG78zH7p7NCkqEfZyOH10jVpCvuP7ALslME=&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";
            String l2 = "";
            stringBuilder.append(l3);
            stringBuilder.append(l2);
            Map<String, Object> map = decrypt(stringBuilder.toString(), publicKey);
//            System.out.println(LicenseDecryptUtil.getMenuCodeSet());
//            System.out.println(LicenseDecryptUtil.getTransCodeSet());
            List<String> enabledLicenseList = (List)map.get("ENABLED_LICENSE");
            System.out.println(map);
            boolean uc_capitalpool_iv_transfers_query = subTransList.contains("UC_CAPITALPOOL_IV_TRANSFERS_QUERY");
//            System.out.println(uc_capitalpool_iv_transfers_query);
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
