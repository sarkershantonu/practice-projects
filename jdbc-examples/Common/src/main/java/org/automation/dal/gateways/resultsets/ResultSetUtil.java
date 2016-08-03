package org.automation.dal.gateways.resultsets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUtil {

    public static List<List<String>> readAllResultAsTable(ResultSet resultset, int columnNumber) throws SQLException {
        List<List<String>> out = new ArrayList<>();
        while(resultset.next()){
            List<String> aRecord = new ArrayList<>();
            for (int i=1;i<=columnNumber;i++){
                aRecord.add(resultset.getString(i));
            }
            out.add(aRecord);
        }
        return out;
    }

    public static List<List<String>> readAllResultAsTable(ResultSet resultset) throws SQLException {
        int colum = resultset.getMetaData().getColumnCount();
        return readAllResultAsTable(resultset,colum);
    }

    public static void print(ResultSet resultSet) throws SQLException {
        List<List<String>> table  = readAllResultAsTable(resultSet);
        for(List<String> aRow : table){
            System.out.println(aRow.toString());
        }
    }
    public static int getColumnCount(ResultSet resultSet) throws SQLException {
        return resultSet.getMetaData().getColumnCount();
    }
    public static int getRowCount(ResultSet resultSet) throws SQLException {
        resultSet.last();
        return resultSet.getRow();
    }

}
