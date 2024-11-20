def bubble_sort(arr):
  """
  Implements the Bubble Sort algorithm with optimization.

  Args:
    arr: The list to be sorted.

  Returns:
    The sorted list.
  """

  n = len(arr)

  # Traverse through all array elements
  for i in range(n):
    # Last i elements are already in place
    swapped = False
    for j in range(0, n - i - 1):

      # Traverse the array from 0 to n-i-1
      # Swap if the element found is greater
      # than the next element
      if arr[j] > arr[j + 1]:
        arr[j], arr[j + 1] = arr[j + 1], arr[j]
        swapped = True

    # If no two elements were swapped by inner loop, then break
    if not swapped:
      break

  return arr

import random

def main():
    num_iterations = 1000
    array_size = 1000  # Tamanho do array a ser ordenado

    for _ in range(num_iterations):
        # Gera um array aleatório com mil valores
        arr = [random.randint(1, 1000) for _ in range(array_size)]
        # Ordena o array
        bubble_sort(arr)

if __name__ == "__main__":
    main()