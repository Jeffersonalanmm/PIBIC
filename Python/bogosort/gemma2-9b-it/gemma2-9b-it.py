import random

def bogo_sort(arr):
  """
  Sorts a list using the Bogo Sort algorithm.

  Args:
    arr: The list to be sorted.

  Returns:
    The sorted list.
  """

  while not is_sorted(arr):
    random.shuffle(arr)
  return arr

def is_sorted(arr):
  """
  Checks if a list is sorted in ascending order.

  Args:
    arr: The list to be checked.

  Returns:
    True if the list is sorted, False otherwise.
  """
  for i in range(len(arr) - 1):
    if arr[i] > arr[i + 1]:
      return False
  return True

import random

def main():
    unsorted_list = [random.randint(1, 1000) for _ in range(10)]
    bogo_sort(unsorted_list)

if __name__ == "__main__":
    main()
