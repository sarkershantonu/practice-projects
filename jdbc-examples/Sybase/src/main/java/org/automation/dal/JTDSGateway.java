package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/5/16.
 */
public class JTDSGateway {
    public static final String url = "jdbc:jtds:sybase://<host>:<ip>/<dbName>";
    public static final String urlLargeLinit = "jdbc:jtds:sybase://<host>:<ip>/<dbName>;batchSize=10000";
    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection(url, "user", "pass");
    }
}
