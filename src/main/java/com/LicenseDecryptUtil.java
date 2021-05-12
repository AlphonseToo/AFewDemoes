package com;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;

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
            String license = "P2s4pdKDffNDyEJRDUD3MSP40AXecR2wC7xpLVmmB5ejQo/29XPkXzyb7+Z5CNs2nz8J/u94oU0aaq6FKJewVH3YwNuXId/LOhk3NU39UPKx5fPipFqO1cRFwRzJDHK+uyhk7czkMweVTSuNSpsuSbbaz5YXVrKFSZt34YGCkhM=&k9KB08PRGSMEj8vAJQYoAOPpR/kaExWKQPlb/XS2FfL0Ft9tfskCjOyVHPg4Mk7X6IgtTD5kqevkQju04W6yY4dpS6O9CeefJd9ILnYjBNsjmNNtWnPXqTehpU90TojJi7MWTV7eBkKU71U9RitrjjZaZjmgcCz84wv4kM/9lws=&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";
            Map<String, Object> map = decrypt(license, publicKey);
            System.out.println(LicenseDecryptUtil.getMenuCodeSet());
            System.out.println(LicenseDecryptUtil.getTransCodeSet());
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
