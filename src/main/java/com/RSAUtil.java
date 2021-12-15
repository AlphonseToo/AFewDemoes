package com;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.compress.utils.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RSAUtil {

    private static String getSignContent(Map<String, String> params) {
        if (params == null) {
            return null;
        }
        params.remove("sign");
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

    private static PrivateKey getPrivateKeyFromPKCS8(String algorithm,
                                                    InputStream ins) throws Exception {
        if (ins == null || StrUtil.isEmpty(algorithm)) {
            return null;
        }
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey = IOUtils.toByteArray(ins);
        encodedKey = cn.hutool.core.codec.Base64.decode(encodedKey);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    public static String doSign(Map<String, String> params, String charset, String privateKey) throws Exception {
        String content = getSignContent(params);
        PrivateKey priKey = getPrivateKeyFromPKCS8("RSA",
                new ByteArrayInputStream(privateKey.getBytes()));
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(priKey);
        if (StrUtil.isEmpty(charset)) {
            signature.update(content.getBytes());
        } else {
            signature.update(content.getBytes(charset));
        }
        byte[] signed = signature.sign();
        return cn.hutool.core.codec.Base64.encode(signed);
    }
}
