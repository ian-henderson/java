package com.ian.app.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void fibonacciMemoizedShouldHandleZeroCase() throws Exception {
        assertEquals(Fibonacci.fibonacciMemoized(0), 0L);
    }

    @Test(expected = Exception.class)
    public void fibonacciMemoizedShouldThrowNegativeN() throws Exception {
        Fibonacci.fibonacciMemoized(-1);
    }

    @Test
    public void fibonacciMemoizedShouldHandleNCase() throws Exception {
        assertEquals(Fibonacci.fibonacciMemoized(36), 14930352L);
    }

    @Test
    public void fibonacciNaiveShouldHandleZeroCase() throws Exception {
        assertEquals(Fibonacci.fibonacciNaive(0), 0L);
    }

    @Test(expected = Exception.class)
    public void fibonacciNaiveShouldThrowNegativeN() throws Exception {
        Fibonacci.fibonacciNaive(-1);
    }

    @Test
    public void fibonacciNaiveShouldHandleNCase() throws Exception {
        assertEquals(Fibonacci.fibonacciNaive(36), 14930352L);
    }
}
