package com.company.Data;

import com.company.Entities.Cabinet;
import com.company.Entities.Device;
import com.company.Entities.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by semen on 09.10.2015.
 */
public interface DeviceDAO {
    void addDevice(Device device);


    List<Device> getAllDevises() throws SQLException;

}
