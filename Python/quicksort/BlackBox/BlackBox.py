from random import randint
def quicksort(arr):
    """
    Sorts an array using the quicksort algorithm.

    Args:
        arr (list): The array to be sorted.

    Returns:
        list: The sorted array.
    """
    if len(arr) <= 1:
        # Base case: If the array has one or zero elements, it is already sorted.
        return arr
    else:
        # Select the pivot element (in this case, the middle element).
        pivot = arr[len(arr) // 2]
        
        # Divide the array into three sub-arrays: elements less than the pivot,
        # elements equal to the pivot, and elements greater than the pivot.
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]
        
        # Recursively sort the sub-arrays and combine the results.
        return quicksort(left) + middle + quicksort(right)

def main():
    # Generate 1000 random values
    random_values = [randint(1, 10000) for _ in range(1000)]

    # Sort the generated random values using quicksort
    sorted_values = quicksort(random_values)

if __name__ == "__main__":
    main()