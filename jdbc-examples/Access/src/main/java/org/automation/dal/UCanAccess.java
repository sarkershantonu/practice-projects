package org.automation.dal;

import net.ucanaccess.jdbc.UcanaccessDriver;
import org.automation.dal.encrypted.FileOpenerByCrypto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 8/4/16.
 */
public class UCanAccess {
    public static String accessDbPath="access.mdb";
    public static String url= UcanaccessDriver.URL_PREFIX+accessDbPath+";newDatabaseVersion=V2003";
    private static final String user = "sa";
    private static final String pass = "pass";
    private static final String className = "net.ucanaccess.jdbc.UcanaccessDriver";

    public static synchronized Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new UcanaccessDriver());//this is optional
        return DriverManager.getConnection(url, user, pass);
    }
    public static synchronized Connection getConnectionWithCrypto() throws SQLException {

        url = url+";jackcessOpener="+ FileOpenerByCrypto.class.getName();
        return DriverManager.getConnection(url, user, pass);
    }
}
