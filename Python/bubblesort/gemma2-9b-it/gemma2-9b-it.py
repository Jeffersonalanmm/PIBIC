def bubble_sort(arr):
  """
  Sorts a list using the Bubble Sort algorithm.

  Args:
    arr: A list of comparable elements.

  Returns:
    The sorted list.
  """

  n = len(arr)
  for i in range(n):
    # Flag to optimize - if no swaps occur, the list is already sorted
    swapped = False 
    for j in range(0, n-i-1):
      # Compare adjacent elements and swap if out of order
      if arr[j] > arr[j+1]:
        arr[j], arr[j+1] = arr[j+1], arr[j]
        swapped = True
    # If no swaps occurred in a pass, the list is sorted
    if not swapped:
      break
  return arr

import random

def main():
    arr = [random.randint(1, 1000) for _ in range(1000)]
    bubble_sort(arr)

if __name__ == "__main__":
    main()
