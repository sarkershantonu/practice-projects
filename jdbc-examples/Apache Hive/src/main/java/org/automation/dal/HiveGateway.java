package org.automation.dal;

import org.apache.hive.jdbc.HiveDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/4/16.
 */
public class HiveGateway {

    public static String url= "jdbc:hive://<HOST>:<PORT>/<DB>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.apache.hive.jdbc.HiveDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new HiveDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
