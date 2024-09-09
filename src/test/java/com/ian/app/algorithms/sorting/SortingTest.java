package com.ian.app.algorithms.sorting;

import java.util.Random;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SortingTest {
    private int[] unsortedKeys = new Random().ints(50_000).toArray();

    @Test
    public void bubbleSortShouldSortCorrectly() {
        int[] keys = unsortedKeys.clone();
        IBubbleSort.sort(keys);
        assertTrue(IUtilities.isSorted(keys));
    }

    @Test
    public void heapSortShouldSortCorrectly() {
        int[] keys = unsortedKeys.clone();
        IHeapSort.sort(keys);
        assertTrue(IUtilities.isSorted(keys));
    }

    @Test
    public void insertionSortShouldSortCorrectly() {
        int[] keys = unsortedKeys.clone();
        IInsertionSort.sort(keys);
        assertTrue(IUtilities.isSorted(keys));
    }

    @Test
    public void mergeSortShouldSortCorrectly() {
        int[] keys = unsortedKeys.clone();
        IMergeSort.sort(keys);
        assertTrue(IUtilities.isSorted(keys));
    }

    @Test
    public void quickSortShouldSortCorrectly() {
        int[] keys = unsortedKeys.clone();
        IQuickSort.sort(keys);
        assertTrue(IUtilities.isSorted(keys));
    }

    @Test
    public void selectionSortShouldSortCorrectly() {
        int[] keys = unsortedKeys.clone();
        ISelectionSort.sort(keys);
        assertTrue(IUtilities.isSorted(keys));
    }
}
