class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.left = None
        self.right = None
        self.height = 1  # Height of the node


class AVL:
    def __init__(self):
        self.root = None

    def get_height(self, node):
        if node is None:
            return 0
        return node.height

    def update_height(self, node):
        left_height = self.get_height(node.left)
        right_height = self.get_height(node.right)
        node.height = max(left_height, right_height) + 1

    def get_balance(self, node):
        if node is None:
            return 0
        return self.get_height(node.left) - self.get_height(node.right)

    def right_rotate(self, node):
        temp = node.left
        node.left = temp.right
        temp.right = node
        self.update_height(node)
        self.update_height(temp)
        return temp

    def left_rotate(self, node):
        temp = node.right
        node.right = temp.left
        temp.left = node
        self.update_height(node)
        self.update_height(temp)
        return temp

    def _insert(self, node, key, value):
        if node is None:
            return Node(key, value)
        if key < node.key:
            node.left = self._insert(node.left, key, value)
        else:
            node.right = self._insert(node.right, key, value)
        self.update_height(node)
        balance = self.get_balance(node)
        if balance > 1:
            if key < node.left.key:
                return self.right_rotate(node)
            else:
                node.left = self.left_rotate(node.left)
                return self.right_rotate(node)
        elif balance < -1:
            if key > node.right.key:
                return self.left_rotate(node)
            else:
                node.right = self.right_rotate(node.right)
                return self.left_rotate(node)
        return node

    def insert(self, key, value):
        self.root = self._insert(self.root, key, value)

    def _delete(self, node, key):
        if node is None:
            return node
        if key < node.key:
            node.left = self._delete(node.left, key)
        elif key > node.key:
            node.right = self._delete(node.right, key)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            else:
                min_val = self._find_min(node.right)
                node.key = min_val.key
                node.value = min_val.value
                node.right = self._delete(node.right, min_val.key)
        if node is None:
            return node
        self.update_height(node)
        balance = self.get_balance(node)
        if balance > 1:
            if self.get_balance(node.left) >= 0:
                return self.right_rotate(node)
            else:
                node.left = self.left_rotate(node.left)
                return self.right_rotate(node)
        elif balance < -1:
            if self.get_balance(node.right) <= 0:
                return self.left_rotate(node)
            else:
                node.right = self.right_rotate(node.right)
                return self.left_rotate(node)
        return node

    def _find_min(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

    def delete(self, key):
        self.root = self._delete(self.root, key)

    def _search(self, node, key):
        if node is None or node.key == key:
            return node
        if key < node.key:
            return self._search(node.left, key)
        return self._search(node.right, key)

    def search(self, key):
        return self._search(self.root, key)

    def pre_order_traversal(self, node):
        if node is not None:
            print(f"Key: {node.key}, Value: {node.value}, Height: {node.height}")
            self.pre_order_traversal(node.left)
            self.pre_order_traversal(node.right)

    def print_tree(self):
        self.pre_order_traversal(self.root)

import random
def main():
    # Create an AVL tree
    avl_tree = AVL()

    # Insert 1000 random values into the AVL tree
    for _ in range(1000):
        key = random.randint(1, 1000)
        value = random.randint(1, 1000)
        avl_tree.insert(key, value)

if __name__ == "__main__":
    main()