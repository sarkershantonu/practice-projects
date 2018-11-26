package org.automation.dal;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/3/16.
 */
public class ThinCient {

    public static String url= "jdbc:oracle:thin:@<server>:<port>:<db>";
    //public static String url= "jdbc:oracle:thin:@<server>:<port>/<db>";// if db as service
    private static final String user = "user";
    private static final String pass = "pass";

    public static synchronized Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
