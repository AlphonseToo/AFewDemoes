package com.springsecret.chapter14;

import org.springframework.jdbc.datasource.AbstractDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * MyDataSource
 *
 * @author Alphonse
 * @version 1.0
 **/
public class MyDataSource extends AbstractDataSource {

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }
}
