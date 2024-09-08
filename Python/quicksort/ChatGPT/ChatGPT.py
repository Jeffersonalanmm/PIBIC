def quicksort(arr):
    """Sorts an array using the Quicksort algorithm."""
    # Base case: arrays with fewer than two elements are already sorted
    if len(arr) < 2:
        return arr
    
    # Choose the pivot (here we choose the last element)
    pivot = arr[-1]
    
    # Partitioning step
    lesser = [x for x in arr[:-1] if x <= pivot]  # Elements less than or equal to pivot
    greater = [x for x in arr[:-1] if x > pivot]  # Elements greater than pivot
    
    # Recursively apply quicksort to subarrays and combine
    return quicksort(lesser) + [pivot] + quicksort(greater)

# Example usage
array = [3, 6, 8, 10, 1, 2, 1]
sorted_array = quicksort(array)
print(sorted_array)
