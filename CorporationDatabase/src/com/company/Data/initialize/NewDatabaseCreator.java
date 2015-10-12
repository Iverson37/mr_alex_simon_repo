package com.company.Data.initialize;

import com.company.Data.connection.ConnectionToDatabase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;

/**
 * Created by semen on 08.10.2015.
 */
public class NewDatabaseCreator {

    private String dataBaseName;
    private String createDatabaseQuery =
            "CREATE DATABASE " +dataBaseName+" data CHARACTER SET utf8 COLLATE utf8_general_ci";

    public NewDatabaseCreator(String dataBaseName){
        this.dataBaseName=dataBaseName;
        if (new ExistenceDataBase(dataBaseName).checkExeistanceDataBase()==false)
            createDatabase();

    }

    public boolean createDatabase(){
        Boolean flag = false;
        Connection connection = null;
        Statement statement = null;
        try {
            //Загружаем драйвер
            Class.forName("com.mysql.jdbc.Driver");
            connection = new ConnectionToDatabase().getConnection();
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(createDatabaseQuery);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //позакрываем теперь все
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
           return  flag;
    }

}
