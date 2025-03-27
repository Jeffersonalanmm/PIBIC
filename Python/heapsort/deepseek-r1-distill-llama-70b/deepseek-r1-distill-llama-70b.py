def heapify(arr, n, i):
    """
    Transforms a subtree rooted at index i into a max-heap.
    
    :param arr: The array to heapify.
    :param n: The size of the heap.
    :param i: The index of the root of the subtree.
    :return: None
    """
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[largest]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)


def heap_sort(arr):
    """
    Sorts an array using the Heap Sort algorithm.
    
    :param arr: The array to be sorted.
    :return: The sorted array in ascending order.
    """
    n = len(arr)

    # Build a max-heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements one by one
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

    return arr


import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    heap_sort(arr)

if __name__ == "__main__":
    main()