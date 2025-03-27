class Node:
    """Represents a node in the linked list."""
    def __init__(self, value):
        self.value = value
        self.next = None

class Queue:
    """Represents a queue data structure."""
    def __init__(self):
        self.front = None
        self.rear = None
        self.size = 0

    def is_empty(self):
        """Checks if the queue is empty."""
        return self.size == 0

    def enqueue(self, value):
        """Adds an element to the end of the queue."""
        node = Node(value)
        if self.is_empty():
            self.front = node
            self.rear = node
        else:
            self.rear.next = node
            self.rear = node
        self.size += 1

    def dequeue(self):
        """Removes an element from the front of the queue."""
        if self.is_empty():
            raise IndexError("Cannot dequeue from an empty queue")
        value = self.front.value
        self.front = self.front.next
        if self.front is None:
            self.rear = None
        self.size -= 1
        return value

    def peek(self):
        """Returns the element at the front of the queue without removing it."""
        if self.is_empty():
            raise IndexError("Cannot peek into an empty queue")
        return self.front.value

    def __len__(self):
        """Returns the number of elements in the queue."""
        return self.size

    def __str__(self):
        """Returns a string representation of the queue."""
        values = []
        current = self.front
        while current:
            values.append(str(current.value))
            current = current.next
        return " -> ".join(values)

def main():
    q = Queue()
    for i in range(1000):
        q.enqueue(i)
    for _ in range(500):
        q.dequeue()

if __name__ == "__main__":
    main()
