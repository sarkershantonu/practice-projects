package org.automation.dal;

import org.firebirdsql.jdbc.FBDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/10/16.
 */
public class FireBirdSqlGateway {
    public static String dbPath="pathToGDBFile";
    public static String url= "jdbc:interbase://<HOST>/"+dbPath;

    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.firebirdsql.jdbc.FBDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new FBDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className);
        return DriverManager.getConnection(url,user,pass);
    }
}
