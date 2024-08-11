package com.ian.app.algorithms.sorting;

//  https://en.wikipedia.org/wiki/Heapsort
//  Worst-case performance: O(n*log(n))
//  Best-case performance:  O(n*log(n)) (distinct keys) or O(n) (equal keys)
//                          O(n) with best-case check
//  Average performance:    O(n*log(n))
//  Worst-case complexity:  O(n) total O(1) auxiliary

public interface HeapSort {
    static void sort(int[] array) {
        if (SortingUtilities.arrayIsSorted(array)) {
            return;
        }

        int heapSize = array.length;

        // build heap
        for (int root = heapSize / 2 - 1; root >= 0; root--) {
            heapify(array, heapSize, root);
        }

        // extract elements from heap one by one
        for (int i = heapSize - 1; i > 0; i--) {
            // move current root to end
            SortingUtilities.swap(array, 0, i);

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    static void heapify(int[] array, int heapSize, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int largest = root;

        // if the left child is larger than root
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }

        // if right child is larger than largest so far
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != root) {
            SortingUtilities.swap(array, root, largest);

            // recursively heapify the affected subtree
            heapify(array, heapSize, largest);
        }
    }
}
