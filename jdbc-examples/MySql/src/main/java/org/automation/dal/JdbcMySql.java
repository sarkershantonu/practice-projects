package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/17/16.
 */
public class JdbcMySql {
    public static String url= "jdbc:mysql://<HOST>:<PORT>/<DB>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.mysql.jdbc.Driver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
