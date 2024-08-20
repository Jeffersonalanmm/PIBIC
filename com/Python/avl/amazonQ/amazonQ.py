class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:
    def __init__(self):
        self.root = None

    def height(self, node):
        if node is None:
            return 0
        return node.height

    def balance_factor(self, node):
        if node is None:
            return 0
        return self.height(node.left) - self.height(node.right)

    def rotate_right(self, node):
        left_child = node.left
        node.left = left_child.right
        left_child.right = node
        node.height = 1 + max(self.height(node.left), self.height(node.right))
        left_child.height = 1 + max(self.height(left_child.left), self.height(left_child.right))
        return left_child

    def rotate_left(self, node):
        right_child = node.right
        node.right = right_child.left
        right_child.left = node
        node.height = 1 + max(self.height(node.left), self.height(node.right))
        right_child.height = 1 + max(self.height(right_child.left), self.height(right_child.right))
        return right_child

    def insert(self, data):
        self.root = self._insert(self.root, data)

    def _insert(self, node, data):
        if node is None:
            return Node(data)

        if data < node.data:
            node.left = self._insert(node.left, data)
        else:
            node.right = self._insert(node.right, data)

        node.height = 1 + max(self.height(node.left), self.height(node.right))
        balance = self.balance_factor(node)

        if balance > 1 and data < node.left.data:
            return self.rotate_right(node)

        if balance < -1 and data > node.right.data:
            return self.rotate_left(node)

        if balance > 1 and data > node.left.data:
            node.left = self.rotate_left(node.left)
            return self.rotate_right(node)

        if balance < -1 and data < node.right.data:
            node.right = self.rotate_right(node.right)
            return self.rotate_left(node)

        return node
