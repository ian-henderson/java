package com.ian.app.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingUtilitiesTest {
    @Test
    public void isArraySortedShouldConsiderEmptyArraySorted() {
        int[] array = {};
        assertTrue(SortingUtilities.arrayIsSorted(array));
    }

    @Test
    public void isArraySortedShouldDetectUnsortedArray() {
        int[] array = {4, 3, 2, 1};
        assertFalse(SortingUtilities.arrayIsSorted(array));
    }

    @Test
    public void isArraySortedShouldDetectSortedArray() {
        int[] array = {1, 2, 3, 4};
        assertTrue(SortingUtilities.arrayIsSorted(array));
    }

    @Test
    public void swapShouldHandleBaseCase() {
        int[] array = {0};
        SortingUtilities.swap(array, 0, 0);
        assertArrayEquals(array, new int[]{0});
    }

    @Test
    public void swapShouldHandleArrayOfTwoElementsAndValidIndexes() {
        int[] array = {0, 1};
        SortingUtilities.swap(array, 0, 1);
        assertArrayEquals(array, new int[]{1, 0});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void swapShouldHandleOutOfBoundsCase() {
        int[] array = {};
        SortingUtilities.swap(array, 0, 0);
    }
}
