package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/5/16.
 */
public class JtdsSybase {

    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "net.sourceforge.jtds.jdbc.Driver";
    private static final String url = "jdbc:jtds:sybase://<host>:<port>/<db>";
    private static final String urlLargeLinit = "jdbc:jtds:sybase://<host>:<port>/<db>;batchSize=10000";//defining batch size

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection(url, user,pass);
    }

    public static Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
