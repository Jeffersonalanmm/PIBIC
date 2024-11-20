import random

def binary_search(arr, target):
    """
    Searches for the target value in the sorted array using binary search.

    Args:
        arr (list): A sorted list of integers.
        target (int): The value to search for.

    Returns:
        int: The index of the target value if found, -1 otherwise.
    """
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

def main():
    # Generate a sorted list of 1000 random integers
    arr = sorted([random.randint(0, 10000) for _ in range(1000)])
    target = random.choice(arr)

    # Perform binary search
    index = binary_search(arr, target)

    # Return the result (no print statements)
    return index

if __name__ == "__main__":
    main()