def merge_sort(arr):
    """
    Sorts a list using the Merge Sort algorithm.

    Args:
        arr: The list to be sorted.

    Returns:
        The sorted list.
    """

    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left_half = merge_sort(arr[:mid])
    right_half = merge_sort(arr[mid:])

    return merge(left_half, right_half)

def merge(left, right):
    """
    Merges two sorted lists into a single sorted list.

    Args:
        left: The first sorted list.
        right: The second sorted list.

    Returns:
        A new sorted list containing all elements from both input lists.
    """

    merged = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            merged.append(left[i])
            i += 1
        else:
            merged.append(right[j])
            j += 1

    # Append any remaining elements from the left or right list
    merged.extend(left[i:])
    merged.extend(right[j:])

    return merged

import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    merge_sort(arr)

if __name__ == "__main__":
    main()
