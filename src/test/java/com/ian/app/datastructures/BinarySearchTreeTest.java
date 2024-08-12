package com.ian.app.datastructures;

import com.ian.app.datastructures.binarysearchtree.BinarySearchTree;
import com.ian.app.datastructures.binarysearchtree.BinarySearchTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    int[] balancedTreeKeys = {13, 7, 19, 4, 10, 16, 22, 2, 5, 8, 11, 14, 17, 20,
            23, 1, 3, 6, 9, 12, 15, 18, 21, 24, 25};

    @Test
    public void deleteShouldReturnFalseWhenKeyNotFound() {
        BinarySearchTree tree = new BinarySearchTree();
        assertFalse(tree.delete(1));
    }

    @Test
    public void searchShouldReturnNullWhenKeyNotFound() {
        BinarySearchTree tree = new BinarySearchTree();
        assertNull(tree.search(1));
    }

    @Test
    public void shouldBeAbleToInsertAndQueryData() {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTreeNode searchResult;

        for (int key : balancedTreeKeys) {
            if (!tree.insert(key)) {
                fail();
            }

            if ((searchResult = tree.search(key)) != null) {
                assertEquals(key, searchResult.getKey());
            } else {
                fail();
            }
        }
    }

    @Test
    public void shouldBeAbleToInsertAndDeleteData() {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTreeNode searchResult;

        for (int key : balancedTreeKeys) {
            if (!tree.insert(key)) {
                fail();
            }

            if ((searchResult = tree.search(key)) != null) {
                assertEquals(key, searchResult.getKey());
            } else {
                fail();
            }
        }

        for (int key : balancedTreeKeys) {
            if (!tree.delete(key)) {
                fail();
            }

            if ((searchResult = tree.search(key)) != null) {
                fail();
            }
        }
    }

    @Test
    public void shouldHaveCorrectHeightWithNoNodes() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals(-1, tree.getHeight());
    }

    @Test
    public void shouldHaveCorrectHeightWithOneNode() {
        BinarySearchTree tree = new BinarySearchTree();
        if (!tree.insert(1)) {
            fail();
        }
        assertEquals(0, tree.getHeight());
    }

    @Test
    public void shouldHaveCorrectHeightWithBalancedTree() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int key : balancedTreeKeys) {
            if (!tree.insert(key)) {
                fail();
            }
        }
        assertEquals(5, tree.getHeight());
    }
}
