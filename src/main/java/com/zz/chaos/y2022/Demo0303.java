package com.zz.chaos.y2022;

public class Demo0303 {

    public static void main(String[] args) {
        String SWITCH_ORG_REGEX = "=[\\s]*:switchorgid";

        String REPLACED_SWITCH_ORG_SQL = " in (select org_id from tsys_org_user where role_code = " +
                ":switchroleid and userid = :userid )";

        String sql = "SELECT tm.org_id FROM tsys_organization tm START WITH tm.ORG_ID = \n\t :" +
                "switchorgid CONNECT BY PRIOR tm.ORG_ID = tm.parent_id";
        String replace = sql.replaceAll(SWITCH_ORG_REGEX, REPLACED_SWITCH_ORG_SQL);
        System.out.println(replace);
    }
}
