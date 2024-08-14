package com.ian.app.datastructures.hashtable;

public class HashTableNode {
    private HashTableNode next = null, previous = null;
    private String key, value;

    public HashTableNode getNext() {
        return next;
    }

    public void setNext(HashTableNode next) {
        this.next = next;
    }

    public HashTableNode getPrevious() {
        return previous;
    }

    public void setPrevious(HashTableNode previous) {
        this.previous = previous;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashTableNode(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
