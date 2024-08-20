def heapify(arr, n, i):
    largest = i  # Initialize largest as root
    left = 2 * i + 1  # left child
    right = 2 * i + 2  # right child

    # See if left child is larger than root
    if left < n and arr[largest] < arr[left]:
        largest = left

    # See if right child is larger than largest so far
    if right < n and arr[largest] < arr[right]:
        largest = right

    # If largest is not root, swap and heapify the affected subtree
    if largest != i:
        arr[i],        heapify(arr, n, largest)

def heapsort(arr):
    n = len(arr)

    # Build a max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements one by one
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # Swap
        heapify(arr, i, 0)

# Example usage
arr = [12, 11, 13, 5, 6, 7]
heapsort(arr)
print("Sorted array is:", arr)
