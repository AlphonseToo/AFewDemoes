package com.springsecret.chapter14;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.object.SqlFunction;

import java.sql.SQLException;

/**
 * Test14
 *
 * @author Alphonse
 * @version 1.0
 **/
public class Test14 {

    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/basecore");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setServerTimezone("Asia/Shanghai");
        SqlFunction sqlFunction = new SqlFunction(dataSource, "select count(*) from tsvcmidsearch");
        sqlFunction.compile();
        int run = sqlFunction.run();
        System.out.println(run);
    }
}
