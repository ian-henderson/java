package com.ian.app.datastructures;

import com.ian.app.datastructures.stack.Stack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.OptionalInt;

public class StackTest {
    @Test
    public void shouldHaveLengthZeroWhenEmpty() {
        Stack s = new Stack();
        assertEquals(0, s.getLength());
    }

    @Test
    public void shouldPushAndPopOneValueCorrectly() {
        Stack s = new Stack();
        s.push(1);
        assertEquals(1, s.getLength());
        OptionalInt result = s.pop();
        assertTrue(result.isPresent());
        assertEquals(1, result.getAsInt());
        assertEquals(0, s.getLength());
    }

    @Test
    public void shouldPushAndPopMultipleValuesCorrectly() {
        Stack s = new Stack();
        int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        for (int value : values) {
            s.push(value);
        }

        assertEquals(values.length, s.getLength());

        for (int i = 0; i < values.length; i++) {
            OptionalInt result = s.pop();
            assertTrue(result.isPresent());
            assertEquals(values[values.length - 1 - i], result.getAsInt());
        }

        assertEquals(0, s.getLength());
    }
}
