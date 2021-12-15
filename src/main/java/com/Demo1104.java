package com;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.List;

public class Demo1104 {

    public static void main(String[] args) {
        String s = "SELECT *\n" +
                "        FROM (SELECT '1' as ISALLOCATE, sysRole.ROLE_CODE, sysRole.ROLE_NAME, sysRole.URID ROLE_ID\n" +
                "        FROM TSYS_ROLE sysRole\n" +
                "        LEFT JOIN TSYS_ORG_USER orgUser ON sysRole.URID = orgUser.ROLE_ID\n" +
                "        WHERE sysRole.Urid IN\n" +
                "        (SELECT orgUser.Role_Id\n" +
                "        FROM TSYS_ORG_USER orgUser\n" +
                "        WHERE orgUser.Role_Id IS NOT NULL\n" +
                "        AND orgUser.ORG_ID = :orgId\n" +
                "        AND orgUser.USER_ID = :userId)\n" +
                "        AND sysRole.TENANT_ID =:tenantId\n" +
                "        UNION\n" +
                "        SELECT '0' as ISALLOCATE, sysRole.ROLE_CODE, sysRole.ROLE_NAME, sysRole.URID ROLE_ID\n" +
                "        FROM TSYS_ROLE sysRole\n" +
                "        LEFT JOIN TSYS_ORG_USER orgUser ON sysRole.URID = orgUser.ROLE_ID\n" +
                "        WHERE sysRole.Urid NOT IN\n" +
                "        (SELECT orgUser.Role_Id\n" +
                "        FROM TSYS_ORG_USER orgUser\n" +
                "        WHERE orgUser.Role_Id IS NOT NULL\n" +
                "        AND orgUser.ORG_ID = :orgId\n" +
                "        AND orgUser.USER_ID = :userId)\n" +
                "        AND sysRole.TENANT_ID = :tenantId) MUL_ROLE ";
//        System.out.println(s);
        String content = "[\"1\",\"2\",\"3\",\"4\",\"5\"]";
        List<String> objects = JSONUtil.parseArray(content).toList(String.class);
        System.out.println(objects);
        String c = "{\"HttpCode\":200,\"userInfo\":{\"sub\":\"157\",\"accId\":\"157\",\"username\":\"zhanghao1\"}}";
        JSONObject jsonObject = JSONUtil.parseObj(c);
        String userInfo = jsonObject.getStr("userInfo");
        JSONObject user = JSONUtil.parseObj(userInfo);
        String accId = user.getStr("accId");
        System.out.println(accId);
        String token = "{\"accessToken\":\"960a1f10-cbe2-470e-ad19-717a1745af32\",\"expiresIn\":\"7199\",\"refreshToken\":\"3ef1b1d5-fe60-43c6-9c27-58b9f2f77573\"}";
        JSONObject jsonObject1 = JSONUtil.parseObj(token);
        String accessToken = jsonObject1.getStr("accessToken");
        System.out.println(accessToken);
    }
}
