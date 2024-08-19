package com.ian.app.algorithms.sorting;

public interface IUtilities {
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void swap(int[] array, int x, int y) throws IndexOutOfBoundsException {
        if (x > array.length - 1) {
            throw new IndexOutOfBoundsException("Index x out of bounds: " + x);
        }

        if (y > array.length - 1) {
            throw new IndexOutOfBoundsException("Index y out of bounds: " + y);
        }

        if (x == y) {
            return;
        }

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
