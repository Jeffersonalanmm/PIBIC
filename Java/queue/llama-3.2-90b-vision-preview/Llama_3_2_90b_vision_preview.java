import java.util.Random;
public class Llama_3_2_90b_vision_preview<T> {

    private Node<T> head; // the front of the queue
    private Node<T> tail; // the back of the queue
    private int size; // the number of elements in the queue

    /**
     * Creates an empty queue.
     */
    public Llama_3_2_90b_vision_preview() {
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
     * @return the removed element, or null if the queue is empty
     */
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T element = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return element;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T peek() {
        return head == null ? null : head.data;
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

    /**
     * A node in the linked list.
     *
     * @param <T> the type of the node's data
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

        public static void main(String[] args) {
        Llama_3_2_90b_vision_preview<Integer> queue = new Llama_3_2_90b_vision_preview<>();
        Random random = new Random();

        // Enqueue 1000 random values
        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(10000); // Números aleatórios de 0 a 9999
            queue.enqueue(value);
        }

        // Dequeue and print values
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}