def heapify(arr, n, i):
    """
    Heapify a subtree rooted at index i.
    """
    largest = i  # Initialize largest as root
    l = 2 * i + 1  # left = 2*i + 1
    r = 2 * i + 2  # right = 2*i + 2

    # If left child is larger than root
    if l < n and arr[largest] < arr[l]:
        largest = l

    # If right child is larger than largest so far
    if r < n and arr[largest] < arr[r]:
        largest = r

    # If largest is not root
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # swap

        # Recursively heapify the affected sub-tree
        heapify(arr, n, largest)


def heap_sort(arr):
    """
    Sorts an array using Heap Sort algorithm.
    """
    n = len(arr)

    # Build a max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements from heap one by one
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]  # Swap root with last element
        heapify(arr, i, 0)  # Heapify the reduced heap


import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    heap_sort(arr)

if __name__ == "__main__":
    main()