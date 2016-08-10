package org.automation.dal;

import org.hsqldb.jdbc.JDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/10/16.
 */
public class JDBCHSql {

    public static String url= "jdbc:hsqldb:hsql://<HOST>:<port>/<dbname>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.hsqldb.jdbc.JDBCDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new JDBCDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className);
        return DriverManager.getConnection(url,user,pass);
    }
}
