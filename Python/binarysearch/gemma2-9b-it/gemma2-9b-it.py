def binary_search(array, target):
  """
  Performs a binary search on a sorted array.

  Args:
    array: A sorted list of elements.
    target: The element to search for.

  Returns:
    The index of the target element if found, otherwise -1.
  """

  left = 0
  right = len(array) - 1

  while left <= right:
    mid = (left + right) // 2  # Calculate middle index

    if array[mid] == target:
      return mid  # Target found at middle index
    elif array[mid] < target:
      left = mid + 1  # Search in the right half
    else:
      right = mid - 1  # Search in the left half

  return -1  # Target not found in the array


import random

def main():
    # Generate a sorted list of 1000 integers
    sorted_list = sorted([random.randint(1, 1000) for _ in range(1000)])

    # Perform binary search for a random target
    target = random.choice(sorted_list)
    binary_search(sorted_list, target)

if __name__ == "__main__":
    main()
