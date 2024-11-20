from random import randint
def quicksort(arr):
    """
    Sorts an array using the Quicksort algorithm.

    Args:
        arr (list): The input array to be sorted.

    Returns:
        list: The sorted array.
    """
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)

def main():
    # Generate 1000 random values
    random_values = [randint(1, 10000) for _ in range(1000)]

    # Sort the generated random values using quicksort
    sorted_values = quicksort(random_values)

if __name__ == "__main__":
    main()