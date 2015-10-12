package com.company.Sorting;

import com.company.Data.GetData;



/**
 * Created by semen on 28.09.2015.
 */
public class BubbleSort extends Sorting {


    public BubbleSort(GetData data){
      //  super();
        setArray(sort(data.getArray()));
    }

   // @Override
   protected int[] sort(int[] a) {
        for (int i = 0; i <a.length - 1  ; i++) {
            for (int j = 0; j <a.length - 1 - i ; j++) {
                if (a[j]>a[j+1]) swap(a,j,j+1);
            }
        }
        return a;
    }
}
