package com.ian.app.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RodCuttingTest {
    @Test
    public void memoizedSolutionShouldHandleBaseCase() {
        int[] p = {1};
        int x = 1;
        assertEquals(1, RodCutting.computeMaxProfitMemoized(p, x));
    }

    @Test
    public void memoizedSolutionShouldHandleNCase() {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int x = 9;
        assertEquals(25, RodCutting.computeMaxProfitMemoized(p, x));
    }

    @Test
    public void naiveSolutionShouldHandleBaseCase() {
        int[] p = {1};
        int x = 1;
        assertEquals(1, RodCutting.computeMaxProfitNaive(p, x));
    }

    @Test
    public void naiveSolutionShouldHandleNCase() {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int x = 9;
        assertEquals(25, RodCutting.computeMaxProfitNaive(p, x));
    }

    @Test
    public void tabulatedSolutionShouldHandleBaseCase() {
        int[] p = {1};
        int x = 1;
        assertEquals(1, RodCutting.computeMaxProfitTabulated(p, x));
    }

    @Test
    public void tabulatedSolutionShouldHandleNCase() {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int x = 9;
        assertEquals(25, RodCutting.computeMaxProfitTabulated(p, x));
    }
}
