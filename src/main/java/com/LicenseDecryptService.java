package com;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.Getter;
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
 * license工具封装类
 *
 * @author Alphonse
 * @version 2.0
 **/
public class LicenseDecryptService {

    public static final String CODE_SEPARATOR = "#";
    public static final String LICENSE_SEPARATOR = "&";
    public static final String RSA_KEY_ALGORITHM = "RSA";
    public static final String AES_KEY_ALGORITHM = "AES";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    public static final String LICENSE_MENU = "MENU";
    public static final String LICENSE_TRANS = "TRANS";
    public static final String LICENSE_MENU_TRANS = "MENU_TRANS";
    public static final String LICENSE_END = "END";
    public static final String LICENSE_ENABLED = "ENABLED_LICENSE";
    public static final String LICENSE_CID = "CID";
    public static final String LICENSE_PID = "PID";
    public static final String LICENSE_CPN = "CPN";

    @Getter
    public Set<String> menuCodeSet = new HashSet<>();
    @Getter
    public Set<String> transCodeSet = new HashSet<>();
    @Getter
    public Set<String> menuTransSet = new HashSet<>();
    @Getter
    public boolean enabledLicense = true;
    @Getter
    public Date endDate;
    public String cid;
    public String pid;
    public String cpn;

    public LicenseDecryptService(){

    }

    /**
     * 校验是否过期
     * @return 过期返回true，否则返回false
     */
    public boolean checkIfExpired() {
        // 当前时间是否大于到期时间
        return  (new Date().compareTo(endDate) > 0);
    }

    public void decrypt(String license, String publicKeyStr) throws Exception {
        try {
            if (StrUtil.isBlank(license) || StrUtil.isBlank(publicKeyStr)) {
                throw new Exception("license或公钥不允许为空！");
            }
            // license = RSA密文 & RSA签名 & AES密文
            String[] split = license.split(LICENSE_SEPARATOR);
            if (split.length != 3 || StrUtil.isBlank(split[0]) || StrUtil.isBlank(split[1]) || StrUtil.isBlank(split[2])) {
                throw new Exception("license无效！");
            }
            // RSA公钥解密
            String rsaDecrypt = decryptByPubKey(split[0], publicKeyStr);
            // RSA公钥验签
            boolean verify = verify(rsaDecrypt, split[1], publicKeyStr);
            if (!verify) {
                throw new Exception(String.format("验签失败: [data: %s, sign: %s, publicKeyStr：%s]", rsaDecrypt, split[1], publicKeyStr));
            }
            // 基本信息集合
            Map<String, String> baseInfoMap = (Map) JSONUtil.parse(rsaDecrypt);
            // AES解密key
            String signKey = MD5Sign(rsaDecrypt).replaceAll("\r\n", "");
            // AES解密
            String aesDecrypt = AESDecrypt(split[2], signKey);
            // 解压
            String unCompress = unCompress(aesDecrypt);
            Map<String, List<String>> authInfoMap = (Map) JSONUtil.parse(unCompress);

            Map<String, Object> map = new HashMap<>();
            map.putAll(baseInfoMap);
            map.putAll(authInfoMap);
            // 兼容旧的license，只有license2.0中有menuTransSet
            List<String> menuTransList = authInfoMap.get(LICENSE_MENU_TRANS);
            if (CollectionUtil.isNotEmpty(menuTransList)) {
                // license2.0
                menuTransSet = new HashSet<>(menuTransList);
                menuCodeSet = getMenuFromMenuTrans(menuTransSet);
                transCodeSet = getSubTransFromMenuTrans(menuTransSet);
            } else {
                // license1.0
                menuCodeSet = new HashSet<>(authInfoMap.get(LICENSE_MENU));
                transCodeSet = new HashSet<>(authInfoMap.get(LICENSE_TRANS));
                menuTransSet = new HashSet<>();
            }
            endDate = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm.SSS").parse(map.get(LICENSE_END) + " 23:59:59.999");
            cid = baseInfoMap.get(LICENSE_CID);
            pid = baseInfoMap.get(LICENSE_PID);
            cpn = baseInfoMap.get(LICENSE_CPN);

            // 获取是否开启license控制的信息
            List<String> enabledLicenseList = authInfoMap.get(LICENSE_ENABLED);
            if (enabledLicenseList != null && enabledLicenseList.size() > 0) {
                enabledLicense = "1".equals(enabledLicenseList.get(0));
            }
        } catch (Exception e) {
            throw new Exception("license解析异常！", e);
        }
    }

