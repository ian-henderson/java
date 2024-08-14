package com.ian.app.datastructures.binarysearchtree;

public class BinarySearchTree {
    private BinarySearchTreeNode root = null;

    public boolean delete(int key) {
        BinarySearchTreeNode node = root, parent = null;

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
            parent = getNodeMinimum(node.getRight());

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

    public int getHeight() {
        return getNodeHeight(root);
    }

    private int getNodeHeight(BinarySearchTreeNode node) {
        if (node == null) {
            return -1;
        }

        int max = Math.max(
                getNodeHeight(node.getLeft()),
                getNodeHeight(node.getRight()));

        return max + 1;
    }

    static private BinarySearchTreeNode getNodeMaximum(BinarySearchTreeNode x) {
        while (x.getRight() != null) {
            x = x.getRight();
        }

        return x;
    }

    static private BinarySearchTreeNode getNodeMinimum(BinarySearchTreeNode x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }

        return x;
    }

    static private BinarySearchTreeNode getNodePredecessor(BinarySearchTreeNode x) {
        if (x == null) {
            return null;
        }

        if (x.getLeft() != null) {
            return getNodeMaximum(x.getLeft());
        }

        // Find the highest ancestor of x whose right child is an ancestor of x
        BinarySearchTreeNode current = x, parent = x.getParent();

        while (parent != null && current == parent.getLeft()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    static private BinarySearchTreeNode getNodeSuccessor(BinarySearchTreeNode x) {
        if (x == null) {
            return null;
        }

        if (x.getRight() != null) {
            return getNodeMinimum(x.getRight());
        }

        // Find the lowest ancestor of x whose left child is an ancestor of x
        BinarySearchTreeNode current = x, parent = x.getParent();

        while (parent != null && current == parent.getRight()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    public boolean insert(int key) {
        BinarySearchTreeNode current = root, parent = null;

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

        BinarySearchTreeNode newNode = new BinarySearchTreeNode(key);

        newNode.setParent(parent);

        if (parent == null) {
            root = newNode;
        } else if (newNode.getKey() < parent.getKey()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        return true;
    }

    public void print() {
        if (root == null) {
            System.out.println("No data in tree");
            return;
        }

        System.out.print("[");

        printRecurse(root);

        System.out.println("]");
    }

    static private void printRecurse(BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }

        printRecurse(node.getLeft());

        System.out.print(node.getKey());

        if (getNodeSuccessor(node) != null) {
            System.out.print(", ");
        }

        printRecurse(node.getRight());
    }

    public BinarySearchTreeNode search(int key) {
        return searchRecurse(root, key);
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
            root = v;
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
