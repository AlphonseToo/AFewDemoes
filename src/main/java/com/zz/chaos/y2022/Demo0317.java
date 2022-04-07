package com.zz.chaos.y2022;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo0317 {


    private static String getCurrentRoleOrgIds(String roleId, String userId, String orgType, String tenantId) {
        List<String> orgIdsByRoleCode = new ArrayList<>();
        orgIdsByRoleCode.add("2f4cdfcd5697446e8290d5c8827ff9c9");
        orgIdsByRoleCode.add("a2eb64610d104435881788607c6b847a");
        String condition = "instr(torelation1.org_path, (SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation " +
                "WHERE torelation.org_id = '%s' and torelation.tenantid = %s and torelation.org_type = '%s'))> 0";
        List<String> conditionSql = new ArrayList<>();
        for (String orgId : orgIdsByRoleCode) {
            conditionSql.add(String.format(condition, orgId, tenantId, orgType));
        }
        String result = "(select torelation1.org_id from TSYS_ORG_RELATION torelation1 where torelation1.tenantid = %s and torelation1.org_type = '%s' and (%s))";
        return String.format(result, tenantId, orgType, CollUtil.join(conditionSql, " or "));
    }

    public static String genOrgInSql(List<String> orgIds) {
        if (CollUtil.isEmpty(orgIds)) {
            // 为空则返回("")
            return " in ('')";
        }
        // todo 超过1000的情况下如何处理
        StringBuilder sql = new StringBuilder();
        sql.append("in (");
        for (int i = 0; i < orgIds.size(); i++) {
            sql.append("'").append(orgIds.get(i)).append("'");
            if (i != orgIds.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");
        return sql.toString();
    }

    public static void main(String[] args) {
        String currentRoleOrgIds = getCurrentRoleOrgIds("ats_dev_new", "hyf", "00", "10001");
//        System.out.println(currentRoleOrgIds);
        String s = genOrgInSql(Arrays.asList("a", "b", "c"));
        System.out.println(s);
    }

}
