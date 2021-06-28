package com;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

/**
 * DemoTDSql
 *
 * @author Alphonse
 * @version 1.0
 **/
public class DemoTDSql {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://tdsqlshard-f7m038fi.sql.tencentcdb.com:6/luna";
        String username = "luna";
        String password = "Fingard1!";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement("select count(1) from test;");
//            PreparedStatement ps = conn.prepareStatement("select count(*) from tsys_user;");
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