    /**
     * 从menuTrans集合中获取菜单编码集合
     */
    public static Set<String> getMenuFromMenuTrans(Set<String> menuTrans) {
        Set<String> result = new HashSet<>();
        for (String menuTran : menuTrans) {
            result.add(menuTran.split(CODE_SEPARATOR)[0]);
        }
        return result;
    }

    /**
     * 从menuTrans集合中获取子功能集合
     */
    public static Set<String> getSubTransFromMenuTrans(Set<String> menuTrans) {
        Set<String> result = new HashSet<>();
        for (String menuTran : menuTrans) {
            result.add(menuTran.split(CODE_SEPARATOR)[1]);
        }
        return result;
    }

    /**
     * 公钥解密
     *
     * @param data         解密前的字符串
     * @param publicKeyStr 公钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public String decryptByPubKey(String data, String publicKeyStr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, getPublicKey(keyFactory, publicKeyStr));
        byte[] doFinal = cipher.doFinal(Base64.decode(data));
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
    public String unCompress(String str) throws IOException {
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
    public boolean verify(String data, String sign, String publicKeyStr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(getPublicKey(keyFactory, publicKeyStr));
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.decode(sign));
    }

    /**
     * 获取公钥
     *
     * @param publicKeyStr 公钥字符串
     * @return
     */
    public PublicKey getPublicKey(KeyFactory keyFactory, String publicKeyStr) throws Exception {
        return keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decode(publicKeyStr)));
    }

    /**
     * AES解密
     *
     * @param data 待解密数据
     * @param key  解密密钥
     * @return
     * @throws Exception
     */
    public String AESDecrypt(String data, String key) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance(AES_KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        keygen.init(128, random);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keygen.generateKey().getEncoded(), AES_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] doFinal = cipher.doFinal(Base64.decode(data));
        return new String(doFinal, StandardCharsets.UTF_8);
    }

    /**
     * 获取MD5签名
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String MD5Sign(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes(StandardCharsets.UTF_8));
        return Base64.encode(md.digest());
    }

    public static void main(String[] args) throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSE5eJ0QNOjOlQIg1+ABnIRfa2clpJYGWqFgi8H4jw0s4MJei6lgmtu5lLkRff9oyCElV+qmIDzE8T235VqN3kUafJv36sskvzp91Qc95vUoWDPipsPZbVWJkkPSBqdsxs8SyLsm4cOviFPmlNWVhhVWZEFgs/I00DGgFCDdg9jwIDAQAB";
        String s = "G9XwVTttmzz5b/otdWnUshyKkO0CV/yhsZBB8R3FrN5/TCnCnpQZTUO8cefABb4sPTey/olhfgoQkSez7lGwlpp6D31ZnCQj+JEnlFzpY5uc6kpqLr/JQiJX7id8DKWQNoP+s7V/BTSM3BjaTGrDtIINBvEcBv6EAJ6+7+U288c=&YV12wSqid82yrCxeulWFwNK+ZNSPpc0d/5etWgZny9CxfGuBQ8gRFIWmn2zEncm85VKdwpdYdaE++Vc2X1AmLq8OgDFF7zeWd5cRtMZh0Tv6/Z8Dzba8LGcYOT+Cq4MUAipn1YlwQMYNkjkPp4zTUb9z2Ak//V2WljVxzAp4SDA=&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";
        LicenseDecryptService service = new LicenseDecryptService();
        service.decrypt(s, publicKey);
        String uc = "UC_CAPITALPOOL_IV_TRANSFERS_QUERY";
        Set<String> transCodeSet = service.getTransCodeSet();
        Set<String> menuCodeSet = service.getMenuCodeSet();
        System.out.println(transCodeSet.contains(uc));
        boolean enabledLicense = service.isEnabledLicense();
        if (enabledLicense && !transCodeSet.contains(uc)) {
            // license中权限校验开关开启且uc未在transCodeSet中找到
            throw new Exception("LUNA_AUTH_LICENSE_CHECK_FAIL");
        }
    }
}
