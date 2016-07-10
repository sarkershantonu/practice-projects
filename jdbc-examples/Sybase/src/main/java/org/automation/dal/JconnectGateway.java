package org.automation.dal;

import com.sybase.jdbc3.jdbc.SybDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by shantonu on 7/5/16.
 * //http://infocenter.sybase.com/help/index.jsp?topic=/com.sybase.infocenter.dc01776.1604/doc/html/san1357754912881.html
 */
public class JconnectGateway {
    public static String url = "jdbc:sybase:Tds:<host>:<port>/<db>";
    public static Connection getConnection() throws SQLException {
       return  DriverManager.getConnection("jdbc:sybase:Tds:<host>:<port>", "user", "pass");
    }
    public static Connection getConn() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SybDriver driver = (SybDriver) Class.forName("com.sybase.jdbc3.jdbc.SybDriver").newInstance();
        return DriverManager.getConnection("jdbc:sybase:Tds:<host>:<port>", "user", "pass");
    }
}
