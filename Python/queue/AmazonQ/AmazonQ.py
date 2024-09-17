import random
class Queue:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return len(self.items) == 0

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if not self.is_empty():
            return self.items.pop(0)
        else:
            raise IndexError("Cannot dequeue from an empty queue")

    def front(self):
        if not self.is_empty():
            return self.items[0]
        else:
            raise IndexError("Queue is empty")

    def size(self):
        return len(self.items)

    def __str__(self):
        return str(self.items)


# Example usage:
if __name__ == "__main__":
    q = Queue()

    # Enqueue some items
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)

    print("Queue after enqueuing 1, 2, 3:", q)
    print("Front of the queue:", q.front())
    print("Queue size:", q.size())

    # Dequeue an item
    dequeued = q.dequeue()
    print("Dequeued item:", dequeued)
    print("Queue after dequeuing:", q)

    # Check if the queue is empty
    print("Is the queue empty?", q.is_empty())

    # Dequeue remaining items
    print("Dequeuing remaining items:")
    while not q.is_empty():
        print(q.dequeue())

    # Try to dequeue from an empty queue
    try:
        q.dequeue()
    except IndexError as e:
        print("Error:", str(e))
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