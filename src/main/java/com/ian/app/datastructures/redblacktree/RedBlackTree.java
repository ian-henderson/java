package com.ian.app.datastructures.redblacktree;

import java.util.OptionalInt;

public class RedBlackTree {
    private Node root = null;

    public void delete(int key) {
        Node node = searchNode(key);

        if (node == null) {
            return;
        }

        deleteNode(node);
    }

    private void deleteNode(Node v) {
        Node parent = v.getParent(), u = replaceNode(v);
        boolean uvBlack = (u == null || u.getColor() == Color.BLACK)
                && v.getColor() == Color.BLACK;

        if (u == null) {
            if (v == root) {
                root = null;
            } else {
                if (uvBlack) { // u and v are black. v is a leaf, fix double black at v
                    fixDoubleBlack(v);
                } else { // u or v is red
                    Node vSibling = getSibling(v);

                    if (vSibling != null) {
                        vSibling.setColor(Color.RED);
                    }
                }

                // delete v
                if (nodeIsParentLeft(v)) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }

            return;
        }

        if (v.getLeft() == null || v.getRight() == null) {
            // v has one child
            if (v == root) {
                // v is root, assign value of u to v, then delete u
                v.setKey(u.getKey());
                v.setLeft(null);
                v.setRight(null);
            } else { // detach v from tree and move u up
                if (nodeIsParentLeft(v)) {
                    parent.setLeft(u);
                } else {
                    parent.setRight(u);
                }

                u.setParent(parent);

                if (uvBlack) { // u anv v are both black, fix double black at u
                    fixDoubleBlack(u);
                } else {
                    u.setColor(Color.BLACK);
                }
            }

            return;
        }

        // v has two children, swap values with successor and recurse
        swapNodeValues(u, v);

        deleteNode(u);
    }

    private void fixDoubleBlack(Node node) {
        if (node == root) {
            return;
        }

        Node parent = node.getParent(), sibling = getSibling(node);

        if (sibling == null) { // No sibling, double black pushed up
            fixDoubleBlack(parent);
        } else {
            if (sibling.getColor() == Color.RED) {
                parent.setColor(Color.RED);
                sibling.setColor(Color.BLACK);

                if (nodeIsParentLeft(sibling)) {
                    rotateRight(parent);
                } else {
                    rotateLeft(parent);
                }

                fixDoubleBlack(parent);
            } else { // Sibling is black
                if (nodeHasRedChild(sibling)) {
                    // At least one red child
                    if (sibling.getLeft() != null && sibling.getLeft().getColor() == Color.RED) {
                        // left left
                        if (nodeIsParentLeft(sibling)) {
                            sibling.getLeft().setColor(sibling.getColor());
                            sibling.setColor(parent.getColor());
                            rotateRight(parent);
                        }
                        // right left
                        else {
                            sibling.getLeft().setColor(parent.getColor());
                            rotateRight(sibling);
                            rotateLeft(parent);
                        }
                    } else {
                        // left right
                        if (nodeIsParentLeft(sibling)) {
                            sibling.getRight().setColor(parent.getColor());
                            rotateLeft(sibling);
                            rotateRight(parent);
                        }
                        // right right
                        else {
                            sibling.getRight().setColor(sibling.getColor());
                            sibling.setColor(parent.getColor());
                            rotateLeft(parent);
                        }
                    }

                    parent.setColor(Color.BLACK);
                }
                // two black children
                else {
                    sibling.setColor(Color.RED);

                    if (parent.getColor() == Color.BLACK) {
                        fixDoubleBlack(parent);
                    } else {
                        parent.setColor(Color.BLACK);
                    }
                }
            }
        }
    }

    private void fixInsert(Node node) {
        Node uncle;

        while (node != root && node.getParent().getColor() == Color.RED) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();

                if (uncle != null && uncle.getColor() == Color.RED) {
                    node.getParent().setColor(Color.BLACK);
                    uncle.setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        rotateLeft(node);
                    }
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    rotateRight(node.getParent().getParent());
                }
            } else {
                uncle = node.getParent().getParent().getLeft();

                if (uncle != null && uncle.getColor() == Color.RED) {
                    node.getParent().setColor(Color.RED);
                    uncle.setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rotateRight(node);
                    }
                    node.getParent().setColor(Color.BLACK);
                    node.getParent().getParent().setColor(Color.RED);
                    rotateLeft(node.getParent().getParent());
                }
            }
        }

        root.setColor(Color.BLACK);
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

    private static Node getSibling(Node node) {
        if (node.getParent() == null) {
            return null;
        }

        if (node.getParent().getLeft() == node) {
            return node.getParent().getRight();
        }

        return node.getParent().getLeft();
    }

    private static Node getSuccessor(Node node) {
        Node successor = node;

        while (successor != null) {
            successor = successor.getLeft();
        }

        return successor;
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

        if (newNode.getParent() == null) {
            newNode.setColor(Color.BLACK);
            return;
        }

        if (newNode.getParent().getParent() == null) {
            return;
        }

        fixInsert(newNode);
    }

    private static boolean nodeHasRedChild(Node node) {
        if ((node.getRight() != null && node.getRight().getColor() == Color.RED)
                || (node.getLeft() != null && node.getLeft().getColor() == Color.RED)) {
            return true;
        }

        return false;
    }

    private static boolean nodeIsParentLeft(Node node) {
        if (node.getParent() == null) {
            return false;
        }

        if (node.getParent().getLeft() != node) {
            return false;
        }

        return true;
    }

    private static Node replaceNode(Node node) {
        if (node.getLeft() != null && node.getRight() != null) { // node has two children
            return getSuccessor(node.getRight());
        }

        if (node.getLeft() == null && node.getRight() == null) { // node is a leaf
            return null;
        }

        if (node.getLeft() != null) {
            return node.getLeft();
        }

        return node.getRight();
    }

    private void rotateLeft(Node x) {
        Node y = x.getRight();

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

    private void rotateRight(Node x) {
        Node y = x.getLeft();

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

    private static void swapNodeValues(Node x, Node y) {
        int temp = x.getKey();
        x.setKey(y.getKey());
        y.setKey(temp);
    }
}
