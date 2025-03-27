class Queue:
    """
    A basic implementation of a queue in Python.

    Attributes:
        queue (list): The underlying list that stores the queue elements.
    """

    def __init__(self):
        """
        Initializes an empty queue.
        """
        self.queue = []

    def enqueue(self, item):
        """
        Adds an item to the end of the queue.

        Args:
            item: The item to be added to the queue.
        """
        self.queue.append(item)

    def dequeue(self):
        """
        Removes an item from the front of the queue.

        Returns:
            The item removed from the queue. If the queue is empty, raises an IndexError.
        """
        if self.is_empty():
            raise IndexError("Cannot dequeue from an empty queue")
        return self.queue.pop(0)

    def peek(self):
        """
        Returns the item at the front of the queue without removing it.

        Returns:
            The item at the front of the queue. If the queue is empty, raises an IndexError.
        """
        if self.is_empty():
            raise IndexError("Cannot peek into an empty queue")
        return self.queue[0]

    def is_empty(self):
        """
        Checks if the queue is empty.

        Returns:
            True if the queue is empty, False otherwise.
        """
        return len(self.queue) == 0

    def size(self):
        """
        Returns the number of items in the queue.

        Returns:
            The number of items in the queue.
        """
        return len(self.queue)

    def __str__(self):
        """
        Returns a string representation of the queue.

        Returns:
            A string representation of the queue.
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
