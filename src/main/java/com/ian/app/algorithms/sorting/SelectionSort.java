package com.ian.app.algorithms.sorting;

// https://en.wikipedia.org/wiki/Selection_sort
// Worst-case performance:      O(n^2) comparisons, O(n) swaps
// Best-case performance:       O(n^2) comparisons (O(n) with best-case check), O(1) swap
// Average performance:         O(n^2) comparisons, O(n) swaps
// Worst-case Space Complexity: O(1) auxiliary

public interface SelectionSort {
    static void sort(int[] array) {
        if (SortingUtilities.arrayIsSorted(array)) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            if (i != smallestIndex) {
                SortingUtilities.swap(array, i, smallestIndex);
            }
        }
    }
}
