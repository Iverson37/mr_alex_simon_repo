package com.company.Data.impl;

import com.company.Data.DeviceDAO;
import com.company.Data.connection.ConnectionToDatabase;
import com.company.Entities.Combain;
import com.company.Entities.Device;
import com.company.Entities.Printer;
import com.company.Entities.Scanner;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by semen on 10.10.2015.
 */
public class DeviceDAOimpl implements DeviceDAO {
    @Override
    public void addDevice(Device device) {
        final String deviceInsertQuery = "INSERT INTO devices (device_id, device_name, device_condition) VALUES(?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = new ConnectionToDatabase().getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deviceInsertQuery);
            statement.setInt(1, device.getNumber());
            statement.setString(2, device.getName());
            statement.setBoolean(3, device.isOn());

            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
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

    @Override
    public List<Device> getAllDevises() throws SQLException {
       List<Device> deviceList = new ArrayList<>();
       final String getAllDeviceQuery = "SELECT device_id, device_name, device_condition FROM Devices";

        try(Statement statement = (Statement) new ConnectionToDatabase().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(getAllDeviceQuery);
            while (resultSet.next()){
                int device_id = resultSet.getInt(1);
                String device_name = resultSet.getString(2);
                Boolean device_status = resultSet.getBoolean(3);
                Device device = null;
                if (device_name.equalsIgnoreCase("printer")) device = new Printer(device_id,device_status);
                if (device_name.equalsIgnoreCase("scanner")) device = new Scanner(device_id,device_status);
                if (device_name.equalsIgnoreCase("combain")) device = new Combain(device_id,device_status);
                deviceList.add(device);
            }
        }

        return deviceList;
    }
}
