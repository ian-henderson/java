package com.ian.app.datastructures;

import com.ian.app.datastructures.binarysearchtree.BinarySearchTree;
import java.util.OptionalInt;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    int[] keys = { 13, 7, 19, 4, 10, 16, 22, 2, 5, 8, 11, 14, 17, 20, 23, 1, 3,
            6, 9, 12, 15, 18, 21, 24, 25 };

    @Test
    public void shouldHaveCorrectHeightWithNoNodes() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals(-1, tree.getHeight());
    }

    @Test
    public void shouldHaveCorrectHeightWithOneNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        assertEquals(0, tree.getHeight());
    }

    @Test
    public void shouldHaveCorrectHeightWithBalancedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int key : keys) {
            tree.insert(key);
        }
        assertEquals(5, tree.getHeight());
    }

    @Test
    public void binarySearchTreeSearchShouldReturnEmptyWhenKeyNotFound() {
        BinarySearchTree tree = new BinarySearchTree();
        OptionalInt result = tree.search(1);
        assertFalse(result.isPresent());
    }

    @Test
    public void binarySearchTreeShouldInsertAndDeleteData() {
        BinarySearchTree tree = new BinarySearchTree();
        OptionalInt result;

        for (int key : keys) {
            tree.insert(key);
            result = tree.search(key);
            assertTrue(result.isPresent());
            assertEquals(key, result.getAsInt());
        }

        for (int key : keys) {
            tree.delete(key);
            result = tree.search(key);
            assertFalse(result.isPresent());
        }
    }
}
