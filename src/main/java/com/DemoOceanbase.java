package com;

import java.sql.*;

/**
 * DemoOceanbase
 *
 * @author Alphonse
 * @version 1.0
 **/
public class DemoOceanbase {

    public static void main(String[] args) throws Exception {
        String uu = "mysql --prompt OceanBase(\\u@\\d)> -h 10.60.44.15 -P 2881 -umyob -pmyob123@% -Doceanbase -c";
        String url = "jdbc:oceanbase:oracle://10.60.44.15:2881/SYS";
        String username = "sys@oracle";
        String password = null;
        Connection conn = null;
        try {
            Class.forName("com.alipay.oceanbase.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
//            PreparedStatement ps = conn.prepareStatement("select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual;");
            PreparedStatement ps = conn.prepareStatement("select count(*) from user_tables;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount:" + columnCount);
            rs.next();
            System.out.println("sysdate is:" + rs.getString(1));
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != conn) {
                conn.close();
            }
        }
    }
}
