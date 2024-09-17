import random
from heapq import merge

def merge_sort(m):
    """Sorts an array using the mergesort algorithm.

    Args:
        m: The array to be sorted.

    Returns:
        The sorted array.
    """
    if len(m) <= 1:
        return m

    middle = len(m) // 2
    left = m[:middle]
    right = m[middle:]

    left = merge_sort(left)
    right = merge_sort(right)
    return list(merge(left, right))

if __name__ == "__main__":
    # Generate 1000 random values
    random_list = [random.randint(0, 1000) for _ in range(1000)]
    
    # Sort the list using merge sort
    sorted_list = merge_sort(random_list)
