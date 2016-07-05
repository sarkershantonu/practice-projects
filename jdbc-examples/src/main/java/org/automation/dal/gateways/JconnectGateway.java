package org.automation.dal.gateways;

/**
 * Created by shantonu on 7/5/16.
 */
class JconnectGateway {
    public static String url = "jdbc:sybase:Tds:<host>:<port>/<db>";
    public static Connection getConnection() throws SQLException {
       return  DriverManager.getConnection("jdbc:sybase:Tds:<host>:<port>", "user", "pass");
    }
    public static Connection getConn() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SybDriver driver = (SybDriver) Class.forName("com.sybase.jdbc3.jdbc.SybDriver").newInstance();
        return DriverManager.getConnection("jdbc:sybase:Tds:<host>:<port>", "user", "pass");
    }
}
