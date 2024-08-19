package com.ian.app.datastructures;

import com.ian.app.datastructures.redblacktree.RedBlackTree;
import java.util.OptionalInt;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;

public class RedBlackTreeTest {
    private int[] keys = new Random().ints(100_000).toArray();

    @Test
    public void redBlackTreeShouldHaveCorrentHeightWhenEmpty() {
        RedBlackTree tree = new RedBlackTree();
        assertEquals(-1, tree.getHeight());
    }

    @Test
    public void redBlackTreeShouldHaveCorrentHeightWhenOneNode() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(0);
        assertEquals(0, tree.getHeight());
    }

    @Test
    public void redBlackTreeSearchShouldReturnEmptyWhenKeyNotFound() {
        RedBlackTree tree = new RedBlackTree();
        assertEquals(OptionalInt.empty(), tree.search(1));
    }

    @Test
    public void redBlackTreeShouldInsertAndRemoveDatum() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(0);
        OptionalInt result = tree.search(0);
        assertTrue(result.isPresent());
        assertEquals(0, result.getAsInt());

        tree.delete(0);
        result = tree.search(0);
        assertFalse(result.isPresent());
    }

    @Test
    public void redBlackTreeshouldInsertAndRemoveData() {
        RedBlackTree tree = new RedBlackTree();
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
