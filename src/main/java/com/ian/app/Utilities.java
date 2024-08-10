package com.ian.app;

public interface Utilities {
    static void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d", array[i]);

            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
