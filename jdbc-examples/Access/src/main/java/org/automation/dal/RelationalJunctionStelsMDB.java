package org.automation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by shantonu on 7/10/16.
 * //http://www.sesamesoftware.com/relational-junction/jdbc-database-drivers-products/relational-junction-mdb-jdbc-driver/jdbc-database-drivers-mdb-doc/#Connection Example
 * Note //we need driver download for this => https://documentation.progress.com/output/rb/doc/index.html#page/rb/stelsmdb-access-jdbc-driver.html
 */
public class RelationalJunctionStelsMDB {
    public static String accessDbPath="access.mdb";
    public static String url= "jdbc:relationaljunction:mdb:"+accessDbPath;
    private static final String user = "user";
    private static final String pass = "pass";
    private static final String className = "com.relationaljunction.jdbc.mdb.MDBDriver2";


    public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties props = new java.util.Properties();

        props.put("format", "access2007");
        props.put("ignoreCase", "false");
        Class.forName(className);
        return DriverManager.getConnection(url,props);
    }

    /*
    public static synchronized Connection getConnectionByDataSource(String mdbPath) {
        MDBDataSource2 mdbDS = new MDBDataSource2();
        mdbDS.setPath(mdbPath);
        mdbDS.setFormat("access2007");
        mdbDS.setIgnoreCase("false");
        return mdbDS.getConnection();
    }*/
}
