package com.ian.app.datastructures.hashtable;

public class HashTable {
    private int capacity = 100, nodeCount = 0;
    private HashTableNode[] buffer = new HashTableNode[capacity];

    public int getCapacity() {
        return capacity;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public boolean delete(String key) {
        int index = hash(key);
        HashTableNode current = buffer[index], previous = null;

        if (current == null) {
            return true;
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

                nodeCount--;
                break;
            }

            previous = current;
            current = current.getNext();
        }

        return true;
    }

    public String get(String key) {
        HashTableNode current = buffer[hash(key)];

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

    public boolean set(String key, String value) {
        if (get(key) == value) {
            return false;
        }

        HashTableNode node = new HashTableNode(key, value);

        int index = hash(key);

        if (buffer[index] == null) {
            buffer[index] = node;
        } else {
            node.setNext(buffer[index]);
            buffer[index] = node;
        }

        nodeCount++;

        return true;
    }
}
