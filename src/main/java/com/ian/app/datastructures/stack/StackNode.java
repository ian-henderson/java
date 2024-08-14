package com.ian.app.datastructures.stack;

public class StackNode {
    private StackNode previous = null, next = null;
    private int key;

    public StackNode(int key) {
        this.key = key;
    }

    public StackNode getPrevious() {
        return previous;
    }

    public void setPrevious(StackNode previous) {
        this.previous = previous;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
