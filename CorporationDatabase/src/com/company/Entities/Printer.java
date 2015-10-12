package com.company.Entities;

/**
 * Created by semen on 07.10.2015.
 */
public class Printer extends Device {

    public Printer(int number, boolean status) {
        super(number, status);

    }

    public String getName(){
        return "Printer";
    }

    public void Print(){
        System.out.println("Printing Blasting...");
    }
}
