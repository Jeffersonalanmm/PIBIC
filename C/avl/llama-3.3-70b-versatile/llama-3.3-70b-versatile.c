#include <stdio.h>
#include <stdlib.h>

// Define the structure for an AVL tree node
typedef struct Node {
    int key;
    struct Node* left;
    struct Node* right;
    int height;
} Node;

// Function to get the height of a node
int getHeight(Node* node) {
    if (node == NULL) {
        return 0;
    }
    return node->height;
}

// Function to update the height of a node
void updateHeight(Node* node) {
    if (node == NULL) {
        return;
    }
    node->height = 1 + ((getHeight(node->left) > getHeight(node->right)) ? getHeight(node->left) : getHeight(node->right));
}

// Function to get the balance factor of a node
int getBalanceFactor(Node* node) {
    if (node == NULL) {
        return 0;
    }
    return getHeight(node->left) - getHeight(node->right);
}

// Function to create a new node
Node* createNode(int key) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        return NULL;
    }
    newNode->key = key;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->height = 1;
    return newNode;
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

    if (balanceFactor > 1) {
        if (getHeight(node->left->left) >= getHeight(node->left->right)) {
            node = rightRotate(node);
        } else {
            node->left = leftRotate(node->left);
            node = rightRotate(node);
        }
    } else if (balanceFactor < -1) {
        if (getHeight(node->right->right) >= getHeight(node->right->left)) {
            node = leftRotate(node);
        } else {
            node->right = rightRotate(node->right);
            node = leftRotate(node);
        }
    }

    return node;
}

// Function to insert a new node into the AVL tree
Node* insertNode(Node* node, int key) {
    if (node == NULL) {
        return createNode(key);
    }

    if (key < node->key) {
        node->left = insertNode(node->left, key);
    } else if (key > node->key) {
        node->right = insertNode(node->right, key);
    }

    return rebalance(node);
}

// Function to free the AVL tree
void freeTree(Node* node) {
    if (node == NULL) {
        return;
    }
    freeTree(node->left);
    freeTree(node->right);
    free(node);
}

int main() {
    Node* root = NULL;
    for (int i = 0; i < 1000; i++) {
        root = insertNode(root, i);
    }
    freeTree(root);
    return 0;
}