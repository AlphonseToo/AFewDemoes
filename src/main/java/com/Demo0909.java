package com;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.poi.excel.ExcelReader;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Demo0909 {

    public static void main(String[] args) throws Exception {
        String sql = "-- %d\nDECLARE USER_ORG VARCHAR2(100);\n" +
                "BEGIN\n" +
                "  SELECT ORG_ID INTO USER_ORG FROM TSYS_USER T WHERE T.USER_ID='%s';\n" +
                "  IF USER_ORG = '%s' THEN\n" +
                "\tEXECUTE IMMEDIATE 'INSERT INTO TSYS_ROLE_USER (USER_CODE, ROLE_CODE, RIGHT_FLAG, TENANTID) VALUES (''%s'', ''%s'', ''1'', ''10001'')';\n" +
                "  ELSE \n" +
                "\tEXECUTE IMMEDIATE 'INSERT INTO TSYS_ORG_USER (USER_ID, ORG_ID, ROLE_CODE, TENANTID) VALUES (''%s'', ''%s'', ''%s'', ''10001'')';\n" +
                "  END IF;\n" +
                "END;\n" +
                "/\n";
        ExcelReader reader = new ExcelReader("C:\\Users\\Mine\\Desktop\\会计岗清单(1).xlsx", 0);
        FileReader fileReader = new FileReader("C:\\Users\\Mine\\Desktop\\insert-role.sql");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Mine\\Desktop\\insert-role.sql");
        int rowCount = reader.getRowCount();
        for (int i = 1; i < rowCount; i++) {
            List<Object> objects = reader.readRow(i);
            if (objects.size() == 0) break;
            String orgName = (String) objects.get(0);
            String orgId = (String) objects.get(1);
            String userName = (String) objects.get(2);
            String userId = (String) objects.get(3);
            String roleCode = (String) objects.get(4);
            String finalSql = String.format(sql, i, userId, orgId, userId, roleCode, userId, orgId, roleCode);
            fileOutputStream.write(finalSql.getBytes(StandardCharsets.UTF_8));
            System.out.println(i + ": " + objects + ": " + finalSql);
        }
        fileOutputStream.write("commit;".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.flush();
        fileOutputStream.close();
        reader.close();
    }
}
