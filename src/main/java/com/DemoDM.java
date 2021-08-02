package com;

import java.sql.*;

/**
 * DemoDM
 *
 * @author Alphonse
 * @version 1.0
 **/
public class DemoDM {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:dm://10.60.44.54:5236";
        String username = "LUNA";
        String password = "123456789";
        Connection conn = null;
        try {
            Class.forName("dm.jdbc.driver.DmDriver");
            conn = DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData1 = conn.getMetaData();
            System.out.println(metaData1.getDatabaseProductName());
            PreparedStatement ps = conn.prepareStatement("select * from tsys_user1;");
//            PreparedStatement ps = conn.prepareStatement("select count(*) from tsys_user;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount:" + columnCount);
            while(rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.println(metaData.getColumnName(i+1) + ":" + rs.getString(i+1));
                }
            }
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
