package com.company;

import com.company.Data.CabinetDAO;
import com.company.Data.DeviceDAO;
import com.company.Data.EmployeeDAO;
import com.company.Data.impl.CabinetDAOimpl;
import com.company.Data.impl.DeviceDAOimpl;
import com.company.Data.impl.EmployeeDAOimpl;
import com.company.Data.initialize.TablesCreator;
import com.company.Data.initialize.NewDatabaseCreator;
import com.company.Entities.*;

import java.sql.SQLException;

public class Main {


    public final static String DATABASE_NAME = "employees";

    public static void main(String[] args) throws SQLException {

	//new NewDatabaseCreator(DATABASE_NAME);
   // new TablesCreator().createTables();


        DeviceDAO deviceManager = new DeviceDAOimpl();
        CabinetDAO cabinetsManager = new CabinetDAOimpl();
        EmployeeDAO employeesManager = new EmployeeDAOimpl();
       // deviceManager.getAllDevises();
        cabinetsManager.getAllCabinetsWithEmployees();
       // employeesManager.getAllEmployees();
        /*
        Device printer = new Printer(12341,false);
        Device scanner = new Scanner(12438, false);

        Cabinet cabinet1 = new Cabinet(1, printer, null);*/
       // Employee employee1 = new Employee("Maxim","Andreevich","Mironov",1);

        //deviceManager.addDevice(printer);
        //deviceManager.addDevice(scanner);
        //cabinetsManager.addCabinet(cabinet1);
       // employeesManager.addEmployee(employee1);










    }
}
