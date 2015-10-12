package com.company.Data;

import com.company.Entities.Cabinet;
import com.company.Entities.Device;
import com.company.Entities.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by semen on 10.10.2015.
 */
public interface CabinetDAO {

    void addCabinet(Cabinet cabinet);

    Map<Cabinet,List<Employee>> getAllCabinetsWithEmployees() throws SQLException;
}
