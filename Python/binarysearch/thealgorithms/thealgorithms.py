#!/usr/bin/env python3

from __future__ import annotations
import bisect
import random


def bisect_left(sorted_collection: list[int], item: int, lo: int = 0, hi: int = -1) -> int:
    if hi < 0:
        hi = len(sorted_collection)
    while lo < hi:
        mid = lo + (hi - lo) // 2
        if sorted_collection[mid] < item:
            lo = mid + 1
        else:
            hi = mid
    return lo


def bisect_right(sorted_collection: list[int], item: int, lo: int = 0, hi: int = -1) -> int:
    if hi < 0:
        hi = len(sorted_collection)
    while lo < hi:
        mid = lo + (hi - lo) // 2
        if sorted_collection[mid] <= item:
            lo = mid + 1
        else:
            hi = mid
    return lo


def binary_search(sorted_collection: list[int], item: int) -> int:
    if list(sorted_collection) != sorted(sorted_collection):
        raise
    left = 0
    right = len(sorted_collection) - 1
    while left <= right:
        midpoint = left + (right - left) // 2
        current_item = sorted_collection[midpoint]
        if current_item == item:
            return midpoint
        elif item < current_item:
            right = midpoint - 1
        else:
            left = midpoint + 1
    return -1


if __name__ == "__main__":
    collection = sorted(random.randint(0, 10000) for _ in range(1000))
    target = random.randint(0, 10000)
    result = binary_search(sorted_collection=collection, item=target)
