#include <stdio.h>
#include <stdlib.h>

// Node structure for AVL tree
struct Node {
    int data;
    struct Node *left;
    struct Node *right;
    int height;
};

// Function to create a new node
struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    node->height = 1;
    return node;
}

// Function to get the height of a node
int height(struct Node* node) {
    if (node == NULL)
        return 0;
    return node->height;
}

// Function to get the balance factor of a node
int balanceFactor(struct Node* node) {
    if (node == NULL)
        return 0;
    return height(node->left) - height(node->right);
}

// Function to perform a right rotation
struct Node* rightRotate(struct Node* y) {
    struct Node* x = y->left;
    struct Node* T2 = x->right;

    // Perform rotation
    x->right = y;
    y->left = T2;

    // Update heights
    y->height = 1 + max(height(y->left), height(y->right));
    x->height = 1 + max(height(x->left), height(x->right));

    return x;
}

// Function to perform a left rotation
struct Node* leftRotate(struct Node* x) {
    struct Node* y = x->right;
    struct Node* T2 = y->left;

    // Perform rotation
    y->left = x;
    x->right = T2;

    // Update heights
    x->height = 1 + max(height(x->left), height(x->right));
    y->height = 1 + max(height(y->left), height(y->right));

    return y;
}

// Function to insert a new node into the AVL tree
struct Node* insert(struct Node* node, int data) {
    // 1. Perform the normal BST insertion
    if (node == NULL)
        return newNode(data);

    if (data < node->data)
        node->left = insert(node->left, data);
    else if (data > node->data)
        node->right = insert(node->right, data);
    else
        return node;

    // 2. Update height of this ancestor node
    node->height = 1 + max(height(node->left), height(node->right));

    // 3. Get the balance factor of this ancestor node
    int balance = balanceFactor(node);

    // 4. If this node becomes unbalanced, then there are 4 cases

    // Case 1 - Left Left
    if (balance > 1 && data < node->left->data)
        return rightRotate(node);

    // Case 2 - Right Right
    if (balance < -1 && data > node->right->data)
        return leftRotate(node);

    // Case 3 - Left Right
    if (balance > 1 && data > node->left->data) {
        node->left = leftRotate(node->left);
        return rightRotate(node);
    }

    // Case 4 - Right Left
    if (balance < -1 && data < node->right->data) {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    return node;
}

// Function to find the maximum value
int max(int a, int b) {
    return (a > b) ? a : b;
}

int main() {
    struct Node *root = NULL;
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 1000;
    }

    for (int i = 0; i < 1000; i++) {
        root = insert(root, arr[i]);
    }

    return 0;
}