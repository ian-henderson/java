package com.ian.app.algorithms.dynamicprogramming;

public interface LongestCommonSubsequence {
    static int compute(String x, String y) {
        int m = x.length(), n = y.length();

        int[][] memo = new int[m + 1][n + 1];

        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                } else {
                    memo[i][j] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }

        return memo[0][0];
    }
}
