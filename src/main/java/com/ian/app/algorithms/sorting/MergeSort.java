package com.ian.app.algorithms.sorting;

//  https://en.wikipedia.org/wiki/Merge_sort
//  Worst-case performance:      O(n*log(n))
//  Best-case performance:       Omega(n*log(n)), O(n) with best-case check
//  Average performance:         Theta(n*log(n))
//  Worst-case space complexity: O(n) total with O(n) auxiliary, O(1) auxiliary
//                                  with linked lists

public interface MergeSort {
    static void sort(int[] array) {
        if (SortingUtilities.arrayIsSorted(array)) {
            return;
        }

        recurse(array, 0, array.length - 1);
    }

    static void recurse(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        recurse(array, left, mid);
        recurse(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    static void merge(int[] array, int left, int mid, int right) {
        int subArrayOne = mid - left + 1;
        int subArrayTwo = right - mid;

        int[] leftArray = new int[subArrayOne];
        int[] rightArray = new int[subArrayTwo];

        // copy data to temp arrays
        for (int i = 0; i < subArrayOne; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < subArrayTwo; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int indexOfSubArrayOne = 0;
        int indexOfSubArrayTwo = 0;
        int indexOfMergedArray = left;

        // merge the temp arrays back into array[left...right]
        while (indexOfSubArrayOne < subArrayOne && indexOfSubArrayTwo < subArrayTwo) {
            if (leftArray[indexOfSubArrayOne] <= rightArray[indexOfSubArrayTwo]) {
                array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
                indexOfSubArrayOne++;
            } else {
                array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
                indexOfSubArrayTwo++;
            }

            indexOfMergedArray++;
        }

        // copy the remaining elements of leftArray if there are any
        while (indexOfSubArrayOne < subArrayOne) {
            array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
            indexOfSubArrayOne++;
            indexOfMergedArray++;
        }

        // copy the remaining elements of rightArray if there are any
        while (indexOfSubArrayTwo < subArrayTwo) {
            array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
            indexOfSubArrayTwo++;
            indexOfMergedArray++;
        }
    }
}
