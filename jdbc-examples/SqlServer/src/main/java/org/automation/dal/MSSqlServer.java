package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/17/16.
 */
public class MSSqlServer {
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://<host>:<port>;databaseName=<db>;integratedSecurity=true;";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        return DriverManager.getConnection(url, user,pass);
    }

    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }

}
