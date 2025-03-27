def binary_search(arr, target):
    """
    Searches for an element in a sorted array using binary search.

    Args:
        arr (list): A sorted list of elements.
        target: The element to search for.

    Returns:
        int: The index of the target element if found, -1 otherwise.
    """
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1

    return -1

import random

def main():
    # Generate a sorted list of 1000 integers
    sorted_list = sorted([random.randint(1, 1000) for _ in range(1000)])

    # Perform binary search for a random target
    target = random.choice(sorted_list)
    binary_search(sorted_list, target)

if __name__ == "__main__":
    main()
