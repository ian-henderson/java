package com.ian.app.datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import com.ian.app.datastructures.hashtable.HashTable;

public class HashTableTest {
    String[][] entries = {
            { "foo", "bar" },
            { "baz", "qux" },
            { "quux", "corge" },
            { "grault", "garply" },
            { "waldo", "fred" },
            { "plugh", "fred" },
    };

    @Test
    public void shouldReturnNullWhenNoValue() {
        HashTable t = new HashTable();
        assertNull(t.get("foo"));
    }

    @Test
    public void shouldMultipleValues() {
        HashTable t = new HashTable();

        for (String[] entry : entries) {
            String key = entry[0], value = entry[1];
            t.set(key, value);
            assertEquals(value, t.get(key));
        }
    }

    @Test
    public void shouldBeAbleToDelete() {
        HashTable t = new HashTable();

        for (String[] entry : entries) {
            String key = entry[0], value = entry[1];
            t.set(key, value);
            assertEquals(value, t.get(key));
        }

        for (String[] entry : entries) {
            String key = entry[0];
            t.delete(key);
            assertNull(t.get(key));
        }
    }
}
