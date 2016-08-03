package org.automation.dal.gateways;

import org.automation.dal.JtdsSybase;
import org.automation.dal.JconnectSybase;
import org.automation.dal.gateways.resultsets.TestQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gateway {

    private Gateway() {
    }

    private static Connection conn = null;
    private static PreparedStatement statement = null;

    public static synchronized ResultSet getResults(String query) throws SQLException {
        conn = JtdsSybase.getConnection();// you can change to jconnect here
        statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

    private static void testJConnect() throws SQLException {
        conn = JconnectSybase.getConnection();
        ResultSet resultSet = conn.createStatement().executeQuery(TestQuery.demo);
        while (resultSet.next()) {
            for (int i = 1; i <= 9; i++) {
                System.out.print("Item " + i + " >>> " + resultSet.getString(i) + "  ");
            }
            System.out.println();
        }
        resultSet.close();
    }

    private static void testJDBC() throws SQLException {
        conn = JtdsSybase.getConnection();
        statement = conn.prepareStatement(TestQuery.demo);
        ResultSet result = statement.executeQuery();
        while (result.next()) {

            for (int i = 1; i <= 9; i++) {
                System.out.print("Item " + i + " >>> " + result.getString(i) + "  ");
            }
            System.out.println();
        }
    }

    public static void closeAll() throws SQLException {

        if (statement != null) {
            statement.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
