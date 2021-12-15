package com;

import cn.hutool.core.util.ObjectUtil;

import java.sql.*;

/**
 * DemoOceanbase
 *
 * @author Alphonse
 * @version 1.0
 **/
public class DemoOracle {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:oracle:thin:@10.60.44.229:1521:fingard";
        String username = "LUNA_ACCOUNTS";
        String password = "LUNA_ACCOUNTS";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement("select * from tsys_user1");
//            PreparedStatement ps = conn.prepareStatement("select count(*) from tsys_user;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount:" + columnCount);
            while(rs.next()) {
                for (int i = 1; i < columnCount + 1; i++) {
                    int type = metaData.getColumnType(i);
                    Object rr;
                    String rrr = rs.getString(i);
                    if (ObjectUtil.isNull(rrr)) {
                        System.out.println("是NULL");
                    }
                    if (type == Types.FLOAT) {
                        rr = rs.getFloat(i);
                    } else if (type == Types.NUMERIC) {
                        rr = rs.getBigDecimal(i);
                    }
                    else {
                        rr = rs.getString(i);
                    }
                    System.out.println("null？ " + rs.wasNull());
                    System.out.println(metaData.getColumnName(i) + ":" + rr);
                }
                System.out.println("---------------");
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
