package com.ian.app.datastructures.binarysearchtree;

public class BinarySearchTree {
    private BinarySearchTreeNode root = null;

    public BinarySearchTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode root) {
        this.root = root;
    }

    public boolean delete(int key) {
        BinarySearchTreeNode node = this.root, parent = null;

        while (node != null && node.getKey() != key) {
            parent = node;

            if (key < node.getKey()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (node == null) { // node not found
            return false;
        }

        if (node.getLeft() == null) {
            transplant(node, node.getRight());
        } else if (node.getRight() == null) {
            transplant(node, node.getLeft());
        } else {
            parent = nodeMinimum(node.getRight());

            if (parent != node.getRight()) {
                transplant(parent, parent.getRight());
                parent.setRight(node.getRight());
                parent.getRight().setParent(parent);
            }

            transplant(node, parent);
            parent.setLeft(node.getLeft());
            parent.getLeft().setParent(parent);
        }

        return true;
    }

    public void insert(int key) {
        BinarySearchTreeNode current = this.root, parent = null;

        while (current != null) {
            parent = current;

            if (key == current.getKey()) { // duplicate key
                return;
            }

            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        BinarySearchTreeNode newNode = new BinarySearchTreeNode(key);

        newNode.setParent(parent);

        if (parent == null) {
            setRoot(newNode);
        } else if (newNode.getKey() < parent.getKey()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    private BinarySearchTreeNode nodeMinimum(BinarySearchTreeNode x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }

        return x;
    }

    public void print() {
        if (this.root == null) {
            System.out.println("No data in tree");
            return;
        }

        printRecurse(this.root);

        System.out.println();
    }

    static private void printRecurse(BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }

        printRecurse(node.getLeft());

        System.out.printf("%d ", node.getKey());

        printRecurse(node.getRight());
    }

    public BinarySearchTreeNode search(int key) {
        return searchRecurse(this.root, key);
    }

    static private BinarySearchTreeNode searchRecurse(BinarySearchTreeNode node,
                                                      int key) {
        if (node == null || node.getKey() == key) {
            return node;
        }

        if (key < node.getKey()) {
            return searchRecurse(node.getLeft(), key);
        }

        return searchRecurse(node.getRight(), key);
    }

    private void transplant(BinarySearchTreeNode u,
                            BinarySearchTreeNode v) {
        if (u.getParent() == null) {
            setRoot(v);
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }

        if (v != null) {
            v.setParent(u.getParent());
        }
    }
}
