package main;

import algorithm.sort.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] arrayToSort = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };

        QuickSort quickSorter = new QuickSort();
        quickSorter.quickSort(arrayToSort, 0, arrayToSort.length - 1);

        // Print out the sorted array
        for (int i : arrayToSort) {
            System.out.print(i + " ");
        }
    }
}

