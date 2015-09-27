package com.simon.common;

import com.simon.common.sorts.BubbleSort;
import com.simon.common.sorts.Sort;

public class Main {

    public static void main(String[] args) {

        int[] ints = new int[]{3,2,1,5,4};
        Sort.print(BubbleSort.sort(ints));
    }
}
