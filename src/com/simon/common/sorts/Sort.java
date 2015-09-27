package com.simon.common.sorts;

/**
 * Created by semen on 27.09.2015.
 */

    public class Sort {

    //public abstract static int[] sort(int[] a);

    public static void print(int[] a){
        System.out.print("[ ");
        for(int x: a){
            System.out.print(x+" ");
        }
        System.out.print("]");

    }

     static void swap(int[]a, int i, int j){
        if (a[i]!=a[j]){
            int c = a[i];
            a[i] = a[j];
            a[j] = c;
        }
    }
}
