def merge_sort(arr):
    """
    Sorts an array of integers using the Mergesort algorithm.

    Time complexity: O(n log n)
    Space complexity: O(n)

    :param arr: The array to be sorted
    :return: The sorted array
    """
    # Base case: If the array has only one element, it is already sorted
    if len(arr) <= 1:
        return arr

    # Split the array into two halves
    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    # Recursively sort the two halves
    left = merge_sort(left)
    right = merge_sort(right)

    # Merge the two sorted halves
    return merge(left, right)


def merge(left, right):
    """
    Merges two sorted arrays into a single sorted array.

    :param left: The first sorted array
    :param right: The second sorted array
    :return: The merged sorted array
    """
    result = []
    while len(left) > 0 and len(right) > 0:
        if left[0] <= right[0]:
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))
    result.extend(left)
    result.extend(right)
    return result