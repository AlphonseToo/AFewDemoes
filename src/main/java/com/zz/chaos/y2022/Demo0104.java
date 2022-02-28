package com.zz.chaos.y2022;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

public class Demo0104 {

    public static void main(String[] args) {
        String value = "1,2,3,4";
        String urids = value.replaceAll("，", StrUtil.COMMA);
        String tenantId = "10001";
        // todo 样版sql
        String templateSql = "SELECT ORG_ID FROM TSYS_ORGANIZATION START WITH ORG_ID = :urid AND tenantid = :tenantid CONNECT BY PRIOR ORG_ID = PARENT_ID";

        List<String> subSqlList = new ArrayList<>();
        for (String urid : urids.split(StrUtil.COMMA)) {
            String s = templateSql.replaceAll(":urid", "'" + urid + "'");
            String sql = s.replaceAll(":tenantid", "'" + tenantId + "'");
            subSqlList.add("(" + sql + ")");
        }
        String join = CollectionUtil.join(subSqlList, " union all ");
        value = "select distinct * from (" + join + ")";
        System.out.println(value);
    }
}
