package com.ian.app.datastructures.redblacktree;

public class RedBlackTree {
    private RedBlackTreeNode root = null;

    public void fixInsert(RedBlackTreeNode node) {
        RedBlackTreeNode uncle;

        while (node != root && node.getParent().getColor() == RedBlackTreeNodeColor.RED) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();

                if (uncle != null && uncle.getColor() == RedBlackTreeNodeColor.RED) {
                    node.getParent().setColor(RedBlackTreeNodeColor.BLACK);
                    uncle.setColor(RedBlackTreeNodeColor.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNodeColor.RED);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        rotateLeft(node);
                    }
                    node.getParent().setColor(RedBlackTreeNodeColor.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNodeColor.RED);
                    rotateRight(node.getParent().getParent());
                }
            } else {
                uncle = node.getParent().getParent().getLeft();

                if (uncle != null && uncle.getColor() == RedBlackTreeNodeColor.RED) {
                    node.getParent().setColor(RedBlackTreeNodeColor.RED);
                    uncle.setColor(RedBlackTreeNodeColor.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNodeColor.RED);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rotateRight(node);
                    }
                    node.getParent().setColor(RedBlackTreeNodeColor.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNodeColor.RED);
                    rotateLeft(node.getParent().getParent());
                }
            }
        }

        root.setColor(RedBlackTreeNodeColor.BLACK);
    }

    public boolean insert(int key) {
        RedBlackTreeNode current = root, parent = null;

        while (current != null) {
            parent = current;

            if (key == current.getKey()) { // duplicate key
                return false;
            }

            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        RedBlackTreeNode newNode = new RedBlackTreeNode(key);
        newNode.setParent(parent);

        if (parent == null) {
            root = newNode;
        } else if (newNode.getKey() < parent.getKey()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        if (newNode.getParent() == null) {
            newNode.setColor(RedBlackTreeNodeColor.BLACK);
            return true;
        }

        if (newNode.getParent().getParent() == null) {
            return true;
        }

        fixInsert(newNode);

        return true;
    }

    private void rotateLeft(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.getRight();

        x.setRight(y.getLeft());

        if (y.getLeft() != null) {
            y.getLeft().setParent(x);
        }

        y.setParent(x.getParent());

        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }

        y.setLeft(x);
        x.setParent(y);
    }

    private void rotateRight(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.getLeft();

        x.setLeft(y.getRight());

        if (y.getRight() != null) {
            y.getRight().setParent(x);
        }

        y.setParent(x.getParent());

        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }

        y.setRight(x);
        x.setParent(y);
    }
}
