package com.ian.app.datastructures.stack;

import java.util.OptionalInt;

public class Stack {
    private Node head = null;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public OptionalInt peek() {
        if (head == null) {
            return OptionalInt.empty();
        }

        return OptionalInt.of(head.getKey());
    }

    public OptionalInt pop() {
        if (head == null) {
            return OptionalInt.empty();
        }

        length--;
        int returnValue = head.getKey();
        head = head.getNext();

        return OptionalInt.of(returnValue);
    }

    public void push(int key) {
        Node node = new Node(key);
        length++;

        if (head == null) {
            head = node;
            return;
        }

        node.setNext(head);
        head = node;
    }
}
