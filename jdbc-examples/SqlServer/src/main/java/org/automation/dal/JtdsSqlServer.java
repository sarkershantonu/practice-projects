package org.automation.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/17/16.
 */
public class JtdsSqlServer {
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "net.sourceforge.jtds.jdbc.Driver";
    private static final String url = "jdbc:jtds:sqlserver://<host>:<port>;instance=SQLEXPRESS;DatabaseName=master";//instance type and db name can be changed , make sure your DB is exposed via TCP/IP


    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection(url, user,pass);
    }

    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
    public static void main(String... args){

    }

}
