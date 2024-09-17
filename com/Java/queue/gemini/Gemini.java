import java.util.NoSuchElementException;

public class Gemini<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Gemini() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
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
    
    public static void main(String[] args) {
        Gemini<Integer> queue = new Gemini<>();
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