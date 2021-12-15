package com;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Demo1129 {

    public static void main(String[] args) {
        String s = UnicodeUtil.toUnicode("中国");
        System.out.println(s);
        String fileName = "资金计划填报审批流程.x.docx";
        String format = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_PATTERN);
        int i = fileName.lastIndexOf('.');
        String rename = format + fileName.substring(i);
        System.out.println(rename);
        KeyPair rsa = SecureUtil.generateKeyPair("RSA", 512);
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, rsa.getPrivate().getEncoded(), rsa.getPublic().getEncoded());
        String data = "这是一段数据";
        String data1 = "这是一段数据1";
        System.out.println(rsa.getPrivate().getEncoded().length);
        System.out.println(rsa.getPublic().getEncoded().length);
        System.out.println(StrUtil.str(rsa.getPrivate().getEncoded(), StandardCharsets.UTF_8).length());
        byte[] sign1 = sign.sign(data.getBytes(StandardCharsets.UTF_8));
        boolean verify = sign.verify(data1.getBytes(StandardCharsets.UTF_8), sign1);
        System.out.println(verify);
        test();
    }

    public static void test() {
        String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCWnFSaHqMstPNERpJEkk3vJKwR4yjTd7cmCMx/yqABqRd0XUZU3t8JcdrryD63kUyBTUNtkqf9Rl17dAv79fT6XiVyjNr8TK1x6A55rg4lCtvyO3SYYnfP+2CYRxogWVScTilVkbKKSHo0knXw7bxjvgCSPQr6YLIqcpPHJGmHT+lShOlNoMVQLIUuhzCAGBYSEuRbXnNbSk3nqWWBoJ+29diWo2ouAy1aHSbmKCD8LbIqNohsNJ99XZsZKi2xauOZSa3m4WWopFxkgWzWdCZ3Qpdk3YIdNONr2xoWvVQKigcTrfFvLjcwoYujWoqo7ho+4ilXqEc/5yPL4FpUVw4fAgMBAAECggEASW77yRF7Ggc4PWfzVT/Ig/trcmVBuKm8QO01WHGhRm39o5z+986bDO3YgfHmsnZDyR+06q4A/nrahaD1Xupzgcd5lrqa4z03rDwrIqT8/I6o4xieJtaL+HpmhJjWYkNr/7IUcUZSuR3Rh+SJYOlpW3B+ss7UlXOkKxImf4h/c5uBeHKGqmoO7v/zbbGJD3IsIO22rrKVee2+2HA543szjP1xU95pxPndsLdNOrGjVEz87GAZsnjxj9Dxuy8GxYUzsnwrKBUt+YK38PFpklA1Lugb41FVlZBlv/rCvs9xtW4S9ZXbQjGKB2v8epyzuo2yu9djYuvMG5kGsADsIkGaUQKBgQDGYHyFhTcvs11J8O1nVfPWTCKJnVPDh8H12TpzfZbmPtzZDBN9Z2g1QVWe93rvKeuLFzvLFosEzMrHWvz/3l0ZV1PiEIEQ5k9kBclbLQV+10vBTtgiGrA2N4nhhxgXGg/8PoAChoS6w32yYnqrck1tIUEqk/O1khcvQkcGvURE9QKBgQDCW+WgfJHSz+JDakwZn9pasvgIWT8pLj7GqXKYk9ocnj2ThPz/IIePVWL4itBlo+rROlLl0frnpGyNPZHN03h+ZB9QlhK7KCL/reDDbG8wBR+PeiOeimCxwHuQYwURUVJZowE44wP7ezVIUf5ghnV/923S5BQS+UF1yXxjSIO6QwKBgCYQV3RLNmaZtPm+F99vF6Vz4GClZnArOWVR9Cw62dx+DWQ8M/UpBU7KpYImHFmNopuCrr9uKOiX3wTXiZoS8awuHHNRFWLHvk4D6jnrbpWC/A8wcLpCgrM0fuleQZoVLyIIYAmcBBXN8u1qhf0lpoOdEOL5lpatXHN99SDu6g2NAoGASOX5AbHXbA+m2QxUkMPhPWWlHFSFGSgMSa0im1HRXCyKAfu+fN6xmbQ4E+rU8VqC54kNsL+KcTm9sVgniODJb/aTvEEds28BeY65H/Na3NL/HGx+UaerTuBYODa7ntw2nAJEohab1sZGnOKMG54zEhU27wO298rfn5M8AW0gY0sCgYAbj2KUZjHOKm4wlX7/RRQjJYkfQ3owC4QJbWIKVhYpvq36EqD6Hl+sYeqKqa9xbQOII2EM9gY01mL2yGTQW9kdVvtLLklVrZML6N/ghY/G/qiHo3c9dNtUeg6cQX1iLQ40r4IIXmYQZyO4UErYESlLUGr8DxDEE6gwh+pxC5LROQ==";
        String requestUrl = "http://ui.luna-ms-ats-dev.luna.fingard.cn/api?uc=UC_SYS_EXTERNAL_QUERYTENANT";
        Map<String, Object> data = new HashMap<>();
        data.put("openTimeStart", "2021-01-01 00:00:00");
        data.put("openTimeEnd", "2021-06-01 00:00:00");
        String s = JSONUtil.toJsonStr(data);
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, null);
        byte[] signed = sign.sign(s.getBytes(StandardCharsets.UTF_8));
        data.put("sign", cn.hutool.core.codec.Base64.encode(signed));
        HttpRequest httpRequest = HttpRequest.post(requestUrl)
                .header("eureka-label", "zhuyf")
                .form(data)
                .contentType("application/x-www-form-urlencoded");
        System.out.println(httpRequest);
        HttpResponse execute = httpRequest.execute();
        System.out.println(execute);
        System.out.println(s);
        String re = "{\"openTimeStart\": \"2021-01-01 00:00:00\",\"openTimeEnd\": \"2021-12-12 00:00:00\"}";
        System.out.println(Integer.MAX_VALUE);
    }
}
