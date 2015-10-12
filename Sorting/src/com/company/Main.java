package com.company;


import com.company.Data.GetData;
import com.company.Data.GetDataFromFile;
import com.company.Data.GetRandomData;
import com.company.Sorting.BubbleSort;
import com.company.Sorting.Sorting;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {


         String standartPath = "\\dataForExample\\example.txt";



       GetDataFromFile getDataFromFile = new GetDataFromFile();
        String[] s = getDataFromFile.readFile(new File(standartPath));
        System.out.println(Arrays.toString(GetDataFromFile.stringArrayToIntArray(s)));

    }

     private static void print(Sorting sorting){
        int[] array = sorting.getArray();
        System.out.print("[ ");
        for( int x: array)
            System.out.print(x+" ");
        System.out.print("]");
    }
}

