import java.util.Random;

public class Llama_3_2_90b_vision_preview {

    // Node class representing a single node in the AVL tree
    private static class Node {
        int key;
        Node left;
        Node right;
        int height;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    // Root node of the AVL tree
    private Node root;

    // Constructor to initialize an empty AVL tree
    public Llama_3_2_90b_vision_preview() {
        this.root = null;
    }

    // Method to get the height of a node
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Method to update the height of a node
    private void updateHeight(Node node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Method to get the balance factor of a node
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // Method to perform a left rotation
    private Node leftRotate(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        updateHeight(node);
        updateHeight(temp);
        return temp;
    }

    // Method to perform a right rotation
    private Node rightRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        updateHeight(node);
        updateHeight(temp);
        return temp;
    }

    // Method to rebalance the tree after insertion or deletion
    private Node rebalance(Node node) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        return node;
    }

    // Method to insert a new node into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive method to insert a new node into the AVL tree
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        updateHeight(node);
        return rebalance(node);
    }

    // Method to delete a node from the AVL tree
    public void delete(int key) {
        root = delete(root, key);
    }

    // Recursive method to delete a node from the AVL tree
    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
        }
        updateHeight(node);
        return rebalance(node);
    }

    // Method to perform an in-order traversal of the AVL tree
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    // Recursive method to perform an in-order traversal of the AVL tree
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        Llama_3_2_90b_vision_preview avlTree = new Llama_3_2_90b_vision_preview();
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            int key = rand.nextInt(10000);
            avlTree.insert(key);
        }
    }
}