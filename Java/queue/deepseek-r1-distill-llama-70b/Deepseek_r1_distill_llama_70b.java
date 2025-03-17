import java.util.Random;

public class Deepseek_r1_distill_llama_70b<T> {

    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public static void main(String[] args) {
        Deepseek_r1_distill_llama_70b<Integer> queue = new Deepseek_r1_distill_llama_70b<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(10000);
            queue.enqueue(value);
        }
    }
}