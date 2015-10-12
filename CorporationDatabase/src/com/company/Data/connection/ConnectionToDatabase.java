package com.company.Data.connection;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by semen on 08.10.2015.
 */
public class ConnectionToDatabase {

    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(ConncetionSettings.getUrl(), ConncetionSettings.getUser(), ConncetionSettings.getPassword());
    }

}
