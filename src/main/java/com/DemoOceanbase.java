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
        String url = "jdbc:oceanbase:oracle://10.60.44.15:2881/luna_accounts_13";
        String username = "sys@oracle";
        String password = null;
        Connection conn = null;
        try {
            Class.forName("com.alipay.oceanbase.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
//            PreparedStatement ps = conn.prepareStatement("select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual;");
            PreparedStatement ps = conn.prepareStatement("select count(*) from tsys_user;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount:" + columnCount);
            rs.next();
            System.out.println("result is:" + rs.getString(1));
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
