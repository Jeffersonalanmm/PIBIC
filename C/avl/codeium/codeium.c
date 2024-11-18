#include <stdio.h>
#include <stdlib.h>
#include <math.h>  // Include math.h for fmax


// Structure to represent a node in the AVL tree
typedef struct Node {
    int key;
    struct Node* left;
    struct Node* right;
    int height;
} Node;

// Function prototypes
Node* insert_node(Node* node, Node* new_node);
Node* delete_node(Node* node, int key);
void destroy_node(Node* node);
int max(int a, int b);


// Structure to represent the AVL tree
typedef struct {
    Node* root;
} AVLTree;

// Function to create a new AVL tree
AVLTree* avl_tree_create() {
    AVLTree* tree = malloc(sizeof(AVLTree));
    tree->root = NULL;
    return tree;
}

// Function to get the height of a node
int get_height(Node* node) {
    if (node == NULL) return 0;
    return node->height;
}

// Function to update the height of a node
void update_height(Node* node) {
    node->height = 1 + max(get_height(node->left), get_height(node->right));
}

// Function to rotate right
Node* rotate_right(Node* node) {
    Node* temp = node->left;
    node->left = temp->right;
    temp->right = node;
    update_height(node);
    update_height(temp);
    return temp;
}

// Function to rotate left
Node* rotate_left(Node* node) {
    Node* temp = node->right;
    node->right = temp->left;
    temp->left = node;
    update_height(node);
    update_height(temp);
    return temp;
}

// Function to calculate the balance factor
int balance_factor(Node* node) {
    return get_height(node->left) - get_height(node->right);
}

// Function to rebalance the tree
Node* rebalance(Node* node) {
    int bf = balance_factor(node);
    if (bf > 1) {
        if (balance_factor(node->left) < 0) {
            node->left = rotate_left(node->left);
        }
        return rotate_right(node);
    } else if (bf < -1) {
        if (balance_factor(node->right) > 0) {
            node->right = rotate_right(node->right);
        }
        return rotate_left(node);
    }
    return node;
}

// Function to insert a node into the AVL tree
void avl_tree_insert(AVLTree* tree, int key) {
    Node* new_node = malloc(sizeof(Node));
    new_node->key = key;
    new_node->left = NULL;
    new_node->right = NULL;
    new_node->height = 1;
    tree->root = insert_node(tree->root, new_node);
}

// Helper function to insert a node into the AVL tree
Node* insert_node(Node* node, Node* new_node) {
    if (node == NULL) {
        return new_node;
    }
    if (new_node->key < node->key) {
        node->left = insert_node(node->left, new_node);
    } else if (new_node->key > node->key) {
        node->right = insert_node(node->right, new_node);
    }
    update_height(node);
    return rebalance(node);
}

// Function to delete a node from the AVL tree
void avl_tree_delete(AVLTree* tree, int key) {
    tree->root = delete_node(tree->root, key);
}

// Helper function to delete a node from the AVL tree
Node* delete_node(Node* node, int key) {
    if (node == NULL) return NULL;
    if (key < node->key) {
        node->left = delete_node(node->left, key);
    } else if (key > node->key) {
        node->right = delete_node(node->right, key);
    } else {
        if (node->left == NULL) {
            Node* temp = node->right;
            free(node);
            return temp;
        } else if (node->right == NULL) {
            Node* temp = node->left;
            free(node);
            return temp;
        }
        Node* temp = node->right;
        while (temp->left != NULL) {
            temp = temp->left;
        }
        node->key = temp->key;
        node->right = delete_node(node->right, temp->key);
    }
    update_height(node);
    return rebalance(node);
}

// Function to destroy the AVL tree
void avl_tree_destroy(AVLTree* tree) {
    destroy_node(tree->root);
    free(tree);
}

// Helper function to destroy the AVL tree
void destroy_node(Node* node) {
    if (node == NULL) return;
    destroy_node(node->left);
    destroy_node(node->right);
    free(node);
}

// Max function to return the larger of two integers
int max(int a, int b) {
    return (a > b) ? a : b;
}

int main() {
    AVLTree* tree = avl_tree_create();
    for (int i = 0; i < 1000; i++) {
        avl_tree_insert(tree, i);
    }
    return 0;
}
