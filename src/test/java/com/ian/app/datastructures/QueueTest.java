package com.ian.app.datastructures;

import com.ian.app.datastructures.queue.Queue;
import java.util.OptionalInt;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {
    @Test
    public void shouldHaveLengthOfZeroInitially() {
        Queue q = new Queue();
        assertEquals(0, q.getLength());
    }

    @Test
    public void shouldReturnEmptyWhenEmpty() {
        Queue q = new Queue();
        OptionalInt result = q.remove();
        assertFalse(result.isPresent());
    }

    @Test
    public void shouldBeAbleToAddElement() {
        Queue q = new Queue();
        q.add(1);
        OptionalInt result = q.peek();
        assertTrue(result.isPresent());
        assertEquals(1, result.getAsInt());
    }

    @Test
    public void shouldBeAbleToAddAndRemoveMultipleElements() {
        Queue q = new Queue();
        int[] entries = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        assertEquals(0, q.getLength());

        for (int entry : entries) {
            q.add(entry);
        }

        assertEquals(10, q.getLength());

        for (int entry : entries) {
            OptionalInt result = q.remove();
            assertTrue(result.isPresent());
            assertEquals(entry, result.getAsInt());
        }

        assertEquals(0, q.getLength());
    }
}
