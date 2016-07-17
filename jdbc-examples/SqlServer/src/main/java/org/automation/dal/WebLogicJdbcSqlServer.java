package org.automation.dal;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by shantonu on 7/18/16.
 */
// main source : https://docs.oracle.com/cd/E13222_01/wls/docs70/mssqlserver4/API_jmsq4.html
public class WebLogicJdbcSqlServer {

    private static final String HOST = "HOST";
    private static final int PORT = 8659;
    private static final String DB = "master";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "weblogic.jdbc.mssqlserver4.Driver";

    public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Driver driver = (Driver) Class.forName(className).newInstance();
        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", pass);
        properties.put("db", DB);
        properties.put("server", HOST);
        properties.put("port", String.valueOf(PORT));
        return driver.connect("weblogic.jdbc.mssqlserver4", properties);
    }


}
