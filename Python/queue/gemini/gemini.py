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

if __name__ == "__main__":
    queue = Queue()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    print(queue.peek())  # Output: 1
    print(queue.dequeue())  # Output: 1
    print(queue.peek())  # Output: 2
    print(queue.is_empty())  # Output: False