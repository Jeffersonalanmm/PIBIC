class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:
    def __init__(self):
        self.root = None

    def _height(self, node):
        if node is None:
            return 0
        return node.height

    def _balance_factor(self, node):
        if node is None:
            return 0
        return self._height(node.left) - self._height(node.right)

    def _right_rotate(self, y):
        x = y.left
        T2 = x.right

        # Perform rotation
        x.right = y
        y.left = T2

        # Update heights
        y.height = 1 + max(self._height(y.left), self._height(y.right))
        x.height = 1 + max(self._height(x.left), self._height(x.right))

        # Return new root
        return x

    def _left_rotate(self, x):
        y = x.right
        T2 = y.left

        # Perform rotation
        y.left = x
        x.right = T2

        # Update heights
        x.height = 1 + max(self._height(x.left), self._height(x.right))
        y.height = 1 + max(self._height(y.left), self._height(y.right))

        # Return new root
        return y

    def _insert(self, root, key):
        if root is None:
            return Node(key)

        if key < root.key:
            root.left = self._insert(root.left, key)
        else:
            root.right = self._insert(root.right, key)

        root.height = 1 + max(self._height(root.left), self._height(root.right))

        balance = self._balance_factor(root)

        # Left Left Case
        if balance > 1 and key < root.left.key:
            return self._right_rotate(root)

        # Right Right Case
        if balance < -1 and key > root.right.key:
            return self._left_rotate(root)

        # Left Right Case
        if balance > 1 and key > root.left.key:
            root.left = self._left_rotate(root.left)
            return self._right_rotate(root)

        # Right Left Case
        if balance < -1 and key < root.right.key:
            root.right = self._right_rotate(root.right)
            return self._left_rotate(root)

        return root

    def insert(self, key):
        self.root = self._insert(self.root, key)

    def _inorder_traversal(self, root):
        if root:
            self._inorder_traversal(root.left)
            print(root.key, end=" ")
            self._inorder_traversal(root.right)

    def inorder_traversal(self):
        self._inorder_traversal(self.root)
        print()

import random
def main():
    # Create an AVL tree
    avl_tree = AVLTree()

    # Insert 1000 random values into the AVL tree
    for _ in range(1000):
        key = random.randint(1, 1000)
        value = random.randint(1, 1000)
        avl_tree.insert(key)

if __name__ == "__main__":
    main()