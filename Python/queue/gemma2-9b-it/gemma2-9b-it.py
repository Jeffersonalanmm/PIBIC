class Queue:
    """
    Implementation of a Queue data structure using a Python list.
    """

    def __init__(self):
        """
        Initializes an empty queue.
        """
        self.items = []

    def enqueue(self, item):
        """
        Adds an item to the rear of the queue.

        Args:
            item: The item to be added.
        """
        self.items.append(item)

    def dequeue(self):
        """
        Removes and returns the item at the front of the queue.

        Returns:
            The item at the front of the queue.
            Raises an IndexError if the queue is empty.
        """
        if self.is_empty():
            raise IndexError("Cannot dequeue from an empty queue")
        return self.items.pop(0)

    def peek(self):
        """
        Returns the item at the front of the queue without removing it.

        Returns:
            The item at the front of the queue.
            Raises an IndexError if the queue is empty.
        """
        if self.is_empty():
            raise IndexError("Cannot peek into an empty queue")
        return self.items[0]

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

    def __str__(self):
        """
        Returns a string representation of the queue.

        Returns:
            A string representation of the queue.
        """
        return str(self.items)


def main():
    q = Queue()
    for i in range(1000):
        q.enqueue(i)
    for _ in range(500):
        q.dequeue()

if __name__ == "__main__":
    main()
