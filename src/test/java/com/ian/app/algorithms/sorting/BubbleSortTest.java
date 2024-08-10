package com.ian.app.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleSortTest {
    @Test
    public void shouldHandleEmptyArray() {
        int[] array = {};
        BubbleSort.sort(array);
        assertEquals(array.length, 0);
    }

    @Test
    public void shouldHandleArrayWithOneInt() {
        int[] array = {0};
        BubbleSort.sort(array);
        assertArrayEquals(array, new int[]{0});
    }

    @Test
    public void shouldHandleSortedArray() {
        int[] array = {1, 2, 3, 4};
        BubbleSort.sort(array);
        assertArrayEquals(array, new int[]{1, 2, 3, 4});
    }

    @Test
    public void shouldSortUnsortedArray() {
        int[] array = {4, 3, 2, 1};
        BubbleSort.sort(array);
        assertArrayEquals(array, new int[]{1, 2, 3, 4});
    }
}
