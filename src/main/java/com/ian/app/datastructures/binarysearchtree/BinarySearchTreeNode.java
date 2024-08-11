package com.ian.app.datastructures.binarysearchtree;

public class BinarySearchTreeNode {
    private BinarySearchTreeNode
            parent = null,
            left = null,
            right = null;

    private int key;

    BinarySearchTreeNode(int key) {
        super();
        this.key = key;
    }

    public BinarySearchTreeNode getParent() {
        return parent;
    }

    public void setParent(BinarySearchTreeNode parent) {
        this.parent = parent;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
