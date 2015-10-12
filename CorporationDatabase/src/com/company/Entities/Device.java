package com.company.Entities;

/**
 * Created by semen on 07.10.2015.
 */
public abstract class Device {


    private int number;

    private boolean status = false;

    public abstract String getName();

    public String toString(){
        return getName();
    }
    public Device(int number, boolean status) {
        this.number = number;
        this.status = status;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOn() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
