package com.zz.chaos.y2021;

import java.io.File;

public class Demo0917 {

    public static void main(String[] args) {
        String tag = "tag";
        String body = "{}";
        System.out.println("角色同步接收mq消息：[tag: " + tag + ", body: " + body + "]");
        File file = new File("D:\\项目\\绩效人才盘点\\绩效管理系统V3.0.0-人才盘点\\绩效管理系统(人才盘点).rp");
        double v = file.length() / 1024.0 / 1024.0 / 1024.0;
        System.out.println(v);
        System.out.println(v <= -1);
        System.out.println(file.getName());
        String sql = "INSERT INTO TSYS_USER (URID, NAME, MOBILE, EMAIL, PASSWORD, ORIGINAL_PASSWORD, PWD_MODIFY_DATE, EMPLOYEE_NUMBER, ENTRY_TIME, ORG_ID, POSITION_TITLE, POSITION_LEVEL, DIRECT_MANAGER, AREA_MANAGER, OKR_SUBMISSION_TYPE, EVALUATION_TYPE, USER_TYPE, USER_STATUS, LOCK_STATUS, CREATOR, CREATE_DATE, UPDATOR, UPDATE_DATE, VERSION, REMARK, DEPARTURE_TIME) \n" +
                "VALUES ('%s', '%s', '13310210812', 'wuzhengwai@1.com', 'C5D8778DB1AF537A4EC633854AE8177D62C5B1EA69EC0EF0188818FE842BD24A', " +
                "'C5D8778DB1AF537A4EC633854AE8177D62C5B1EA69EC0EF0188818FE842BD24A', TO_DATE('2019-02-22 14:51:03', " +
                "'SYYYY-MM-DD HH24:MI:SS'), '%s', TO_DATE('2017-11-06 00:00:00', 'SYYYY-MM-DD HH24:MI:SS'), '05e0ac6cdbc647a3a7e765c274b2eced', '研发工程师', '5', NULL, NULL, '0', '1', '1', '0', '0', 'aada00a3fda141c9850e2052fbdacc4a', TO_DATE('2019-02-22 14:51:03', 'SYYYY-MM-DD HH24:MI:SS'), 'aada00a3fda141c9850e2052fbdacc4a', TO_DATE('2019-02-22 14:51:04', 'SYYYY-MM-DD HH24:MI:SS'), '2', NULL, NULL);";
        for (int i = 355; i < 400; i++) {
            String ss = String.format(sql, i+8000, i, i+8000);
            System.out.println(ss);
        }
    }
}
