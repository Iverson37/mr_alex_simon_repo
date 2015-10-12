package com.company.Entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by semen on 07.10.2015.
 */
public class Cabinet implements Comparable {
    private int number;



    private int device_id;
    //private List<Employee> employeeList = new ArrayList<Employee>();

    public Cabinet(int id, int device_id) {
        this.number = id;
        this.device_id = device_id;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    @Override
    public String toString(){
        return "cabinet #"+number;
    }
    @Override
    public int compareTo(Object o) {
        Cabinet cabinet = (Cabinet)o;
        return number > cabinet.number ? 1 : number == cabinet.number ? 0 : -1;
    }
}
