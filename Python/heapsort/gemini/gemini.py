def heapify(arr, n, i):
  """
  Heapifies a subtree rooted at index i.

  Args:
    arr: The input array.
    n: The size of the heap.
    i: The index of the root of the subtree.
  """
  largest = i  # Initialize largest as root
  left = 2 * i + 1  # left = 2*i + 1
  right = 2 * i + 2  # right = 2*i + 2

  # See if left child is larger than root
  if left < n and arr[left] > arr[largest]:
    largest = left

  # See if right child is larger than largest so far
  if right < n and arr[right] > arr[largest]:
    largest = right

  # If largest is not the root
  if largest != i:
    arr[i], arr[largest] = arr[largest], arr[i]  # swap

    # Recursively heapify the affected sub-tree
    heapify(arr, n, largest)

def heap_sort(arr):
  """
  Sorts the given array using heap sort.

  Args:
    arr: The input array.
  """
  n = len(arr)

  # Build a maxheap.
  for i in range(n // 2 - 1, -1, -1):
    heapify(arr, n, i)

  # One by one extract elements
  for i in range(n - 1, 0, -1):
    arr[i], arr[0] = arr[0], arr[i]  # swap
    heapify(arr, i, 0)

# Example usage:
arr = [12, 11, 13, 5, 6, 7]
heap_sort(arr)
n = len(arr)
print("Sorted array is")
for i in range(n):
  print("%d" % arr[i], end=' ')