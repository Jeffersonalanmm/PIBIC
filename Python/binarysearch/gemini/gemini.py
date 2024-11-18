def binary_search(arr, target):
    """Performs a binary search on a sorted array to find the target value.

    Args:
        arr: A sorted list of elements.
        target: The value to search for.

    Returns:
        The index of the target value if found, otherwise -1.
    """

    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1

if __name__ == "__main__":
    # Create a sorted array of 1000 values
    arr = sorted(range(1000))

    # Target value to search for
    target = 500

    # Perform binary search
    result = binary_search(arr, target)