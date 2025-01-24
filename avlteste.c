#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Definition of AVL Tree Node
typedef struct Node {
    int key;
    struct Node *left;
    struct Node *right;
    int height;
} Node;

// Function to get the height of the node
int height(Node *N) {
    if (N == NULL)
        return 0;
    return N->height;
}

// Function to get maximum of two integers
int max(int a, int b) {
    return (a > b) ? a : b;
}

// Function to create a new node
Node* newNode(int key) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->key = key;
    node->left = NULL;
    node->right = NULL;
    node->height = 1; // New node is initially added at leaf
    return(node);
}

// Right rotate subtree rooted with y
Node *rightRotate(Node *y) {
    Node *x = y->left;
    Node *T2 = x->right;

    // Perform rotation
    x->right = y;
    y->left = T2;

    // Update heights
    y->height = max(height(y->left), height(y->right)) + 1;
    x->height = max(height(x->left), height(x->right)) + 1;

    // Return new root
    return x;
}

// Left rotate subtree rooted with x
Node *leftRotate(Node *x) {
    Node *y = x->right;
    Node *T2 = y->left;

    // Perform rotation
    y->left = x;
    x->right = T2;

    // Update heights
    x->height = max(height(x->left), height(x->right)) + 1;
    y->height = max(height(y->left), height(y->right)) + 1;

    // Return new root
    return y;
}

// Get balance factor of node N
int getBalance(Node *N) {
    if (N == NULL)
        return 0;
    return height(N->left) - height(N->right);
}

// Recursive function to insert a key in the subtree rooted
// with node and returns the new root of the subtree
Node* insert(Node* node, int key) {
    /* 1. Perform the normal BST insertion */
    if (node == NULL)
        return(newNode(key));

    if (key < node->key)
        node->left = insert(node->left, key);
    else if (key > node->key)
        node->right = insert(node->right, key);
    else // Equal keys are not allowed in BST
        return node;

    /* 2. Update height of this ancestor node */
    node->height = 1 + max(height(node->left), height(node->right));

    /* 3. Get the balance factor of this ancestor node to check whether
       this node became unbalanced */
    int balance = getBalance(node);

    // If this node becomes unbalanced, then there are 4 cases

    // Left Left Case
    if (balance > 1 && key < node->left->key)
        return rightRotate(node);

    // Right Right Case
    if (balance < -1 && key > node->right->key)
        return leftRotate(node);

    // Left Right Case
    if (balance > 1 && key > node->left->key) {
        node->left = leftRotate(node->left);
        return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < node->right->key) {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    /* return the (unchanged) node pointer */
    return node;
}

// Function for in-order traversal to print the tree
void printInOrder(Node *root) {
    if (root != NULL) {
        printInOrder(root->left);
        printf("%d ", root->key);
        printInOrder(root->right);
    }
}

// Function to generate and insert random values into the AVL Tree
void insertRandomValues(Node** root, int count, int range) {
    srand(time(0));
    for (int i = 0; i < count; ++i) {
        int value = rand() % range;
        *root = insert(*root, value);
    }
}

int main() {
    Node *root = NULL;
    int numberOfValues = 10;
    int rangeOfValues = 10000; // Example range limit for random values

    insertRandomValues(&root, numberOfValues, rangeOfValues);

    // Print the AVL tree in sorted order
    printf("AVL Tree (in-order traversal):\n");
    printInOrder(root);

    return 0;
}