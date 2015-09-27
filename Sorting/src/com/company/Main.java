package com.company;


import com.company.Data.GetData;
import com.company.Data.GetRandomData;
import com.company.Sorting.BubbleSort;
import com.company.Sorting.Sorting;

public class Main {

    public static void main(String[] args) {


        Sorting.print(new BubbleSort(new GetRandomData()).getArray());

        
    }
}
