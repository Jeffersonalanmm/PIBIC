import java.util.NoSuchElementException;
public class BlackBox<T> {
    private Node<T> front; // front of the queue
    private Node<T> rear; // rear of the queue
    private int size; // number of elements in the queue

    // Node class for the linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // constructor
    public BlackBox() {
        front = null;
        rear = null;
        size = 0;
    }

    // enqueue operation (add element to the rear of the queue)
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // dequeue operation (remove element from the front of the queue)
    public T dequeue() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return element;
    }

    // peek operation (return the front element without removing it)
    public T peek() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    // size operation (return the number of elements in the queue)
    public int size() {
        return size;
    }

    // isEmpty operation (check if the queue is empty)
    public boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
        // Create an instance of BlackBox for Integer type
        BlackBox<Integer> queue = new BlackBox<>();

        // Generate 1000 random values and enqueue them
        Random rand = new Random();
        int size = 1000;

        for (int i = 0; i < size; i++) {
            queue.enqueue(rand.nextInt(10000)); // Random values between 0 and 9999
        }

        // Dequeue all values to an array
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = queue.dequeue();
        }

        // Sort the array using merge sort
        mergeSort(array);

        // No print statements as requested
    }
}