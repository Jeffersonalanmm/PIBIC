def quicksort(arr):
  """Sorts an array of elements using the Quicksort algorithm."""

  if len(arr) <= 1:
    return arr

  # Choose a pivot element (you can use different strategies)
  pivot = arr[0]

  # Partition the array into two subarrays: elements smaller than pivot and elements greater than pivot
  left, right = [], []
  for num in arr[1:]:
    if num < pivot:
      left.append(num)
    else:
      right.append(num)

  # Recursively sort the subarrays and combine them with the pivot
  return quicksort(left) + [pivot] + quicksort(right)

# Example usage:
arr = [3, 8, 2, 5, 1]
sorted_arr = quicksort(arr)
print(sorted_arr)  # Output: [1, 2, 3, 5, 8]