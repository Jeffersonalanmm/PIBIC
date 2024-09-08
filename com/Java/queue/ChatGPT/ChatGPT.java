public class Queue {
    private int[] queueArray;  // Array to store queue elements
    private int front;         // Index of the front element
    private int rear;          // Index of the last element
    private int size;          // Current size of the queue
    private int capacity;      // Maximum capacity of the queue

    // Constructor to initialize queue
    public Queue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element: " + element);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queueArray[rear] = element;
        size++;
        System.out.println("Enqueued: " + element);
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return -1 or throw an exception based on use case
        }
        int element = queueArray[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + element);
        return element;
    }

    // Method to get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return -1; // Return -1 or throw an exception based on use case
        }
        return queueArray[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the current size of the queue
    public int getSize() {
        return size;
    }

    // Main method to demonstrate the working of the queue
    public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue of capacity 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element is: " + queue.peek());
        queue.dequeue();
        System.out.println("Front element after dequeue is: " + queue.peek());

        queue.enqueue(60); // This will not add as the queue is full

        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        queue.dequeue(); // Trying to dequeue from an empty queue
    }
}
