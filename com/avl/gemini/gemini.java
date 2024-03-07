package com.avl;

public class gemini<T extends Comparable<T>> {

    public Node<T> root;

    public static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        int height;

        public Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }

    public int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getBalanceFactor(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    public Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate data not allowed
            return node;
        }

        // Update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Check balance and perform rotations if needed
        int balance = getBalanceFactor(node);
        if (balance > 1 && data.compareTo(node.left.data) < 0) {
            // Left Left Case
            return rightRotate(node);
        } else if (balance > 1 && data.compareTo(node.left.data) > 0) {
            // Left Right Case
            node.left = leftRotate(node.left);
            return rightRotate(node);
        } else if (balance < -1 && data.compareTo(node.right.data) > 0) {
            // Right Right Case
            return leftRotate(node);
        } else if (balance < -1 && data.compareTo(node.right.data) < 0) {
            // Right Left Case
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public Node<T> deleteNode(Node<T> node, T data) {
        if (node == null) {
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = deleteNode(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, data);
        } else {
            // Node with one or no child
            if (node.left == null) {
                return node.right;
        } else if (node.right == null) {
            return node.left;
        }

        // Node with two children
        Node<T> temp = minValueNode(node.right);
        node.data = temp.data;

        // Delete the minimum value node in right subtree
        node.right = deleteNode(node.right, temp.data);
    }

    // Update height
    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

    // Check balance and perform rotations if needed (similar to insert)
    int balance = getBalanceFactor(node);
    if (balance > 1 && getBalanceFactor(node.left) >= 0) {
        return rightRotate(node);
    } else if (balance > 1 && getBalanceFactor(node.left) < 0) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    } else if (balance < -1 && getBalanceFactor(node.right) <= 0) {
        return leftRotate(node);
    } else if (balance < -1 && getBalanceFactor(node.right) > 0) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node;
}

public void inOrderTraversal(Node<T> node) {
    if (node != null) {
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
}
}