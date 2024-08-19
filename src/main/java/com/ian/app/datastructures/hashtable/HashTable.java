package com.ian.app.datastructures.hashtable;

public class HashTable {
    private int capacity = 100;
    private Node[] buffer = new Node[capacity];

    public void delete(String key) {
        int index = hash(key);
        Node current = buffer[index], previous = null;

        if (current == null) {
            return;
        }

        while (current != null) {
            if (key == current.getKey()) {
                // head of list
                if (current == buffer[index]) {
                    buffer[index] = buffer[index].getNext();
                }
                // middle or end of list
                else {
                    previous.setNext(current.getNext());
                }

                break;
            }

            previous = current;
            current = current.getNext();
        }
    }

    public String get(String key) {
        Node current = buffer[hash(key)];

        while (current != null) {
            if (current.getKey() == key) {
                return current.getValue();
            }

            current = current.getNext();
        }

        return null;
    }

    private int hash(String key) {
        int factor = 31, hash = 0, max = Short.MAX_VALUE;

        for (int i = 0; i < key.length(); i++) {
            hash = ((hash % capacity)
                    + (((int) key.charAt(i)) * factor) % capacity)
                    % capacity;

            factor = ((factor % max) * (31 % max)) % max;
        }

        return hash;
    }

    public void set(String key, String value) {
        if (get(key) == value) {
            return;
        }

        Node node = new Node(key, value);
        int index = hash(key);

        if (buffer[index] == null) {
            buffer[index] = node;
        } else {
            node.setNext(buffer[index]);
            buffer[index] = node;
        }
    }
}
