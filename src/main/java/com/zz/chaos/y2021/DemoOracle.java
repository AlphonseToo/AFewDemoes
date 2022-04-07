package com.zz.chaos.y2021;

import java.sql.*;

/**
 * DemoOceanbase
 *
 * @author Alphonse
 * @version 1.0
 **/
public class DemoOracle {

    public static void main(String[] args) throws Exception {
//        String url = "jdbc:oracle:thin:@10.60.44.229:1521:fingard";
//        String username = "LUNA_ACCOUNTS";
//        String password = "LUNA_ACCOUNTS";
        String url = "jdbc:oracle:thin:@10.60.44.70:1521:orcl";
        String username = "ms_ats_feature_dev";
        String password = "ms_ats_feature_dev";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT t.* FROM tsys_organization t WHERE t.org_id IN ( SELECT torelation2.org_id FROM TSYS_ORG_RELATION torelation2, ( select torelation1.org_id, torelation1.org_path from TSYS_ORG_RELATION torelation1 where torelation1.tenantid = 10001 and torelation1.org_type = '00' and torelation1.org_id in (SELECT org_id from tsys_org_user where user_id = 'hyf' and tenantid = 10001) ) n WHERE instr( torelation2.org_path, n.org_path ) > 0 and torelation2.tenantid = 10001 and torelation2.org_type = '00' AND torelation2.tenantid = 10001 )";
//            String sql = "( SELECT torelation1.org_id FROM TSYS_ORG_RELATION torelation1 WHERE torelation1.tenantid = 10001 AND torelation1.org_type = '00' AND ( instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '0e9740dff0f344cc942ff6261066c350' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '1707613c0d43448eb591f7de25bc85ad' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '183257af56cb4c5696535e6166be3f46' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '2f4cdfcd5697446e8290d5c8827ff9c9' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '32d9507869d546af875b02d58ba50b37' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '3592373870774dc99c1f69715160a91f' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '35b6c54d54af4ad7bd24eef8c65528a6' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '494b4532f08d4a85af7ffdf123860bdb' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '5458509575644177abf919c7579d2495' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '589e455c138a49d586df3059b00c3e6c' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '6000001' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '69c4a6be69e4433da6458d94a06bba53' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '6ce661d85d494652a09ba2a42d68cf61' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '7907ade68bc84f6786f17018eaada5d2' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '793999e9a99d4ee895b0cfb3a7570deb' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '7effb30d82214dde8c65b862d2690a45' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = '8b352a24d0f1446e931656877c570e02' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'a2eb64610d104435881788607c6b847a' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'b0f4862405264b0589057c5f91ac95b3' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'b37f1bc569fd42daa01c4004c2113a3e' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'c183ba0163bc465a8518af3524e8e455' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'c85a7c6fc5de4f01be04a055c33d462c' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'dbe38658fb784499946a4bdc69dd1924' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'dec848a920de48d6b8d2bec824c27203' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'e8082fb1ada844af97d7e238835bf583' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'ecdca632bf1443578cb56d570387f4e2' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'f33827a23f7e472aa528526dd989e606' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'f8478e9a073e4716ab99650b991dde7f' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 OR instr( torelation1.org_path, ( SELECT torelation.org_path FROM TSYS_ORG_RELATION torelation WHERE torelation.org_id = 'fae4bf546ade42f8a9ce101d619deff6' AND torelation.tenantid = 10001 AND torelation.org_type = '00' ) ) > 0 ) )";
            PreparedStatement ps = conn.prepareStatement(sql);
//            PreparedStatement ps = conn.prepareStatement("select count(*) from tsys_user;");
            long start = System.currentTimeMillis();
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("columnCount:" + columnCount);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
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
