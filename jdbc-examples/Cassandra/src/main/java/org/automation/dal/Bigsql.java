package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/4/16.
 */
public class Bigsql {

    public static String port = "9160";
    public static String url= "jdbc:cassandra://<host1>--<host2>--<host3>:"+port+"/keyspace1?primarydc=DC1&backupdc=DC2&consistency=QUORUM";// check these parameter to have proper configuration, best way, read property
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.bigsql.cassandra2.jdbc.CassandraDriver";


    public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
