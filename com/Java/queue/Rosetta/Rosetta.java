public class Rosetta<E>{
    Node<E> head = null, tail = null;

    static class Node<E>{
        E value;
        Node<E> next;

        Node(E value, Node<E> next){
            this.value= value;
            this.next= next;
        }

    }

    public Rosetta(){
    }

    public void enqueue(E value){ //standard queue name for "push"
        Node<E> newNode= new Node<E>(value, null);
        if(empty()){
            head= newNode;
        }else{
            tail.next = newNode;
        }
        tail= newNode;
    }

    public E dequeue() throws java.util.NoSuchElementException{//standard queue name for "pop"
        if(empty()){
            throw new java.util.NoSuchElementException("No more elements.");
        }
        E retVal= head.value;
        head= head.next;
        return retVal;
    } 

    public boolean empty(){
        return head == null;
    }
    public static void main(String[] args) {
        Rosetta<Integer> queue = new Rosetta<>();
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