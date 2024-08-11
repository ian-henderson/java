package com.ian.app.algorithms.dynamicprogramming;

import java.util.Arrays;

public interface Fibonacci {
    static long fibonacciMemoized(int n) throws Exception {
        if (n < 0) {
            throw new Exception("n must be positive");
        }

        long[] memo = new long[n + 1];
        Arrays.fill(memo, 0);

        return fibonacciMemoizedRecurse(memo, n);
    }

    static long fibonacciMemoizedRecurse(long[] memo, int n) throws ArithmeticException {
        if (n <= 1) {
            return (long) n;
        }

        if (memo[n] != 0L) {
            return memo[n];
        }

        memo[n] = fibonacciMemoizedRecurse(memo, n - 1)
                + fibonacciMemoizedRecurse(memo, n - 2);

        // overflow check
        if (memo[n] < memo[n - 1]) {
            throw new ArithmeticException("Long int overflow");
        }

        return memo[n];
    }

    static long fibonacciNaive(int n) throws Exception {
        if (n < 0) {
            throw new Exception("n must be positive");
        }

        return fibonacciNaiveRecurse(n);
    }

    static long fibonacciNaiveRecurse(int n) throws ArithmeticException {
        if (n <= 1) {
            return n;
        }

        long a = fibonacciNaiveRecurse(n - 2);
        long b = fibonacciNaiveRecurse(n - 1);
        long c = a + b;

        // overflow check
        if (c < b) {
            throw new ArithmeticException("Long int overflow");
        }

        return c;
    }
}
