package com.ian.app.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixChainMultiplicationTest {
    @Test
    public void memoizedImplementationShouldHandleBaseCase() throws Exception {
        int p[] = {40, 20}; // One 40x20 matrix
        assertEquals(0,
                MatrixChainMultiplication.computeMinNumberOfMultiplicationsMemoized(p));
    }

    @Test
    public void memoizedImplementationShouldHandleNCase() throws Exception {
        // 4 matrices of dimensions 40x20, 20x30, 30x10, and 10x30
        int p[] = {40, 20, 30, 10, 30};
        assertEquals(26000,
                MatrixChainMultiplication.computeMinNumberOfMultiplicationsMemoized(p));
    }

    @Test(expected = Exception.class)
    public void memoizedImplementationShouldThrowWhenInvalidPIsUsed() throws Exception {
        int p[] = {40};
        MatrixChainMultiplication.computeMinNumberOfMultiplicationsMemoized(p);
    }

    @Test
    public void naiveImplementationShouldHandleBaseCase() throws Exception {
        int p[] = {40, 20}; // One 40x20 matrix
        assertEquals(0,
                MatrixChainMultiplication.computeMinNumberOfMultiplicationsNaive(p));
    }

    @Test
    public void naiveImplementationShouldHandleNCase() throws Exception {
        // 4 matrices of dimensions 40x20, 20x30, 30x10, and 10x30
        int p[] = {40, 20, 30, 10, 30};
        assertEquals(26000,
                MatrixChainMultiplication.computeMinNumberOfMultiplicationsNaive(p));
    }

    @Test(expected = Exception.class)
    public void naiveImplementationShouldThrowWhenInvalidPIsUsed() throws Exception {
        int p[] = {40};
        MatrixChainMultiplication.computeMinNumberOfMultiplicationsNaive(p);
    }
}

