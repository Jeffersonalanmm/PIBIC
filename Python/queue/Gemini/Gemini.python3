import random
class Queue:
    def __init__(self):
        self.queue = []

    def enqueue(self, item):
        self.queue.append(item)

    def dequeue(self):
        if not self.is_empty():
            return self.queue.pop(0)
        else:
            raise IndexError("Queue is empty")

    def is_empty(self):
        return len(self.queue) == 0

    def peek(self):
        if not self.is_empty():
            return self.queue[0]
        else:
            raise IndexError("Queue is empty")
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