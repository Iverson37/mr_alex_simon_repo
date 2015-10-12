package com.company.Data.initialize;

import com.company.Data.connection.ConnectionToDatabase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by semen on 09.10.2015.
 */
public class ExistenceDataBase {
    private String dataBaseName;
    private static boolean existsFlag = false;
    public ExistenceDataBase(String dataBaseName){
        this.dataBaseName = dataBaseName;
    }

    public boolean checkExeistanceDataBase() {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = new ConnectionToDatabase().getConnection();
            DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();
            resultSet = metaData.getCatalogs();

            while (resultSet.next()) {
                if (resultSet.getString(1).equalsIgnoreCase(dataBaseName) == true)
                    existsFlag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return existsFlag;
    }
}
