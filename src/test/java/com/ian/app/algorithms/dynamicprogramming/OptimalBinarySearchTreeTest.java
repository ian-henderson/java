package com.ian.app.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptimalBinarySearchTreeTest {
    @Test
    public void memoizedSolutionShouldHandleBaseCase() {
        int[] p = {};
        assertEquals(0,
                OptimalBinarySearchTree.costOfOptimalBstMemoized(p));
    }

    @Test
    public void memoizedSolutionShouldHandleOneProbability() {
        int[] p = {34};
        assertEquals(34,
                OptimalBinarySearchTree.costOfOptimalBstMemoized(p));
    }

    @Test
    public void memoizedSolutionShouldHandleNCase() {
        int[] p = {34, 8, 50};
        assertEquals(142,
                OptimalBinarySearchTree.costOfOptimalBstMemoized(p));
    }

    @Test
    public void naiveSolutionShouldHandleBaseCase() {
        int[] p = {};
        assertEquals(0,
                OptimalBinarySearchTree.costOfOptimalBstNaive(p));
    }

    @Test
    public void naiveSolutionShouldHandleOneProbability() {
        int[] p = {34};
        assertEquals(34,
                OptimalBinarySearchTree.costOfOptimalBstNaive(p));
    }

    @Test
    public void naiveSolutionShouldHandleNCase() {
        int[] p = {34, 8, 50};
        assertEquals(142,
                OptimalBinarySearchTree.costOfOptimalBstNaive(p));
    }
}
