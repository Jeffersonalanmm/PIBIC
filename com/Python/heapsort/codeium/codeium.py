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

    if left < n and arr[left] > arr[largest]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)


def heapsort(arr):
    """
    Sort the array using Heapsort.

    :param arr: The input array.
    """
    n = len(arr)

    # Build a max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements one by one
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)


# Example usage
arr = [12, 11, 13, 5, 6, 7]
heapsort(arr)
print("Sorted array:", arr)