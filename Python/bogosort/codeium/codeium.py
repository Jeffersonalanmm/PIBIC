import random

def is_sorted(data):
    """Check if the input list is sorted."""
    return all(data[i] <= data[i + 1] for i in range(len(data) - 1))

def bogosort(data):
    """Bogosort algorithm."""
    while not is_sorted(data):
        random.shuffle(data)
    return data

def main():
    # Generate 1000 random values
    data = [random.randint(0, 10000) for _ in range(10)]
    bogosort(data)

if __name__ == "__main__":
    main()