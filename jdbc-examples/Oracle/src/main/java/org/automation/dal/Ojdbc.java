package org.automation.dal;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/5/16.
 */
public class Ojdbc {

    public static String url= "jdbc:oracle:oci://<HOST>:<PORT>/<DB>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "oracle.jdbc.driver.OracleDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
