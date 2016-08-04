package org.automation.dal;

import org.firebirdsql.jdbc.FBDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/10/16.
 * //http://firebirdsql.org/file/documentation/drivers_documentation/Jaybird_2_1_JDBC_driver_manual.pdf
 *
 */
public class FireBirdGateway {

    public static String pathToDB = "home/db/example.fdb";
    public static String port = "3050";
    public static String url= "jdbc:firebirdsql:<HOST>/"+port+":"+pathToDB;
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "org.firebirdsql.jdbc.FBDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new FBDriver());
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getLegacyConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(className);
        return DriverManager.getConnection(url,user,pass);
    }
}
