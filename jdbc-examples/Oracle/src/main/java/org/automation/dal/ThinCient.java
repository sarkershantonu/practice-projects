package org.automation.dal;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/3/16.
 */
public class ThinCient {

    public static String url= "jdbc:oracle:thin://<HOST>:<PORT>/<DB>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "oracle.jdbc.driver.OracleDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver();
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:mkyong", "username",
                "password");
    }
}
