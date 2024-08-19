package com.ian.app.algorithms.sorting;

// https://en.wikipedia.org/wiki/Insertion_sort
// Worst case:                  O(n^2) comparisons and swaps
// Best case:                   O(n) comparisons and O(1) swaps
// Average performance:         O(n^2) comparisons and swaps
// Worst-case space complexity: O(n) total, O(1) auxiliary

public interface IInsertionSort {
    public static void sort(int[] array) {
        if (IUtilities.isSorted(array)) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i;

            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = key;
        }
    }
}
