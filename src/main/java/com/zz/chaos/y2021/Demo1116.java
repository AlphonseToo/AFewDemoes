package com.zz.chaos.y2021;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo1116 {

    public static void main(String[] args) {
        List<String> allChildOrgIds = new ArrayList<>();
        allChildOrgIds.add("1");
        allChildOrgIds.add("2");
        allChildOrgIds.add("3");
        allChildOrgIds.add("4");
        List<List<String>> split = CollectionUtil.split(allChildOrgIds, 1);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        boolean first = true;
        for (List<String> orgIds : split) {
            if (!first) {
                sb.append(" or ");
            }
            sb.append("t.user_org_id in (");
            orgIds.forEach(item -> sb.append("'" + item + "',"));
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            first = false;
        }
        sb.append(")");
        System.out.println(sb);
        String tenantId = "10001";
        String switchorgid = "6000001";
        String value= "600001";
        String orgidinSql = "torganization.org_path like (select torganizationpath.org_path || '%' from TSYS_ORGANIZATION torganizationpath where torganizationpath.ORG_ID = '" + switchorgid + "')";
        value = "(select torganization.org_id from TSYS_ORGANIZATION torganization where torganization.status = 0 and torganization.TENANTID = " + tenantId + " and (" + orgidinSql + "))";
        System.out.println(value);
        System.out.println(value.contains(","));

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        List<String> list2 = new ArrayList<>();
        list2.add("11");
        list2.add("2");
        Collection<String> intersection = CollectionUtil.intersection(list1, list2);
        List<String> stringList = new ArrayList<>(intersection);
        System.out.println(stringList);
    }
}
