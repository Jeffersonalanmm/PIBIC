import random

def is_sorted(arr):
    return all(arr[i] <= arr[i + 1] for i in range(len(arr) - 1))

def bogosort(arr):
    while not is_sorted(arr):
        random.shuffle(arr)
    return arr

def main():
    # Generate a list of 1000 random values
    random_values = [random.randint(0, 10000) for _ in range(1000)]
    sorted_values = bogosort(random_values)
    return sorted_values

if __name__ == "__main__":
    main()