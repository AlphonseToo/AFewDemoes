package com;

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
        String username = "jats001";
        String password = "jats001";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT rownum RM, V_.*" +
                    "      FROM (select  tf.isoverplan,concat(concat(ti.oppbankaccount, '-'), ti.oppbankaccountname) as oppname, ti.urid" +
                    "            from t_innerpayments ti" +
                    "                     left join t_fundapply tf" +
                    "                               on ti.recordsourcebatno = tf.recordsourcebatno" +
                    "            WHERE PAYDATE >= TO_DATE('2021-06-25', 'YYYY-MM-DD')" +
                    "              AND PAYDATE <= TO_DATE('2021-07-02 23:59:59', 'YYYY-MM-DD HH24:MI:SS') order by ti.paydate desc" +
                    "            ) V_" +
                    "      WHERE ROWNUM <= 50";
            String sql1 = "select * from tsys_user where user_id = 'pql'";
            PreparedStatement ps = conn.prepareStatement(sql1);
//            PreparedStatement ps = conn.prepareStatement("select count(*) from tsys_user;");
            ResultSet rs = ps.executeQuery();
//            DatabaseMetaData metaData = (DatabaseMetaData )rs.getMetaData();
//            System.out.println(metaData.getDatabaseProductName());
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount:" + columnCount);
            System.out.println("result is:");
            for (int i = 0; i < columnCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + " ");
            }
            System.out.println();
            while(rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(rs.getString(i+1) + " ");
                }
                System.out.println();
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
