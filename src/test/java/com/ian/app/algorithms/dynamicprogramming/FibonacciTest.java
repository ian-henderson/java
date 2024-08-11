package com.ian.app.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void fibonacciMemoizedShouldHandleZeroCase() throws Exception {
        assertEquals(0L, Fibonacci.fibonacciMemoized(0));
    }

    @Test(expected = Exception.class)
    public void fibonacciMemoizedShouldThrowNegativeN() throws Exception {
        Fibonacci.fibonacciMemoized(-1);
    }

    @Test
    public void fibonacciMemoizedShouldHandleNCase() throws Exception {
        assertEquals(14930352L, Fibonacci.fibonacciMemoized(36));
    }

    @Test
    public void fibonacciNaiveShouldHandleZeroCase() throws Exception {
        assertEquals(0L, Fibonacci.fibonacciNaive(0));
    }

    @Test(expected = Exception.class)
    public void fibonacciNaiveShouldThrowNegativeN() throws Exception {
        Fibonacci.fibonacciNaive(-1);
    }

    @Test
    public void fibonacciNaiveShouldHandleNCase() throws Exception {
        assertEquals(14930352L, Fibonacci.fibonacciNaive(36));
    }

    @Test
    public void fibonacciOptimalShouldHandleZeroCase() throws Exception {
        assertEquals(0L, Fibonacci.fibonacciOptimal(0));
    }

    @Test(expected = Exception.class)
    public void fibonacciOptimalShouldThrowNegativeN() throws Exception {
        Fibonacci.fibonacciOptimal(-1);
    }

    @Test
    public void fibonacciOptimalShouldHandleNCase() throws Exception {
        assertEquals(14930352L, Fibonacci.fibonacciOptimal(36));
    }

    @Test
    public void fibonacciTabulatedShouldHandleZeroCase() throws Exception {
        assertEquals(0L, Fibonacci.fibonacciTabulated(0));
    }

    @Test(expected = Exception.class)
    public void fibonacciTabulatedShouldThrowNegativeN() throws Exception {
        Fibonacci.fibonacciTabulated(-1);
    }

    @Test
    public void fibonacciTabulatedShouldHandleNCase() throws Exception {
        assertEquals(14930352L, Fibonacci.fibonacciTabulated(36));
    }
}
