import random

def is_sorted(data):
    """
    Checks if the input list is sorted in ascending order.

    Args:
        data (list): The input list to check.

    Returns:
        bool: True if the list is sorted, False otherwise.
    """
    return all(data[i] <= data[i + 1] for i in range(len(data) - 1))

def bogo_sort(data):
    """
    Sorts the input list using the Bogo Sort algorithm.

    Args:
        data (list): The input list to sort.

    Returns:
        list: The sorted list.
    """
    while not is_sorted(data):
        random.shuffle(data)
    return data

import random

def main():
    # Generate a random list of 10 integers
    data = [random.randint(1, 100) for _ in range(10)]

    # Sort the list using Bogo Sort
    bogo_sort(data)

if __name__ == "__main__":
    main()
