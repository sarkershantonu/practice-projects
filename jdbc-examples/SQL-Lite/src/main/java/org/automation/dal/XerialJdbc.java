package org.automation.dal;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/11/16.
 */
public class XerialJdbc {
    public static String url= "jdbc:sqlite:<DBname>.db";
    private static final String className = "org.sqlite.JDBC";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        return DriverManager.getConnection(url);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url);
    }
}
