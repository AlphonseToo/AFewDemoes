package com.zz.chaos.y2022;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

public class Demo0321 {

    public static String genUpperOrgSql(List<String> orgIds, String orgType, String tenantId) {
        if (CollUtil.isEmpty(orgIds)) {
            // 为空则返回("")
            return " in ('')";
        }
        String condition = "instr((SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '%s' and torelation.tenantid = %s and torelation.org_type = '%s'), torelation1.org_path)> 0";
        List<String> conditionSql = new ArrayList<>();
        for (String orgId : orgIds) {
            conditionSql.add(String.format(condition, orgId, tenantId, orgType));
        }
        String result = " in (select distinct torelation1.org_id from TSYS_ORG_RELATION torelation1 where torelation1.tenantid = %s and torelation1.org_type = '%s' and (%s))";
        return String.format(result, tenantId, orgType, CollUtil.join(conditionSql, " or "));
    }

    private static String genCurrentAndSubInSql(List<String> orgIds, String orgType, String tenantId) {
        if (CollUtil.isEmpty(orgIds)) {
            // 为空则返回("")
            return " in ('')";
        }
        String condition = "instr(torelation1.org_path, (SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation " +
                "WHERE torelation.org_id = '%s' and torelation.tenantid = %s and torelation.org_type = '%s'))> 0";
        List<String> conditionSql = new ArrayList<>();
        for (String orgId : orgIds) {
            conditionSql.add(String.format(condition, orgId, tenantId, orgType));
        }
        String result = " in (select torelation1.org_id from TSYS_ORG_RELATION torelation1 where torelation1.tenantid = %s and torelation1.org_type = '%s' and (%s))";
        return String.format(result, tenantId, orgType, CollUtil.join(conditionSql, " or "));
    }

    public static void main(String[] args) {
        List<String> orgIds = new ArrayList<>();
        orgIds.add("f33827a23f7e472aa528526dd989e606");
        orgIds.add("0e9740dff0f344cc942ff6261066c350");
        orgIds.add("35b6c54d54af4ad7bd24eef8c65528a6");
        orgIds.add("32d9507869d546af875b02d58ba50b37");
        String orgType = "00";
        String tenantId = "10001";
//        String s = genUpperOrgSql(orgIds, orgType, tenantId);
        String s = genCurrentAndSubInSql(orgIds, orgType, tenantId);
        System.out.println(s);
    }
}
