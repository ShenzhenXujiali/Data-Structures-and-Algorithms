package main;

import algorithm.sort.QuickSort;
import algorithm.sort.QuickSortTest;

public class Main{
    public static void main(String[] args){
        float [] arr = {1,4,3,2};
        QuickSortTest qs = new QuickSortTest();
        qs.quickSort(arr,0,arr.length-1);

        for (float v : arr) {
            System.out.print(v + " ");
        }


    }

}



