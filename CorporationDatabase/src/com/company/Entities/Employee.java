package com.company.Entities;

/**
 * Created by semen on 07.10.2015.
 */
public class Employee {
    private int id;
    private String name;
    private String sername;
    private String patronymic;
    private int cabinet_number = 0; //default value. if employee has not cabinet yet

    public Employee(String name, String sername, String patronymic) {
        this.name = name;
        this.sername = sername;
        this.patronymic = patronymic;
    }
    public Employee(String name, String sername, String patronymic, int cabinet_number) {
        this.name = name;
        this.sername = sername;
        this.patronymic = patronymic;
        this.cabinet_number = cabinet_number;
    }
    public Employee(int id, String name, String sername, String patronymic, int cabinet_number) {
        this.id = id;
        this.name = name;
        this.sername = sername;
        this.patronymic = patronymic;
        this.cabinet_number = cabinet_number;
    }

    @Override
    public String toString(){
        return "\n[id = "+id+", name = "+name+", sername = "+sername+", patronymic = "+patronymic+", cabinet_number = "+cabinet_number+" ]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getCabinetNumber() {
        return cabinet_number;
    }

    public void setCabinetNumber(int cabinet_number) {
        this.cabinet_number = cabinet_number;
    }


}
