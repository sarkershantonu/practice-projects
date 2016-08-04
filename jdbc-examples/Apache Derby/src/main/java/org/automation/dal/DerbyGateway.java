package org.automation.dal;

import org.apache.derby.jdbc.ClientDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/10/16.
 */
public class DerbyGateway {

    public static String url= "jdbc:derby://<HOST>:<PORT>/<DB>;create=true";//create example jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.apache.derby.jdbc.ClientDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
    public static synchronized void shutdown() throws SQLException {
        DriverManager.getConnection("jdbc:derby:;shutdown=true");
    }
}
