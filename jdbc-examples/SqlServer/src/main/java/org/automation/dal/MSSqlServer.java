package org.automation.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

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

    private static final String HOST = "HOST";
    private static final int PORT = 1433;
    private static final String DB = "master";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        return DriverManager.getConnection(url, user,pass);
    }

    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
    public static synchronized Connection getConnectionDS() throws SQLServerException {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setIntegratedSecurity(true);
        dataSource.setServerName(HOST);
        dataSource.setPortNumber(PORT);
        dataSource.setDatabaseName(DB);
        dataSource.setUser(user);
        dataSource.setPassword(pass);
        return dataSource.getConnection();
        //return dataSource.getConnection(user,pass);//use this if you dont include credentials
    }
}
