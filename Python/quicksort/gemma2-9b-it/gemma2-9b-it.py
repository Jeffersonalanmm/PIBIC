def quick_sort(arr):
    """
    Sorts a list using the Quick Sort algorithm.

    Args:
        arr: The list to be sorted.

    Returns:
        The sorted list.
    """
    if len(arr) < 2:
        return arr  # Base case: already sorted

    pivot = arr[0]  # Choose the first element as the pivot
    less = [i for i in arr[1:] if i <= pivot]
    greater = [i for i in arr[1:] if i > pivot]

    return quick_sort(less) + [pivot] + quick_sort(greater)

import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    quick_sort(arr)

if __name__ == "__main__":
    main()