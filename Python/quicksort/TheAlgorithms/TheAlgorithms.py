"""
A pure Python implementation of the quick sort algorithm

For doctests run following command:
python3 -OO -m doctest -v quick_sort.py

For manual testing run:
python3 -OO quick_sort.py
"""

from __future__ import annotations

from random import randrange, randint


def quick_sort(collection: list) -> list:
    """A pure Python implementation of quicksort algorithm.

    :param collection: a mutable collection of comparable items
    :return: the same collection ordered in ascending order

    Examples:
    >>> quick_sort([0, 5, 3, 2, 2])
    [0, 2, 2, 3, 5]
    >>> quick_sort([])
    []
    >>> quick_sort([-2, 5, 0, -45])
    [-45, -2, 0, 5]
    """
    # Base case: if the collection has 0 or 1 elements, it is already sorted
    if len(collection) < 2:
        return collection

    # Randomly select a pivot index and remove the pivot element from the collection
    pivot_index = randrange(len(collection))
    pivot = collection.pop(pivot_index)

    # Partition the remaining elements into two groups: lesser or equal, and greater
    lesser = [item for item in collection if item <= pivot]
    greater = [item for item in collection if item > pivot]

    # Recursively sort the lesser and greater groups, and combine with the pivot
    return [*quick_sort(lesser), pivot, *quick_sort(greater)]

def main():
    # Generate 1000 random values
    random_values = [randint(1, 10000) for _ in range(1000)]

    # Sort the generated random values using quick_sort
    sorted_values = quick_sort(random_values)

if __name__ == "__main__":
    main()