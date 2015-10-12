package com.company.Entities;

/**
 * Created by semen on 07.10.2015.
 */
public class Scanner extends Device {

    public Scanner(int number, boolean status) {
        super(number, status);
    }

    public String getName(){
        return "Scanner";
    }

    public void Scan(){
        System.out.println("Scanning...");
    }
}
