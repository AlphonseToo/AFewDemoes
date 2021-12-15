package com;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

public class Demo1130 {
    public static void main(String[] args) {
        String value = "1,2,3,4,5";
        String orgIds = value.replaceAll("，", StrUtil.COMMA);
        List<String> orgidinSqlList = new ArrayList<>();
        for (String orgid : orgIds.split(StrUtil.COMMA)) {
            String orgidinSql = "'" + orgid + "'";
            orgidinSqlList.add(orgidinSql);
        }
        String orgidinSql = "torganization.org_id in (" + StrUtil.join(", ", orgidinSqlList) + ")";
        System.out.println(orgidinSql);
    }
}
