package com.company.Data.initialize;

import com.company.Data.connection.ConnectionToDatabase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;

/**
 * Created by semen on 08.10.2015.
 */
public class TablesCreator {

    private final String createEmployeesTableQuery = "CREATE TABLE IF NOT EXISTS `Employees` (" +
            "  `id` int(11) NOT NULL auto_increment," +
            "  `name` varchar(30) NOT NULL," +
            "  `sername` varchar(30) NOT NULL," +
            "  `patronymic` varchar(30) NOT NULL," +
            "  `cabinet_number` int(3) default NULL," +
            "  PRIMARY KEY  (`id`)," +
            "FOREIGN KEY (`cabinet_number`) REFERENCES Cabinets(`cabinet_number`)"+
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    private final String createCabinetsTableQuery = "CREATE TABLE IF NOT EXISTS `Cabinets` (" +
            "  `cabinet_number` int(3) NOT NULL ," +
            "  `device_id` int(16) default NULL," +
            "  PRIMARY KEY  (`cabinet_number`)," +
            "FOREIGN KEY (`device_id`) REFERENCES Devices(`device_id`)"+
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    private final String createDevicesTableQuery = "CREATE TABLE IF NOT EXISTS `Devices` (" +
            "  `device_id` int(16) NOT NULL ," +
            " `device_name` varchar(12) NOT NULL,"+
            " `device_condition` boolean default FALSE,"+
            "  PRIMARY KEY  (`device_id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";



    public void createTables() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionToDatabase().getConnection();
            statement = (Statement) connection.createStatement();

            statement.executeUpdate(createDevicesTableQuery);
            statement.executeUpdate(createCabinetsTableQuery);
            statement.executeUpdate(createEmployeesTableQuery);


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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dropTables(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = new ConnectionToDatabase().getConnection();
            statement = (Statement) connection.createStatement();
            statement.executeUpdate("DROP TABLE employees");
            statement.executeUpdate("DROP TABLE cabinets");
            statement.executeUpdate("DROP TABLE devices");
            statement.executeUpdate("DROP TABLE device_names");
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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
