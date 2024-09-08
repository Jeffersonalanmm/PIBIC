class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 1 def height(node):
    if not node:
        return 0
    return node.height

def right_rotate(y):
    x = y.left
    T2 = x.right
    x.right = y
    y.left = T2
    y.height = 1 + max(height(y.left), height(y.right))
    x.height = 1 + max(height(x.left), height(x.right))
    return x

def left_rotate(x):
    y = x.right
    T2 = y.left
    y.left = x
    x.right = T2
    x.height = 1 + max(height(x.left), height(x.right))
    y.height = 1 + max(height(y.left), height(y.right))
    return y

def get_balance(node):
    if not node:
        return 0
    return height(node.left) - height(node.right)

def insert(node, key):
    if not node:
        return Node(key)
    if key < node.key:
        node.left = insert(node.left, key)
    elif key > node.key:
        node.right = insert(node.right, key)
    else:
        return node
    node.height = 1 + max(height(node.left), height(node.right))
    balance = get_balance(node)
    if balance > 1 and key < node.left.key:
        return right_rotate(node)
    if balance < -1 and key > node.right.key:
        return left_rotate(node)
    if balance > 1 and key > node.left.key:
        node.left = left_rotate(node.left)
        return right_rotate(node)
    if balance < -1 and key < node.right.key:
        node.right = right_rotate(node.right)
        return left_rotate(node)
    return node

def pre_order(root):
    if root:
        print(root.key, end=" ")
        pre_order(root.left)
        pre_order(root.right)

import random

def main():
    num_iterations = 1000
    num_elements = 1000  # Número de elementos para inserir em cada iteração

    for _ in range(num_iterations):
        root = None
        for _ in range(num_elements):
            key = random.randint(1, 1000)
            root = insert(root, key)

if __name__ == "__main__":
    main()
