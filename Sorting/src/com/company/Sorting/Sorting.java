package com.company.Sorting;

import com.company.Data.GetData;

/**
 * Created by semen on 28.09.2015.
 */
public abstract class Sorting {

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    private int[] array;



    protected abstract  int[] sort(int[] array);

   // protected abstract  int[] sort(int[] array, int start, int end);




    protected static void swap(int[] array, int i, int j){
        if( array[i]!=array[j]){
            int c = array[i];
            array[i] = array[j];
            array[j] = c;
        }

    }
}
