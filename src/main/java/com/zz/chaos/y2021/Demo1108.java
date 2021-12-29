package com.zz.chaos.y2021;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class Demo1108 {
    private static String signType = "RSA2";
    private static String clientId = "f8178c8720349cb16d2798603d82b19cQVkTdTlJe3W";
//    private static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIb3moI37UKqUSyekZzeGHLWjoHoSuo1c6UtOaFG76piNpNxhYmO9Z57le7WgFNSuwaYhjd131rpeZTs5Sr0ROuMek78TuvvLBnZWUkA79ncXwkBU6RyeoJo6iTRA0d5GPpCfcrUP15K5K060M54vv8sZ5ymPi5RrROiN2KDwYJOvZoKDuqIlvaisz+msUfst3OIpzO7dn4T2j0uNQGrGug41nbvbZznPeHdyql7zqEc2iN0PLS4A0eWNWCG9Ws/gk9NwU8z05KDtcpwjHa/VSw5c8MC76dxdl/hxLdMrwaDwW+J7YSU2BWrL3DsCjvsg9PiGUQmqekPmzoOoXO5lTAgMBAAECggEACYDiU4Dtc6/owa9IymBZ5kWWehyuF1APYmOkk6X6uQDblJee3YUBnxyR//e/eCVk/qvLMUp+Q/++VZJ0srO8qVMbrPR6njq0xCHK6odCVA4qXIBcyitsqrzM0KdXiqANhpjjoe57vmQIc/PcqPpz9+nMQ22CmaplvM806yUQUoodydmkyODINGshivDfPUyVgYum8fuzrrC9kMfqln4UBwWAf+0JRIcW14bGt8R4b3Qvr+JstA5yKwV5ZqpgnZjV4x7DkAP86b38ZKjhdYk2AOLKGc7GjAyziqEaDJVw1zYugmCqGgyjqhFhA9M7yNZcVW1j9cLHEbOCFkY5KPfeKQKBgQDB4nsdbEsm056VxBaWIvTMxGj8k0FCdmXkVEDWzzXm1cVgX3Lq9UKJbqqU3oU+ulHRonAL+mQfaJB1NsF4ZWRgp9i2shyRpxz1q5ahKktvsxis2yQNQOEpD3MMMREliowewbSIDF2ZLf1Hx6SNEz6lZ0QAQ8Hn+tJ2CK6WE4T7XQKBgQC0JUZz1X95+3Jrp383WjEtSvGfZFgglCSUnO6roeMGVzojFMvrgO4zhxS3wZMuuh4iBEIcJGWZWpg1gLLYNnym6bK8ToHTrpgFyBjdsUchSw5mcrgbD7V4Yrt6HBmnfgdPmrzpgDqRPJgvSBNbbrugS9BxGy+KvoR8DaDD4Y9MbwKBgAQGwQnGYvUmdeekT9fEWBMcjRWZtUQ9EzafrU0ItpTZoaSztr48Y6pY+v/mcxvvYJ2a4vrMs2GXmVBl17S5XlFHiw+YOVGpB8fuTU2BhFmIfZ2xW1lPHJ3urTP2nOWLsAc/fJFKuHLi6pyf/8HSQX3L3DSpM5Cuu8opuf5x31QdAoGAMknhk/56mpvWAjV87v/PkJxGPT+u1lFksNPqUKFdleyNvzNUBcc1N88yumVgZ//u34IezmpermO679ygkHkNbS76BVVJKsWnjJ2iS2jsuV+Rgont2SgWeafePCVSCA7HjbJdoDV6pAatWS2esbyExifD5X84U1wB8ft/8I6sCSMCgYEArS/yR8fVaf02Z1j5/ZG+J46pk/y1M1TeoGlWzEQvxmNrbd7Nn5NKc8RFK2hPTmaItp4DKgfgpDGYTypv1hlrIVlZxyg/36UkvwckMvpi3Qg633RnCEA94wEKqbbaNWMPRg1oMPlIzchnBXfVKaIb0tk8r9Zm0MWnxTDLGXWNRn4=";
    private static String privateKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiG95qCN+1CqlEsnpGc3hhy1o6B6ErqNXOlLTmhRu+qYjaTcYWJjvWee5Xu1oBTUrsGmIY3dd9a6XmU7OUq9ETrjHpO/E7r7ywZ2VlJAO/Z3F8JAVOkcnqCaOok0QNHeRj6Qn3K1D9eSuStOtDOeL7/LGecpj4uUa0Tojdig8GCTr2aCg7qiJb2orM/prFH7LdziKczu3Z+E9o9LjUBqxroONZ2722c5z3h3cqpe86hHNojdDy0uANHljVghvVrP4JPTcFPM9OSg7XKcIx2v1UsOXPDAu+ncXZf4cS3TK8Gg8Fvie2ElNgVqy9w7Ao77IPT4hlEJqnpD5s6DqFzuZUwIDAQAB";

    public static Map<String, String> fillUpBody(String openApi, String appId, Map<String, Object> content) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("appid", appId);
        map.put("openapi", openApi);
        map.put("version", "1");
        map.put("reqTime", DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN));
        map.put("signType", signType);
        map.put("content", JSONUtil.toJsonStr(content));
        try {
            String sign = RSAUtil.doSign(map, "utf-8", privateKey);
            map.put("sign", sign);
        } catch (Exception e) {
            throw new Exception("加签失败: " + e.getMessage(), e);
        }
        System.out.println(JSONUtil.toJsonStr(map));
        return map;
    }

    public static JSONObject getRequestResponse(String requestUrl, String appId, Map<String, String> param) throws Exception {
        log.info("开始请求{}地址", requestUrl);
        String content = JSONUtil.toJsonStr(param);
        HttpRequest httpRequest = HttpRequest.post(requestUrl)
                .header("appId", appId)
                .body(content);
        log.info("httpRequest:" + httpRequest);
        HttpResponse httpResponse = httpRequest.execute();
        log.info("httpResponse:" + httpResponse);
        String response = httpResponse.body();
        log.info("请求{}返回为{}", requestUrl, response);
        if (!JSONUtil.isJson(response)) {
            throw new Exception("请求异常！");
        }
        JSONObject responseJson = JSONUtil.parseObj(response);
        JSONObject ret = responseJson.getJSONObject("content");
        if (ObjectUtil.isNull(ret)) {
            String respMessage = responseJson.getStr("respCodeMsg");
            throw new Exception(respMessage);
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        String openApi = "out_application_login_auth";
        String appId = "cic0000111077";
        String token = "";
        Map<String, Object> content = new HashMap<>();
        content.put("loginCode", token);
        content.put("appId", clientId);
        Map<String, String> stringStringMap = fillUpBody(openApi, appId, content);
        JSONObject requestResponse = getRequestResponse("http://116.62.249.28:18808/openapi/out_application_login_auth/1", appId, stringStringMap);

    }
}
