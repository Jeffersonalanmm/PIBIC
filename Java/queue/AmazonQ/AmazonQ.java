import java.util.NoSuchElementException;

public class AmazonQ<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public AmazonQ() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        int capacity = 1000; // Number of random values to generate
        AmazonQ<Integer> queue = new AmazonQ<>();

        // Generate 1000 random values and enqueue them
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < capacity; i++) {
            queue.enqueue(rand.nextInt(10000)); // Random values between 0 and 9999
        }

        // Dequeue all values to an array
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = queue.dequeue();
        }

        // Array 'array' now contains all the dequeued values
    }
}

