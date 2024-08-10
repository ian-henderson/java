package com.ian.app.algorithms.sorting;

//  https://en.wikipedia.org/wiki/Bubble_sort
//  Worst-case performance: O(n^2), O(n^2) swaps
//  Best-case performance:  O(n), O(1) swap
//  Average-case performance: O(n^2), O(n^2) swaps
//  Worst-case complexity:  O(n) total O(1) auxiliary

public interface BubbleSort {
    static void sort(int[] array) {
        if (SortingUtilities.arrayIsSorted(array)) {
            return;
        }

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    SortingUtilities.swap(array, j, j + 1);
                }
            }
        }
    }
}
