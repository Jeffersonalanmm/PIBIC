import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class Mixtral_8x7b_32768<T> {
    private Queue<T> queue = new LinkedList<T>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        Mixtral_8x7b_32768<Integer> queue = new Mixtral_8x7b_32768<>();
        Random random = new Random();

        // Enqueue 1000 random values
        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(10000); // Números aleatórios de 0 a 9999
            queue.enqueue(value);
        }
    }
}