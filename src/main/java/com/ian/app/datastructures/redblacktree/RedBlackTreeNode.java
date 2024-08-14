package com.ian.app.datastructures.redblacktree;

public class RedBlackTreeNode {
    private RedBlackTreeNode parent = null, left = null, right = null;
    private RedBlackTreeNodeColor color = RedBlackTreeNodeColor.RED;
    private int key;

    public RedBlackTreeNode(int key) {
        this.key = key;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public RedBlackTreeNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackTreeNode left) {
        this.left = left;
    }

    public RedBlackTreeNode getRight() {
        return right;
    }

    public void setRight(RedBlackTreeNode right) {
        this.right = right;
    }

    public RedBlackTreeNodeColor getColor() {
        return color;
    }

    public void setColor(RedBlackTreeNodeColor color) {
        this.color = color;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
