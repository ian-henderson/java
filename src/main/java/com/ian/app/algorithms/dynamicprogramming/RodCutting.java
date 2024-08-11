package com.ian.app.algorithms.dynamicprogramming;

public interface RodCutting {
    static int computeMaxProfitMemoized(int[] p, int x) {
        int[] r = new int[x];

        for (int i = 0; i < x; i++) {
            r[i] = Integer.MIN_VALUE;
        }

        return computeMaxProfitMemoizedRecurse(p, r, x);
    }

    static int computeMaxProfitMemoizedRecurse(int[] p, int[] r, int x) {
        if (x == 0) {
            return x;
        }

        int index = x - 1;

        if (r[index] != Integer.MIN_VALUE) {
            return r[index];
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i <= x; i++) {
            maxProfit = Math.max(maxProfit,
                    p[i - 1] + computeMaxProfitMemoizedRecurse(p, r, x - i));
        }

        return r[index] = maxProfit;
    }

    static int computeMaxProfitNaive(int[] p, int x) {
        if (x == 0) {
            return x;
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i <= x; i++) {
            maxProfit = Math.max(maxProfit,
                    p[i - 1] + computeMaxProfitNaive(p, x - i));
        }

        return maxProfit;
    }

    static int computeMaxProfitTabulated(int[] p, int x) {
        int[] r = new int[x + 1]; // 1 based indexing

        r[0] = 0;

        for (int j = 1; j <= x; j++) {
            int maxProfit = Integer.MIN_VALUE;

            for (int i = 1; i <= j; i++) {
                maxProfit = Math.max(maxProfit, p[i - 1] + r[j - i]);
            }

            r[j] = maxProfit;
        }

        return r[x];
    }
}
