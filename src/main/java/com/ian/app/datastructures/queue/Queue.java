package com.ian.app.datastructures.queue;

import java.util.OptionalInt;

public class Queue {
    private QueueNode head = null, tail = null;
    private int length = 0;

    public void add(int key) {
        QueueNode newNode = new QueueNode(key);
        length++;

        // base case: empty queue
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // more than one element is present
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        tail = newNode;
        return;
    }

    public int getLength() {
        return length;
    }

    public OptionalInt peek() {
        if (head == null) {
            return OptionalInt.empty();
        }

        return OptionalInt.of(head.getKey());
    }

    public OptionalInt remove() {
        if (head == null) {
            return OptionalInt.empty();
        }

        length--;

        int returnValue = head.getKey();

        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return OptionalInt.of(returnValue);
    }
}
