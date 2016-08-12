package org.automation.dal;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/10/16.
 * an example from https://github.com/brettwooldridge/HikariCP
 */
public class HikariCPExample {
    public static String url= "jdbc:mysql://<HOST>:<port>/<dbname>";
    public static HikariDataSource ds;
    private static HikariConfig config;
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
    //public static String urlWithCredentials= url+";"+user+";"+pass;
    public static synchronized Connection getConnection() throws SQLException {
        ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);
        return ds.getConnection();
    }
    public static synchronized HikariDataSource getDataSource() throws SQLException {
        ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);
        return ds;
    }
    public static synchronized HikariDataSource getDataSource(HikariConfig config) throws SQLException {
        ds = new HikariDataSource(config);
        return ds;
    }
    public static HikariConfig getDefaultConfig(){// we can use this also for getting the configuration
        config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(pass);
        return config;
    }
}
