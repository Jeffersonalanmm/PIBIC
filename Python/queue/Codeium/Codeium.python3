import random
class Queue:
    """
    A basic queue data structure implementation in Python.
    """

    def __init__(self):
        """
        Initializes an empty queue.
        """
        self.items = []

    def enqueue(self, item):
        """
        Adds an item to the end of the queue.

        Args:
            item: The item to add to the queue.
        """
        self.items.append(item)

    def dequeue(self):
        """
        Removes an item from the front of the queue.

        Returns:
            The item removed from the queue.

        Raises:
            IndexError: If the queue is empty.
        """
        if not self.is_empty():
            return self.items.pop(0)
        else:
            raise IndexError("Cannot dequeue from an empty queue")

    def is_empty(self):
        """
        Checks if the queue is empty.

        Returns:
            True if the queue is empty, False otherwise.
        """
        return len(self.items) == 0

    def size(self):
        """
        Returns the number of items in the queue.

        Returns:
            The number of items in the queue.
        """
        return len(self.items)

    def peek(self):
        """
        Returns the item at the front of the queue without removing it.

        Returns:
            The item at the front of the queue.

        Raises:
            IndexError: If the queue is empty.
        """
        if not self.is_empty():
            return self.items[0]
        else:
            raise IndexError("Cannot peek into an empty queue")

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