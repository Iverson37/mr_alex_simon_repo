package com.simon.common.sorts;

/**
 * Created by semen on 27.09.2015.
 */
public class BubbleSort extends Sort {

    public static int[] sort(int[] a) {
        for (int i = 0; i< a.length - 1; i++)
            for (int j = 0; j< a.length - 1 -i; j++)
                if (a[j]>a[j+1])  swap(a, j, j+1);
        return a;
    }


}
