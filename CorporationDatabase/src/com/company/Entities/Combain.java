package com.company.Entities;

/**
 * Created by semen on 07.10.2015.
 */
public class Combain extends Device {

    public Combain(int number, boolean status) {
        super(number, status);
    }


    public String getName(){
        return "Combine";
    }

    public void Print(){
        System.out.println("Laser printing...");
    }

    public void Scan(){
        System.out.println("Scanning...");
    }

    public void Copy(){
        System.out.println("Copying...");
    }
}
