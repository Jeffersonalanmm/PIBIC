from random import randint

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

def main():
    # Generate 1000 random values
    random_values = [randint(1, 10000) for _ in range(1000)]

    # Sort the generated random values using quicksort
    sorted_values = quicksort(random_values)

if __name__ == "__main__":
    main()
