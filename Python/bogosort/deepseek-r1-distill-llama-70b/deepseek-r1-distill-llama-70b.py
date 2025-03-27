import random

def is_sorted(data):
    """Check if the list is sorted in ascending order."""
    for i in range(len(data) - 1):
        if data[i] > data[i + 1]:
            return False
    return True

def bogo_sort(data):
    """
    Sorts the data using the Bogo Sort algorithm.
    
    Args:
        data (list): The list to be sorted.
    
    Returns:
        tuple: A tuple containing the sorted list and the number of attempts made.
    """
    data_copy = data.copy()
    attempts = 0
    
    while not is_sorted(data_copy):
        random.shuffle(data_copy)
        attempts += 1
    
    return data_copy, attempts

import random

def main():
    data = [random.randint(1, 1000) for _ in range(10)]
    bogo_sort(data)

if __name__ == "__main__":
    main()
