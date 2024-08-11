package com.ian.app;

import com.ian.app.datastructures.binarysearchtree.BinarySearchTree;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree tree = new BinarySearchTree();
        int n = 25;
        int[] keys = new int[n];

        for (int i = 0; i < n; i++) {
            int key = random.nextInt(1000);
            tree.insert(key);
            keys[i] = key;
        }

        tree.print();

        for (int i = 0; i < n; i++) {
            if (!tree.delete(keys[i])) {
                System.out.printf("Failed to delete %d\n", keys[i]);
            }
        }

        tree.print();
    }
}
