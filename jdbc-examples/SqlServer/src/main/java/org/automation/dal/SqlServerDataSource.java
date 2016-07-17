package org.automation.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/17/16.
 */
public class SqlServerDataSource {
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String HOST = "HOST";
    private static final int PORT = 1433;
    private static final String DB = "master";

     public static synchronized Connection getConnection() throws SQLServerException {
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
