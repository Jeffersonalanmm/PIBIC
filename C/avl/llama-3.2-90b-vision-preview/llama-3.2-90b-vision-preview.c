#include <stdio.h>
#include <stdlib.h>

// Define the structure for a node in the AVL tree
typedef struct Node {
    int key;
    struct Node* left;
    struct Node* right;
    int height;
} Node;

// Function to create a new node
Node* createNode(int key) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (!newNode) {
        printf("Memory error\n");
        return NULL;
    }
    newNode->key = key;
    newNode->left = newNode->right = NULL;
    newNode->height = 1;
    return newNode;
}

// Function to get the height of a node
int getHeight(Node* node) {
    if (node == NULL)
        return 0;
    return node->height;
}

// Function to update the height of a node
void updateHeight(Node* node) {
    node->height = 1 + (getHeight(node->left) > getHeight(node->right) ? getHeight(node->left) : getHeight(node->right));
}

// Function to get the balance factor of a node
int getBalanceFactor(Node* node) {
    if (node == NULL)
        return 0;
    return getHeight(node->left) - getHeight(node->right);
}

// Function to perform a left rotation
Node* leftRotate(Node* node) {
    Node* temp = node->right;
    Node* tempLeft = temp->left;

    temp->left = node;
    node->right = tempLeft;

    updateHeight(node);
    updateHeight(temp);

    return temp;
}

// Function to perform a right rotation
Node* rightRotate(Node* node) {
    Node* temp = node->left;
    Node* tempRight = temp->right;

    temp->right = node;
    node->left = tempRight;

    updateHeight(node);
    updateHeight(temp);

    return temp;
}

// Function to rebalance the tree
Node* rebalance(Node* node) {
    updateHeight(node);

    int balanceFactor = getBalanceFactor(node);

    // Left-heavy tree
    if (balanceFactor > 1) {
        if (getBalanceFactor(node->left) < 0)
            node->left = leftRotate(node->left);
        return rightRotate(node);
    }

    // Right-heavy tree
    if (balanceFactor < -1) {
        if (getBalanceFactor(node->right) > 0)
            node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    return node;
}

// Function to insert a new node into the AVL tree
Node* insertNode(Node* node, int key) {
    if (node == NULL)
        return createNode(key);

    if (key < node->key)
        node->left = insertNode(node->left, key);
    else if (key > node->key)
        node->right = insertNode(node->right, key);
    else
        return node;

    return rebalance(node);
}

// Function to delete a node from the AVL tree
Node* deleteNode(Node* node, int key) {
    if (node == NULL)
        return node;

    if (key < node->key)
        node->left = deleteNode(node->left, key);
    else if (key > node->key)
        node->right = deleteNode(node->right, key);
    else {
        if (node->left == NULL)
            return node->right;
        else if (node->right == NULL)
            return node->left;

        Node* temp = node->right;
        while (temp->left != NULL)
            temp = temp->left;

        node->key = temp->key;
        node->right = deleteNode(node->right, temp->key);
    }

    return rebalance(node);
}

// Function to free the AVL tree
void freeTree(Node* node) {
    if (node == NULL)
        return;

    freeTree(node->left);
    freeTree(node->right);

    free(node);
}

int main() {
    Node* root = NULL;

    // Insert 1000 random values into the AVL tree
    for (int i = 0; i < 1000; i++) {
        root = insertNode(root, rand() % 10000);
    }

    // Delete some nodes from the AVL tree
    //root = deleteNode(root, 5000);
    //root = deleteNode(root, 2000);

    // Free the AVL tree
    freeTree(root);

    return 0;
}