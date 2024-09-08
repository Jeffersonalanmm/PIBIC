def bubble_sort(arr):
    """
    Sorts an array in ascending order using the Bubblesort algorithm.

    Args:
        arr (list): The input array to be sorted.

    Returns:
        list: The sorted array.
    """
    n = len(arr)

    for i in range(n-1):
        # Create a flag that will allow the function to terminate early if there's nothing left to sort
        swapped = False

        # Start looking at each item of the list one by one, comparing it with its adjacent value
        for j in range(n-i-1):
            # If we find an element that is greater than its adjacent element, then swap them
            if arr[j] > arr[j+1]:
                # Swap values
                arr[j], arr[j+1] = arr[j+1], arr[j]
                # Set the flag to True so we'll loop again
                swapped = True

        # If no two elements were swapped in the last iteration, the list is sorted
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