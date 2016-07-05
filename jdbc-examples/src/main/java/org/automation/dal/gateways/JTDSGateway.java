package org.automation.dal.gateways;

/**
 * Created by shantonu on 7/5/16.
 */
class JTDSGateway {
    public static final String url = "jdbc:jtds:sybase://<host>:<ip>/<dbName>";
    public static final String urlLargeLinit = "jdbc:jtds:sybase://<host>:<ip>/<dbName>;batchSize=10000";
    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection(url, "MFILES5", "Mfiles5");
    }
}
