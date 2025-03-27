class Queue:
    def __init__(self):
        """
        Initializes an empty queue.
        """
        self.queue = []

    def enqueue(self, data):
        """
        Adds an item to the end of the queue.
        """
        self.queue.append(data)

    def dequeue(self):
        """
        Removes and returns the item at the front of the queue.
        Raises ValueError if the queue is empty.
        """
        if self.is_empty():
            raise ValueError("Queue is empty")
        return self.queue.pop(0)

    def peek(self):
        """
        Returns the item at the front of the queue without removing it.
        Raises ValueError if the queue is empty.
        """
        if self.is_empty():
            raise ValueError("Queue is empty")
        return self.queue[0]

    def is_empty(self):
        """
        Checks if the queue is empty.
        Returns True if empty, False otherwise.
        """
        return len(self.queue) == 0

    def size(self):
        """
        Returns the number of items in the queue.
        """
        return len(self.queue)

    def __str__(self):
        """
        Returns a string representation of the queue.
        """
        return str(self.queue)


def main():
    q = Queue()
    for i in range(1000):
        q.enqueue(i)
    for _ in range(500):
        q.dequeue()

if __name__ == "__main__":
    main()
