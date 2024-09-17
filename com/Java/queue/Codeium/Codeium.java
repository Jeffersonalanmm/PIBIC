import java.util.NoSuchElementException;

public class Codeium<T> {
    private Node<T> head; // front of the queue
    private Node<T> tail; // back of the queue
    private int size; // number of elements in the queue

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Codeium() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element the element to add
     */
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes an element from the front of the queue.
     *
     * @return the removed element
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        int capacity = 1000; // Number of random values to generate
        Codeium<Integer> queue = new Codeium<>();

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

        // You can now use 'array' for further processing if needed
    }
}