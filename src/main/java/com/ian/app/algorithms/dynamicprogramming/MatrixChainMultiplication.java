package com.ian.app.algorithms.dynamicprogramming;

public interface MatrixChainMultiplication {
    static int computeMinNumberOfMultiplicationsMemoized(int[] p) throws Exception {
        int n = p.length;
        int[][] memo = new int[n - 1][n - 1]; // automatically zeroed out

        return computeMinNumberOfMultiplicationsMemoizedRecurse(memo, p, 1, n - 1);
    }

    static int computeMinNumberOfMultiplicationsMemoizedRecurse(
            int[][] memo, int[] p, int i, int j) throws Exception {
        if (i == j) {
            return 0;
        }

        if (memo[i - 1][j - 1] != 0) {
            return memo[i - 1][j - 1];
        }

        int min = Integer.MAX_VALUE;

        // Place parenthesis at different places between first and last
        // matrix, recursively calculate count of multiplications for each
        // parenthesis placement and return the min count.
        for (int k = i; k < j; k++) {
            int count = p[i - 1] * p[k] * p[j]
                    + computeMinNumberOfMultiplicationsMemoizedRecurse(memo, p, i, k)
                    + computeMinNumberOfMultiplicationsMemoizedRecurse(memo, p, k + 1, j);

            if (count < min) {
                min = count;
            }
        }

        return memo[i - 1][j - 1] = min;
    }

    static int computeMinNumberOfMultiplicationsNaive(int[] p) throws Exception {
        if (p.length < 2) {
            throw new Exception("p[] should be at least 2 integers");
        }

        int n = p.length;

        return computeMinNumberOfMultiplicationsNaiveRecurse(p, 1, n - 1);
    }

    static int computeMinNumberOfMultiplicationsNaiveRecurse(
            int[] p, int i, int j) throws Exception {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // Place parenthesis at different places between first and last
        // matrix, recursively calculate count of multiplications for each
        // parenthesis placement and return the min count.
        for (int k = i; k < j; k++) {
            int count = p[i - 1] * p[k] * p[j]
                    + computeMinNumberOfMultiplicationsNaiveRecurse(p, i, k)
                    + computeMinNumberOfMultiplicationsNaiveRecurse(p, k + 1, j);

            if (count < min) {
                min = count;
            }
        }

        return min;
    }
}
