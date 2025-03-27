def heapify(arr, n, i):
    """
    Heapify the array at index i.

    :param arr: The input array.
    :param n: The size of the heap.
    :param i: The index to heapify.
    """
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    # Check if the left child is larger than the root.
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Check if the right child is larger than the largest so far.
    if right < n and arr[right] > arr[largest]:
        largest = right

    # If the largest is not the root, swap and heapify the affected sub-tree.
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)


def heap_sort(arr):
    """
    Sort the array using heap sort.

    :param arr: The input array.
    """
    n = len(arr)

    # Build a max heap.
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements one by one.
    for i in range(n - 1, 0, -1):
        # Swap the root (max element) with the last element.
        arr[0], arr[i] = arr[i], arr[0]
        # Heapify the reduced heap.
        heapify(arr, i, 0)


import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    heap_sort(arr)

if __name__ == "__main__":
    main()