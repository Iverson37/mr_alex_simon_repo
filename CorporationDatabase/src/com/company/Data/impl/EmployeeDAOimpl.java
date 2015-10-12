package com.company.Data.impl;

import com.company.Data.connection.ConncetionSettings;
import com.company.Data.connection.ConnectionToDatabase;
import com.company.Data.EmployeeDAO;
import com.company.Entities.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by semen on 07.10.2015.
 */
public class EmployeeDAOimpl implements EmployeeDAO {

    public EmployeeDAOimpl(){
        try {
            Class.forName(ConncetionSettings.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addEmployee(Employee employee) {
    String employeesInsertQuery = "INSERT INTO employees(name, sername, patronymic, cabinet_number) VALUES(?,?,?,?)";
        String employeesInsertQueryWithoutCabinet="INSERT INTO employees(name, sername, patronymic) VALUES(?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = new ConnectionToDatabase().getConnection();
            connection.setAutoCommit(false);
            if (employee.getCabinetNumber()!= 0) {
            statement = connection.prepareStatement(employeesInsertQuery);
            statement.setString(1,employee.getName());
            statement.setString(2, employee.getSername());
            statement.setString(3, employee.getPatronymic());
            statement.setInt(4, employee.getCabinetNumber());
            }
            else {
                statement = connection.prepareStatement(employeesInsertQueryWithoutCabinet);
                statement.setString(1,employee.getName());
                statement.setString(2, employee.getSername());
                statement.setString(3, employee.getPatronymic());
            }


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
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employeeList  = new ArrayList<>();
        final String getAllEmployeeQuery = "SELECT id, name, sername, patronymic, cabinet_number FROM Employees";

        try(Statement statement = (Statement) new ConnectionToDatabase().getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(getAllEmployeeQuery);
            while (resultSet.next()){
                int employee_id = resultSet.getInt(1);
                String employee_name = resultSet.getString(2);
                String employee_sername = resultSet.getString(3);
                String employee_patronymic = resultSet.getString(4);
                int cabinet_number = resultSet.getInt(5);
                Employee employee = new Employee(employee_id,employee_name,employee_sername,employee_patronymic,cabinet_number);

                employeeList.add(employee);
            }
        }
        System.out.println(employeeList.toString());
        return employeeList;
    }

    @Override
    public void deleteAllEmployees() {

    }
}
