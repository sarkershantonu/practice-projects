package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/10/16.
 * // full driver list, i cound not found in maven repo, so will need to add in lib directory to include local
 */
public class JdbcDB2 {
    public static String url= "jdbc:db2://<HOST>:<PORT>/<DB>";
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.ibm.db2.jcc.DB2Driver";

    public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className).newInstance();
        return DriverManager.getConnection(url,user,pass);
    }
}
