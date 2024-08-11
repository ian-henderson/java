package com.ian.app.algorithms.dynamicprogramming;

// p[] represents probabilities of keys by index - meant to be accompanied
// by a keys array of the same length, but not needed for finding the optimal
// bst cost. Some solutions to this use actual probabilities where p0 + p1 +
// ... + pn-1 = 1, while others use "weights", where p values are arbitrary.
// This solution uses weights.

public interface OptimalBinarySearchTree {
    static int costOfOptimalBstMemoized(int[] p) {
        int n = p.length;

        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            memo[i][i] = p[i];
        }

        return costOfOptimalBstMemoizedRecurse(memo, p, 0, n - 1);
    }

    static int costOfOptimalBstMemoizedRecurse(int[][] memo, int[] p, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int rCost = subArraySum(p, i, j); // cost of making r head of bst

        int minCost = Integer.MAX_VALUE;

        for (int r = i; r <= j; r++) {
            int leftSubtreeCost =
                    costOfOptimalBstMemoizedRecurse(memo, p, i, r - 1);

            int rightSubtreeCost =
                    costOfOptimalBstMemoizedRecurse(memo, p, r + 1, j);

            int totalCost = rCost + leftSubtreeCost + rightSubtreeCost;

            if (totalCost < minCost) {
                minCost = totalCost;
            }
        }

        return memo[i][j] = minCost;
    }

    static int costOfOptimalBstNaive(int[] p) {
        int n = p.length;

        return costOfOptimalBstNaiveRecurse(p, 0, n - 1);
    }

    static int costOfOptimalBstNaiveRecurse(int[] p, int i, int j) {
        if (j < i) { // no elements in this subarray
            return 0;
        }

        if (i == j) { // one item in subarray
            return p[i];
        }

        int min = Integer.MAX_VALUE;

        for (int r = i; r <= j; r++) {
            int cost = costOfOptimalBstNaiveRecurse(p, i, r - 1)
                    + costOfOptimalBstNaiveRecurse(p, r + 1, j);

            if (cost < min) {
                min = cost;
            }
        }

        return min + subArraySum(p, i, j);
    }

    static int subArraySum(int[] array, int x, int y) {
        int sum = 0;

        for (int i = x; i <= Math.min(array.length, y); i++) {
            sum += array[i];
        }

        return sum;
    }
}
