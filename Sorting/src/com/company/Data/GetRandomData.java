package com.company.Data;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by semen on 28.09.2015.
 */
public class GetRandomData extends GetData {

    public GetRandomData(){
        //super();
        setArray(getRandomArray());
    }

    private int getArraySize(){
        System.out.print("Input size of array:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int[] getRandomArray(){
        int[] arr = new int[getArraySize()];
        Random random = new Random();
        for (int i = 0; i<arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
