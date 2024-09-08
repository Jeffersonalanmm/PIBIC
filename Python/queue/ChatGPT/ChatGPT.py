from collections import deque

class Queue:
    def __init__(self):
        # Initialize an empty deque as the underlying data structure for the queue
        self.queue = deque()

    def enqueue(self, item):
        """Add an item to the end of the queue."""
        self.queue.append(item)
        print(f"Enqueued: {item}")

    def dequeue(self):
        """Remove and return an item from the front of the queue. 
        Returns None if the queue is empty."""
        if self.is_empty():
            print("Queue is empty, cannot dequeue.")
            return None
        item = self.queue.popleft()
        print(f"Dequeued: {item}")
        return item

    def peek(self):
        """Return the front item of the queue without removing it.
        Returns None if the queue is empty."""
        if self.is_empty():
            print("Queue is empty, nothing to peek.")
            return None
        return self.queue[0]

    def is_empty(self):
        """Check if the queue is empty."""
        return len(self.queue) == 0

    def size(self):
        """Return the number of items in the queue."""
        return len(self.queue)

    def display(self):
        """Display the elements in the queue."""
        print(f"Queue: {list(self.queue)}")

# Example usage:
if __name__ == "__main__":
    q = Queue()
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    q.display()
    print(f"Front item: {q.peek()}")
    q.dequeue()
    q.display()
    print(f"Queue size: {q.size()}")
