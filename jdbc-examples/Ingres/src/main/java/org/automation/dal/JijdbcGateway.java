package org.automation.dal;

import com.ingres.jdbc.IngresDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/10/16.
 */
public class JijdbcGateway {
    public static String url= "jdbc:ingres://<HOST>:<port>/<dbname>";

    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.ingres.jdbc.IngresDriver";
    public static String urlWithCredentials= "jdbc:ingres://<HOST>:<port>/<dbname>;"+user+";"+pass;
    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new IngresDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className);
        return DriverManager.getConnection(url,user,pass);
    }
}
