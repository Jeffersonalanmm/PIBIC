import java.util.Random;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class BlackBox {
    private Node front;
    private Node rear;
    private int size;

    public BlackBox() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        BlackBox queue = new BlackBox();
        Random random = new Random();

        // Enqueue 1000 random values
        for (int i = 0; i < 1000; i++) {
            int randomValue = random.nextInt(10000); // Random value between 0 and 9999
            queue.enqueue(randomValue);
        }

        // Optional: Dequeue all elements (not printed)
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

}
