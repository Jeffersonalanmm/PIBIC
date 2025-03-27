def binary_search(sorted_list, target):
    """
    Searches for a target value in a sorted list using the binary search algorithm.

    Args:
        sorted_list (list): A sorted list of elements.
        target: The target value to search for.

    Returns:
        int: The index of the target if found, otherwise -1.
    """
    low = 0
    high = len(sorted_list) - 1

    while low <= high:
        mid = (low + high) // 2
        mid_value = sorted_list[mid]

        if mid_value == target:
            return mid
        elif mid_value < target:
            low = mid + 1
        else:
            high = mid - 1

    return -1


import random

def main():
    # Generate a sorted list of 1000 integers
    sorted_list = sorted([random.randint(1, 1000) for _ in range(1000)])

    # Perform binary search for a random target
    target = random.choice(sorted_list)
    binary_search(sorted_list, target)

if __name__ == "__main__":
    main()
