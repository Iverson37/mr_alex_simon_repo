package com.company.Data.impl;

import com.company.Data.CabinetDAO;
import com.company.Data.connection.ConnectionToDatabase;
import com.company.Entities.Cabinet;
import com.company.Entities.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by semen on 10.10.2015.
 */
public class CabinetDAOimpl implements CabinetDAO {

    public void addCabinet(Cabinet cabinet) {
        String sql = "INSERT INTO cabinets (cabinet_number, device_id) VALUES(?,?)";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = new ConnectionToDatabase().getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, cabinet.getNumber());
            statement.setInt(2, cabinet.getDevice_id());

            statement.executeUpdate();
            connection.commit();
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

    @Override
    public Map<Cabinet, List<Employee>> getAllCabinetsWithEmployees() throws SQLException {
        SortedMap<Cabinet,List<Employee>> cabinetWithEmployees  = new TreeMap<>();
        List<Employee> employeeList = new ArrayList<>();
         final String getAllEmployeeQuery = "SELECT id, name, sername, patronymic, Cabinets.cabinet_number, Cabinets.device_id "+
                " FROM Employees inner join Cabinets ON Employees.cabinet_number = Cabinets.cabinet_number ORDER BY Cabinets.cabinet_number"
                ;

        try(Statement statement = (Statement) new ConnectionToDatabase().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(getAllEmployeeQuery);
            while (resultSet.next()){
                int employee_id = resultSet.getInt(1);
                String employee_name = resultSet.getString(2);
                String employee_sername = resultSet.getString(3);
                String employee_patronymic = resultSet.getString(4);
                int cabinet_number = resultSet.getInt(5);
                int device_id = resultSet.getInt(6);

                Employee employee = new Employee(employee_id,employee_name,employee_sername,employee_patronymic,cabinet_number);
                Cabinet cabinet = new Cabinet(cabinet_number,device_id);

                if(cabinetWithEmployees.get(cabinet)!=null){
                List<Employee> listTemp = cabinetWithEmployees.get(cabinet);
                listTemp.add(employee);
                cabinetWithEmployees.put(cabinet, listTemp);}
                else {
                    List<Employee> listTemp = new ArrayList<>();
                    listTemp.add(employee);
                    cabinetWithEmployees.put(cabinet,listTemp);
                }

            }
        }

        for(Map.Entry<Cabinet, List<Employee>> entry : cabinetWithEmployees.entrySet())
            System.out.println(entry.getKey().toString()+entry.getValue().toString());
        return cabinetWithEmployees;
    }
}
