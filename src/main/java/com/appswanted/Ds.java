package com.appswanted;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Ds {
    private static ComboPooledDataSource ds;

    private static void init() throws PropertyVetoException {
        ds = new ComboPooledDataSource();
        //FIXME: replace with config
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost/appswanted");
        ds.setUser("root");
        ds.setPassword("cleopatra");
    }

    public static Connection getConnection() throws PropertyVetoException, SQLException {
        if (ds == null) {
            init();
        }

        return ds.getConnection();
    }
}
