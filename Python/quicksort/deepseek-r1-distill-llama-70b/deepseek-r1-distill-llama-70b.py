def quicksort(arr):
    _quicksort(arr, 0, len(arr) - 1)
    return arr

def _quicksort(arr, low, high):
    if low < high:
        pivot_index = _partition(arr, low, high)
        _quicksort(arr, low, pivot_index - 1)
        _quicksort(arr, pivot_index + 1, high)

def _partition(arr, low, high):
    # Choose the middle element as the pivot
    pivot_index = (low + high) // 2
    pivot = arr[pivot_index]
    
    # Swap the pivot with the last element
    arr[pivot_index], arr[high] = arr[high], arr[pivot_index]
    
    # Initialize the index of the smaller element
    i = low - 1
    
    # Iterate through each element to partition
    for j in range(low, high):
        if arr[j] < pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    
    # Swap the pivot element to its correct position
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    quicksort(arr)

if __name__ == "__main__":
    main()
