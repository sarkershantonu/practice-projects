package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/4/16.
 */
public class CassandraJdbc {
    public static String port = "9160";
    public static String url= "jdbc:cassandra://<host>:"+port+"/<db>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.apache.cassandra.cql.jdbc.CassandraDriver";


    public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
