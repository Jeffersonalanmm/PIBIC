def merge_sort(arr):
    """
    Sorts an array using the merge sort algorithm.

    Args:
        arr (list): The list of elements to be sorted.

    Returns:
        list: The sorted list of elements.
    """
    # Base case: If the array has 1 or fewer elements, it is already sorted.
    if len(arr) <= 1:
        return arr

    # Find the middle index of the array.
    mid = len(arr) // 2

    # Divide the array into two halves.
    left_half = arr[:mid]
    right_half = arr[mid:]

    # Recursively sort each half.
    left_half = merge_sort(left_half)
    right_half = merge_sort(right_half)

    # Merge the two sorted halves.
    return merge(left_half, right_half)


def merge(left, right):
    """
    Merges two sorted lists into a single sorted list.

    Args:
        left (list): The first sorted list.
        right (list): The second sorted list.

    Returns:
        list: The merged sorted list.
    """
    merged = []
    left_index = 0
    right_index = 0

    # Merge smaller elements first.
    while left_index < len(left) and right_index < len(right):
        if left[left_index] <= right[right_index]:
            merged.append(left[left_index])
            left_index += 1
        else:
            merged.append(right[right_index])
            right_index += 1

    # If there are remaining elements in either list, append them to the merged list.
    merged.extend(left[left_index:])
    merged.extend(right[right_index:])

    return merged


import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    merge_sort(arr)

if __name__ == "__main__":
    main()
