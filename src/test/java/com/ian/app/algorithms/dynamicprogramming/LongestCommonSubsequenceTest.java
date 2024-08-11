package com.ian.app.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    @Test
    public void shouldComputeSequencesCorrectly() {
        String x = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA",
                y = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        assertEquals(20, LongestCommonSubsequence.compute(x, y));
    }

    @Test
    public void shouldHandleEmptyStrings() {
        String x = "", y = "";
        assertEquals(0, LongestCommonSubsequence.compute(x, y));
    }
}
