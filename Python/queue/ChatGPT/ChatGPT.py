from collections import deque
import random
class Queue:
    def __init__(self):
        # Initialize an empty deque as the underlying data structure for the queue
        self.queue = deque()

    def enqueue(self, item):
        """Add an item to the end of the queue."""
        self.queue.append(item)
        

    def dequeue(self):
        """Remove and return an item from the front of the queue. 
        Returns None if the queue is empty."""
        if self.is_empty():
            
            return None
        item = self.queue.popleft()
        
        return item

    def peek(self):
        """Return the front item of the queue without removing it.
        Returns None if the queue is empty."""
        if self.is_empty():
            
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


def main():
    q = Queue()
    # Enqueue 1000 random values
    for _ in range(1000):
        q.enqueue(random.randint(1, 10000))

    # Dequeue all items
    while not q.is_empty():
        q.dequeue()

    # Attempt to dequeue from an empty queue (will raise an exception)
    try:
        q.dequeue()
    except IndexError:
        pass  # Handling the exception gracefully

if __name__ == "__main__":
    main()