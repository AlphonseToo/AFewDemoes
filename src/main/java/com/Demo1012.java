package com;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.ECIES;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.security.ssl.SSLSocketFactoryImpl;

import javax.crypto.SecretKey;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.Security;
import java.util.Arrays;
import java.util.Date;

public class Demo1012 {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory sf = new SSLSocketFactoryImpl();
        SSLSocket s = (SSLSocket) sf.createSocket();
        System.out.println( Arrays.toString( s.getSupportedProtocols() )) ;

        SecureUtil secureUtil = new SecureUtil();
        String sign = "123456";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqLqlfKssk7Q3aUs2R+Uw" +
                "lV98oP7PhLFSaDlh+Lp15oNnHBBbWdGy2Hm/n8cEveXKXobm3c6JM1fDoDDitjbR" +
                "0ORiGKGySG6b41RD3XSptFMnaAenF/Be/6b0p97vzkr/2l/VXz4dx/M9FxDx69Wi" +
                "zZSNu2S0rkAczFRHisJFY/OeytFV5BQCFoR8YAWZQr+JzGOTr/u9JxI6KYptlhd3" +
                "fzIPtbAsglC+JimQXpn2ibt2niR1d+Po4mY2WOb7sZEep0NPBdKwJtMiunY4DG+K" +
                "1hlYcjDWC/1gMWprN6eK88gY/HdH6mR3Cb8sD1aBf90ZZ0JmqmUmgPwSY7YVVAqY" +
                "hQIDAQAB";
        SecretKey s1 = SecureUtil.generateKey("SHA256withRSA", publicKey.getBytes(StandardCharsets.UTF_8));
        SecureUtil.addProvider(new BouncyCastleProvider());
        int i = Security.addProvider(new BouncyCastleProvider());
        KeyPair rsa2 = SecureUtil.generateKeyPair("RSA2");
        AsymmetricCrypto asymmetricCrypto = new AsymmetricCrypto("RSA2", null, publicKey);
        ECIES ecies = new ECIES("SHA256WithRSA", null, publicKey);
//        String s2 = ecies.encryptBase64(sign.getBytes(StandardCharsets.UTF_8), KeyType.PublicKey).toString();
//        System.out.println(s2);
        System.out.println(new Date().toString());
    }
}
