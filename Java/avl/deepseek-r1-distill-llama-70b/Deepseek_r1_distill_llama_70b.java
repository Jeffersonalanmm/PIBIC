import java.util.Random;

public class Deepseek_r1_distill_llama_70b<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        updateHeight(node);
        int balance = getBalance(node);

        if (balance > 1) {
            if (key.compareTo(node.left.key) < 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            if (key.compareTo(node.right.key) > 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node temp = inOrderSuccessor(node.right);
                node.key = temp.key;
                node.value = temp.value;
                node.right = delete(node.right, temp.key);
            }
        }

        if (node == null) {
            return null;
        }

        updateHeight(node);
        int balance = getBalance(node);

        if (balance > 1) {
            int leftBalance = getBalance(node.left);
            if (leftBalance >= 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            int rightBalance = getBalance(node.right);
            if (rightBalance <= 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public V search(K key) {
        return search(root, key);
    }

    private V search(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return search(node.right, key);
        } else {
            return node.value;
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    private Node inOrderSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node leftRotate(Node z) {
        Node y = z.right;
        Node t2 = y.left;
        y.left = z;
        z.right = t2;
        updateHeight(z);
        updateHeight(y);
        return y;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node node) {
        if (node == null) {
            return;
        }
        int leftHeight = (node.left == null) ? 0 : node.left.height;
        int rightHeight = (node.right == null) ? 0 : node.right.height;
        node.height = 1 + Math.max(leftHeight, rightHeight);
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = (node.left == null) ? 0 : node.left.height;
        int rightHeight = (node.right == null) ? 0 : node.right.height;
        return leftHeight - rightHeight;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        Deepseek_r1_distill_llama_70b<Integer, String> avlTree = new Deepseek_r1_distill_llama_70b<>();
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            int key = rand.nextInt(10000);
            avlTree.insert(key, "Value" + key);
        }
    }
}