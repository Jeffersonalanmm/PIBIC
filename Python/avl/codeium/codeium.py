class Node:
    """Represents a node in the AVL tree."""
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:
    """Represents an AVL tree."""
    def __init__(self):
        self.root = None

    def insert(self, key):
        """Inserts a new key into the tree."""
        self.root = self._insert(self.root, key)

    def _insert(self, node, key):
        if node is None:
            return Node(key)
        elif key < node.key:
            node.left = self._insert(node.left, key)
        else:
            node.right = self._insert(node.right, key)

        node.height = 1 + max(self._height(node.left), self._height(node.right))

        balance = self._balance(node)

        # Left-left case
        if balance > 1 and key < node.left.key:
            return self._right_rotate(node)

        # Right-right case
        if balance < -1 and key > node.right.key:
            return self._left_rotate(node)

        # Left-right case
        if balance > 1 and key > node.left.key:
            node.left = self._left_rotate(node.left)
            return self._right_rotate(node)

        # Right-left case
        if balance < -1 and key < node.right.key:
            node.right = self._right_rotate(node.right)
            return self._left_rotate(node)

        return node

    def _height(self, node):
        if node is None:
            return 0
        return node.height

    def _balance(self, node):
        if node is None:
            return 0
        return self._height(node.left) - self._height(node.right)

    def _left_rotate(self, node):
        pivot = node.right
        node.right = pivot.left
        pivot.left = node

        node.height = 1 + max(self._height(node.left), self._height(node.right))
        pivot.height = 1 + max(self._height(pivot.left), self._height(pivot.right))

        return pivot

    def _right_rotate(self, node):
        pivot = node.left
        node.left = pivot.right
        pivot.right = node

        node.height = 1 + max(self._height(node.left), self._height(node.right))
        pivot.height = 1 + max(self._height(pivot.left), self._height(pivot.right))

        return pivot

    def inorder(self):
        """Prints the keys in the tree in inorder traversal."""
        self._inorder(self.root)

    def _inorder(self, node):
        if node:
            self._inorder(node.left)
            print(node.key, end=" ")
            self._inorder(node.right)

import random

def main():
    # Criar uma instância da árvore AVL
    tree = AVLTree()

    # Gerar 1000 números aleatórios
    numeros = random.sample(range(1, 10001), 1000)

    # Inserir os números na árvore AVL
    for numero in numeros:
        tree.insert(numero)

if __name__ == "__main__":
    main()