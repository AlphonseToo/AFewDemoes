package com;

import cn.hutool.poi.excel.ExcelReader;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Demo0923 {

    public static void main(String[] args) throws Exception {
        String sql = "-- %d\n" +
                "DECLARE USER_ORG VARCHAR2(100);\n" +
                "ROLE_ORG VARCHAR2(100);\n" +
                "SQLS VARCHAR2(1000);\n" +
                "BEGIN\n" +
                "  SELECT ORG_ID INTO USER_ORG FROM TSYS_USER T WHERE T.USER_ID='%s';\n" +
                "  SELECT ORG_ID INTO ROLE_ORG FROM TSYS_ORGANIZATION T1 WHERE T1.ORG_CODE='%s';\n" +
                "\tSQLS := 'INSERT INTO TSYS_ORG_USER (USER_ID, ORG_ID, ROLE_CODE, TENANTID) VALUES (''%s'', '''|| ROLE_ORG || ''', ''%s'', ''10001'')';\n" +
                "  IF USER_ORG = ROLE_ORG THEN\n" +
                "\tEXECUTE IMMEDIATE 'INSERT INTO TSYS_ROLE_USER (USER_CODE, ROLE_CODE, RIGHT_FLAG, TENANTID) VALUES (''%s'', ''%s'', ''1'', ''10001'')';\n" +
                "  ELSE \n" +
                "\tEXECUTE IMMEDIATE SQLS;\n" +
                "  END IF;\n" +
                "END;\n" +
                "/\n";
        ExcelReader reader = new ExcelReader("C:\\Users\\Mine\\Desktop\\用户角色.xls", 0);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Mine\\Desktop\\role.sql");
        int rowCount = reader.getRowCount();
        for (int i = 1; i < 286; i++) {
            List<Object> objects = reader.readRow(i);
            if (objects.size() == 0) break;
            String nn = (String) objects.get(0);
            String userId = (String) objects.get(1);
            String userName = (String) objects.get(2);
            String orgCodeName = (String) objects.get(3);
            String roleName = (String) objects.get(4);
            String orgCode = orgCodeName.split("-")[0];
            String roleId;
            if ("基地资金岗".equals(roleName)) {
                roleId = "SNZJ005";
            } else if ("基地资金审核岗".equals(roleName)) {
                roleId = "SNZJ006";
            } else {
                throw new Exception("error");
            }
            String finalSql = String.format(sql, i, userId, orgCode, userId, roleId, userId, roleId);
            fileOutputStream.write(finalSql.getBytes(StandardCharsets.UTF_8));
            System.out.println(i + ": " + objects + ": " + finalSql);
        }
        fileOutputStream.write("commit;".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.flush();
        fileOutputStream.close();
        reader.close();
    }
}
