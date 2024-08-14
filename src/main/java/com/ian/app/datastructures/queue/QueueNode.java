package com.ian.app.datastructures.queue;

public class QueueNode {
    private QueueNode previous, next;
    private int key;

    public QueueNode(int key) {
        this.previous = this.next = null;
        this.key = key;
    }

    public QueueNode getPrevious() {
        return previous;
    }

    public void setPrevious(QueueNode previous) {
        this.previous = previous;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
