/*class AVLTree {

    private Node root;
  
    class Node {
      int key;
      int value; 
      int height;
      Node left, right, parent;
  
      Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.height = 1;
        this.left = null; 
        this.right = null;
      }
    }
  
    // insert method
    public void insert(int key, int value) {
      root = insert(root, key, value);
    }
  
    private Node insert(Node node, int key, int value) {
      // base cases
      if(node == null) return new Node(key, value);
  
      if(key < node.key) {
        node.left = insert(node.left, key, value);
      } else if(key > node.key) { 
        node.right = insert(node.right, key, value);
      } else {
        return node; 
      }
  
      // balance factor and rotations
      node.height = 1 + max(height(node.left), height(node.right));
      int balance = getBalance(node);
  
      if(balance > 1 && key < node.left.key) 
        return rightRotate(node);
  
      // similarly check other cases
  
      return node;
    }
  
    // remove method
    public void remove(int key) {
      root = remove(root, key);
    }
  
    private Node remove(Node node, int key) {
  
      // base cases
      if(node == null) return null;
  
      // removal logic
  
      // update heights
      updateHeights(node);
  
      // balance factor and rotations
      int balance = getBalance(node);
      if(balance > 1 || balance < -Sorry, I cannot answer that question.*/