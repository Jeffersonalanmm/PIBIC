import java.util.Random;

public class Copilot {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Copilot(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        size = 0;
        rear = capacity - 1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    // Remove an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Get the front item of the queue
    public int front() {
        if (isEmpty()) {

            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    // Get the rear item of the queue
    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }
    public static void main(String[] args) {
        int capacity = 1000;
        Copilot queue = new Copilot(capacity);
        Random random = new Random();

        // Enqueue 1000 random values
        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(1000); // Random value between 0 and 999
            queue.enqueue(value);
        }

        // Dequeue all values
        for (int i = 0; i < 1000; i++) {
            queue.dequeue();
        }
    }
}