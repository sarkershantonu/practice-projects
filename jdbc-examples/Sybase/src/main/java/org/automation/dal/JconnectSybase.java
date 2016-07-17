package org.automation.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/5/16.
 * //http://infocenter.sybase.com/help/index.jsp?topic=/com.sybase.infocenter.dc01776.1604/doc/html/san1357754912881.html
 */
public class JconnectSybase {

    public static String url= "jdbc:sybase:Tds:<host>:<port>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.sybase.jdbc3.jdbc.SybDriver";


    public static Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.sybase.jdbc3.jdbc.SybDriver());
        return DriverManager.getConnection(url, user, pass);
    }
}
