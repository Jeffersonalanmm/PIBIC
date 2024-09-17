import random
class FIFO(object):
    def __init__(self, *args):
        self.contents = list(args)
    def __call__(self):
        return self.pop()
    def __len__(self):
        return len(self.contents)
    def pop(self):
        return self.contents.pop(0)
    def push(self, item):
        self.contents.append(item)
    def extend(self,*itemlist):
        self.contents += itemlist
    def empty(self):
        return bool(self.contents)
    def __iter__(self):
        return self
    def next(self):
        if self.empty():
            raise StopIteration
        return self.pop()

def main():
    fifo_queue = FIFO()

    # Generate and push 1000 random values into the FIFO queue
    for _ in range(1000):
        fifo_queue.push(random.randint(1, 10000))

    # Pop all items from the queue
    while not fifo_queue.empty():
        fifo_queue.pop()

    # Attempt to pop from an empty queue (this will raise an exception)
    try:
        fifo_queue.pop()
    except IndexError:
        pass  # Handling the exception gracefully

if __name__ == "__main__":
    main()