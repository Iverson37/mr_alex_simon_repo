package com.company.Data;

import com.company.Entities.Cabinet;
import com.company.Entities.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by semen on 07.10.2015.
 */
public interface EmployeeDAO {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees() throws SQLException;

    void deleteAllEmployees();

}
