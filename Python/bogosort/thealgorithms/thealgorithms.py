"""
This is a pure Python implementation of the bogosort algorithm,
also known as permutation sort, stupid sort, slowsort, shotgun sort, or monkey sort.
Bogosort generates random permutations until it guesses the correct one.

More info on: https://en.wikipedia.org/wiki/Bogosort
"""

import random


def bogo_sort(collection):
    """Pure implementation of the bogosort algorithm in Python
    :param collection: some mutable ordered collection with heterogeneous
    comparable items inside
    :return: the same collection ordered by ascending
    """

    def is_sorted(collection):
        for i in range(len(collection) - 1):
            if collection[i] > collection[i + 1]:
                return False
        return True

    while not is_sorted(collection):
        random.shuffle(collection)
    return collection


if __name__ == "__main__":
    unsorted = [random.randint(0, 10000) for _ in range(1000)]
    bogo_sort(unsorted)
