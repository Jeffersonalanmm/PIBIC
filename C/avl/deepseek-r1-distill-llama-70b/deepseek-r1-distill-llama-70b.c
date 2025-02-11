#include <stdlib.h>
#include <time.h>
#include <stdio.h>

typedef struct Node {
    int key;
    int height;
    struct Node* left;
    struct Node* right;
} Node;

// Function to create a new node
Node* createNode(int key) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    if (!newNode) {
        return NULL;
    }
    newNode->key = key;
    newNode->height = 1;
    newNode->left = newNode->right = NULL;
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
    node->height = 1 + ((getHeight(node->left) > getHeight(node->right)) ? 
                        getHeight(node->left) : getHeight(node->right));
}

// Function to right rotate a node
Node* rightRotate(Node* node) {
    Node* temp = node->left;
    Node* tempRight = temp->right;

    temp->right = node;
    node->left = tempRight;

    updateHeight(node);
    updateHeight(temp);

    return temp;
}

// Function to left rotate a node
Node* leftRotate(Node* node) {
    Node* temp = node->right;
    Node* tempLeft = temp->left;

    temp->left = node;
    node->right = tempLeft;

    updateHeight(node);
    updateHeight(temp);

    return temp;
}

// Function to rebalance the tree
Node* rebalance(Node* node) {
    int balance = getHeight(node->left) - getHeight(node->right);

    if (balance > 1) {
        if (getHeight(node->left->left) >= getHeight(node->left->right)) {
            node = rightRotate(node);
        } else {
            node->left = leftRotate(node->left);
            node = rightRotate(node);
        }
    } else if (balance < -1) {
        if (getHeight(node->right->right) >= getHeight(node->right->left)) {
            node = leftRotate(node);
        } else {
            node->right = rightRotate(node->right);
            node = leftRotate(node);
        }
    }

    return node;
}

// Function to insert a new key into the tree
Node* insert(Node* node, int key) {
    if (node == NULL) {
        return createNode(key);
    }

    if (key < node->key) {
        node->left = insert(node->left, key);
    } else if (key > node->key) {
        node->right = insert(node->right, key);
    }

    updateHeight(node);
    node = rebalance(node);

    return node;
}

// Function to find the in-order successor of a node
Node* inOrderSuccessor(Node* node) {
    Node* current = node;
    while (current->left != NULL) {
        current = current->left;
    }
    return current;
}

// Function to delete a node from the tree
Node* deleteNode(Node* node, int key) {
    if (node == NULL)
        return node;

    if (key < node->key) {
        node->left = deleteNode(node->left, key);
    } else if (key > node->key) {
        node->right = deleteNode(node->right, key);
    } else {
        if (node->left == NULL) {
            Node* temp = node->right;
            free(node);
            return temp;
        } else if (node->right == NULL) {
            Node* temp = node->left;
            free(node);
            return temp;
        } else {
            Node* temp = inOrderSuccessor(node->right);
            node->key = temp->key;
            node->right = deleteNode(node->right, temp->key);
        }
    }

    if (node == NULL)
        return node;

    updateHeight(node);
    node = rebalance(node);

    return node;
}

int main() {
    srand(time(NULL));
    
    Node* root = NULL;

    // Generate 1000 unique random values
    int values[1000];
    for (int i = 0; i < 1000; i++) {
        values[i] = i + 1; // Generate numbers from 1 to 1000
    }

    // Shuffle the array to randomize the order
    for (int i = 999; i > 0; i--) {
        int j = rand() % (i + 1);
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    // Insert all values into the AVL Tree
    for (int i = 0; i < 1000; i++) {
        root = insert(root, values[i]);
    }

    return 0;
}