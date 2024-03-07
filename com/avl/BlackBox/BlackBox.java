class Node {
    int key, height;
    Node left, right;
   
    public Node(int d) {
        key = d;
        height = 1;
    }
}
   
   class BlackBox {
    Node root;
   
    // A utility function to get the height of the tree
    int height(Node N) {
    if (N == null)
    return 0;
    return N.height;
    }
   
    // A utility function to get the maximum of two integers
    int max(int a, int b) {
    return (a > b) ? a : b;
    }
   
    // A utility function to right rotate subtree rooted with y
    Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;
   
    // Perform rotation
    x.right = y;
    y.left = T2;
   
    // Update heights
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;
   
    // Return new root
    return x;
    }
   
    // A utility function to left rotate subtree rooted with x
    Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;
   
    // Perform rotation
    y.left = x;
    x.right = T2;
   
    //  Update heights
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;
   
    // Return new root
    return y;
    }
   
    // Get Balance factor of node N
    int getBalance(Node N) {
    if (N == null)
    return 0;
    return height(N.left) - height(N.right);
    }
   
    // Insert a new node with given key
    Node insert(Node node, int key) {
   
    // Return a new node if the tree is empty
    if (node == null)
    return new Node(key);
   
    // Otherwise, recur down the tree
    if (key < node.key) {
    node.left = insert(node.left, key);
    } else if (key > node.key) {
    node.right = insert(node.right, key);
    } else {
    // No duplicates allowed
    return node;
    }
   
    // Update height of the current node
    node.height = 1 + max(height(node.left), height(node.right));
   
    // Get the balance factor
    int balance = getBalance(node);
   
    // If this node becomes unbalanced, then there are 4 cases
   
    // Left Left Case
    if (balance > 1 && key < node.left.key)
    return rightRotate(node);
   
    // Right Right Case
    if (balance < -1 && key > node.right.key)
    return leftRotate(node);
   
    // Left Right Case
    if (balance > 1 && key > node.left.key) {
    node.left = leftRotate(node.left);
    return rightRotate(node);
    }
   
    // Right Left Case
    if (balance < -1 && key < node.right.key) {
    node.right = rightRotate(node.right);
    return leftRotate(node);
    }
   
    // Return the (unchanged) node pointer
    return node;
    }
   
    //To get the AVL Tree
    Node getAVLTree() {
    return root;
    }
    public static void main(String[] args) {
        // Criar uma instância da árvore AVL
        BlackBox blackBox = new BlackBox();

        // Inserir 1000 nós na árvore AVL
        for (int i = 1; i <= 100000; i++) {
            blackBox.root = blackBox.insert(blackBox.root, i);
        }

        System.out.println("Árvore AVL com 100000 nós foi criada com sucesso!");
    }

   }
