package com.ian.app.datastructures.queue;

public class Node {
    private Node previous, next;
    private int key;

    public Node(int key) {
        this.previous = this.next = null;
        this.key = key;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
