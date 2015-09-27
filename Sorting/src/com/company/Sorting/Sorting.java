package com.company.Sorting;

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



   // protected abstract  int[] sort(int[] array);

    public static void print(int[] array){
        System.out.print("[ ");
        for( int x: array)
            System.out.print(x+" ");
        System.out.print("]");
    }

    protected static void swap(int[] array, int i, int j){
        if( array[i]!=array[j]){
            int c = array[i];
            array[i] = array[j];
            array[j] = c;
        }

    }
}
