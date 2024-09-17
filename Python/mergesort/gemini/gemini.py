import random
def mergesort(arr):
  """Sorts an array using the mergesort algorithm.

  Args:
    arr: The array to be sorted.

  Returns:
    The sorted array.
  """

  if len(arr) <= 1:
    return arr

  # Divide the array into two halves
  mid = len(arr) // 2
  left_half = arr[:mid]
  right_half = arr[mid:]

  # Recursively sort   
 
  left_half = mergesort(left_half)
  right_half = mergesort(right_half)

  # Merge the sorted halves
  return merge(left_half, right_half)

def merge(left, right):
  """Merges two sorted arrays into a single sorted array.

  Args:
    left: The left array.
    right: The right array.

  Returns:
    The merged array.
  """

  result = []
  i = j = 0

  while i < len(left) and j < len(right):
    if left[i] <= right[j]:
      result.append(left[i])
      i += 1
    else:
      result.append(right[j])
      j += 1

  result.extend(left[i:])
  result.extend(right[j:])

  return result 

if __name__ == "__main__":
    # Generate 1000 random values
    random_list = [random.randint(0, 1000) for _ in range(1000)]
    
    # Sort the list using merge sort
    sorted_list = mergesort(random_list)