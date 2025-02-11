#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int key;
    int height;
    struct Node* left;
    struct Node* right;
} Node;

int getHeight(Node* node) {
    if (node == NULL) {
        return -1;
    }
    return node->height;
}

int getBalanceFactor(Node* node) {
    if (node == NULL) {
        return 0;
    }
    return getHeight(node->right) - getHeight(node->left);
}

Node* newNode(int key) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->key = key;
    node->height = 0;
    node->left = NULL;
    node->right = NULL;
    return node;
}

Node* rightRotate(Node* y) {
    Node* x = y->left;
    Node* T2 = x->right;

    x->right = y;
    y->left = T2;

    y->height = 1 + (y->left ? getHeight(y->left) : 0);
    x->height = 1 + (x->left ? getHeight(x->left) : 0);

    return x;
}

Node* leftRotate(Node* x) {
    Node* y = x->right;
    Node* T2 = y->left;

    y->left = x;
    x->right = T2;

    x->height = 1 + (x->left ? getHeight(x->left) : 0);
    y->height = 1 + (y->right ? getHeight(y->right) : 0);

    return y;
}

Node* insert(Node* node, int key) {
    if (node == NULL) {
        return newNode(key);
    }

    if (key < node->key) {
        node->left = insert(node->left, key);
    } else if (key > node->key) {
        node->right = insert(node->right, key);
    } else {
        return node;
    }

    node->height = 1 + (node->left ? getHeight(node->left) : 0);
    node->height = 1 + (node->right ? getHeight(node->right) : 0);

    int balanceFactor = getBalanceFactor(node);

    if (balanceFactor > 1 && key < node->left->key) {
        return rightRotate(node);
    }

    if (balanceFactor < -1 && key > node->right->key) {
        return leftRotate(node);
    }

    if (balanceFactor > 1 && key > node->left->key) {
        node->left = leftRotate(node->left);
        return rightRotate(node);
    }

    if (balanceFactor < -1 && key < node->right->key) {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }

    return node;
}

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
    int inputArray[1000];

    // Initialize the inputArray with 1000 values
    for (int i = 0; i < 1000; i++) {
        inputArray[i] = rand();
    }

    for (int i = 0; i < 1000; i++) {
        root = insert(root, inputArray[i]);
    }

    freeTree(root);

    return 0;
}