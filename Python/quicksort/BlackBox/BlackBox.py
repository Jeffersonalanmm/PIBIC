def quicksort(arr):
    """
    Sorts an array using the quicksort algorithm.

    Args:
        arr (list): The array to be sorted.

    Returns:
        list: The sorted array.
    """
    if len(arr) <= 1:
        # Base case: If the array has one or zero elements, it is already sorted.
        return arr
    else:
        # Select the pivot element (in this case, the middle element).
        pivot = arr[len(arr) // 2]
        
        # Divide the array into three sub-arrays: elements less than the pivot,
        # elements equal to the pivot, and elements greater than the pivot.
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]
        
        # Recursively sort the sub-arrays and combine the results.
        return quicksort(left) + middle + quicksort(right)

# Example usage:
arr = [5, 2, 9, 1, 7, 3]
print(quicksort(arr))  # Output: [1, 2, 3, 5, 7, 9]