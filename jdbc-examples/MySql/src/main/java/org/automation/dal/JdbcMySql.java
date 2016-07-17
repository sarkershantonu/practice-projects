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

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection(url, user, pass);
    }
}
