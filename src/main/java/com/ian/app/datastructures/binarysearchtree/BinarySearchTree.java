package com.ian.app.datastructures.binarysearchtree;

import java.util.OptionalInt;

public class BinarySearchTree {
    private Node root = null;

    public void delete(int key) {
        Node node = root, parent = null;

        while (node != null && node.getKey() != key) {
            parent = node;

            if (key < node.getKey()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (node == null) { // node not found
            return;
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
    }

    public int getHeight() {
        return getNodeHeight(root);
    }

    private int getNodeHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int max = Math.max(getNodeHeight(node.getLeft()), getNodeHeight(node.getRight()));

        return max + 1;
    }

    private static Node getNodeMaximum(Node node) {
        Node current = node;

        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current;
    }

    private static Node getNodeMinimum(Node node) {
        Node current = node;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    private static Node getNodePredecessor(Node x) {
        if (x == null) {
            return null;
        }

        if (x.getLeft() != null) {
            return getNodeMaximum(x.getLeft());
        }

        // Find the highest ancestor of x whose right child is an ancestor of x
        Node current = x, parent = x.getParent();

        while (parent != null && current == parent.getLeft()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    private static Node getNodeSuccessor(Node x) {
        if (x == null) {
            return null;
        }

        if (x.getRight() != null) {
            return getNodeMinimum(x.getRight());
        }

        // Find the lowest ancestor of x whose left child is an ancestor of x
        Node current = x, parent = x.getParent();

        while (parent != null && current == parent.getRight()) {
            current = parent;
            parent = parent.getParent();
        }

        return parent;
    }

    public void insert(int key) {
        Node current = root, parent = null;

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

        Node newNode = new Node(key);

        newNode.setParent(parent);

        if (parent == null) {
            root = newNode;
        } else if (newNode.getKey() < parent.getKey()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public OptionalInt search(int key) {
        Node result = searchNode(key);

        if (result == null) {
            return OptionalInt.empty();
        }

        return OptionalInt.of(result.getKey());
    }

    private Node searchNode(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.getKey()) {
                return current;
            }

            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return null;
    }

    private void transplant(Node u, Node v) {
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
