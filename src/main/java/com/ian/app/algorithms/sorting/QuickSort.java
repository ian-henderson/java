package com.ian.app.algorithms.sorting;

// https://en.wikipedia.org/wiki/Quicksort
// Worst-case performance:      O(n^2)
// Best-case performance:       O(n*log(n)) (simple partition),
//                                  O(n) (three-way partition and equal keys)
//                                  O(n) with best-case check
// Average performance:         O(n*log(n))
// Worst-case Space Complexity: O(n) auxiliary (naive)
//                              O(log(n)) auxiliary (Hoare 1962)

public interface QuickSort {
    static void sort(int[] array) {
        if (SortingUtilities.arrayIsSorted(array)) {
            return;
        }

        recurse(array, 0, array.length - 1);
    }

    static void recurse(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            recurse(array, left, partitionIndex - 1);
            recurse(array, partitionIndex + 1, right);
        }
    }

    // This function takes the last element as a pivot, places the pivot
    // element at its correct position in sorted array, and places all
    // smaller to left of pivot, and all greater elements to the right of the
    // pivot.
    static int partition(int[] array, int left, int right) {
        int pivot = array[right];

        // Index of smaller element and indicates the right position of pivot
        // found so far
        int i = left - 1;

        for (int j = left; j < right; j++) {
            // if current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                SortingUtilities.swap(array, i, j);
            }
        }

        SortingUtilities.swap(array, i + 1, right);

        return i + 1;
    }
}
