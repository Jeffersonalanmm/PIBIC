#!/bin/python3
from itertools import zip_longest
import random

# Função beadsort
def beadsort(l):
    return list(map(sum, zip_longest(*[[1] * e for e in l], fillvalue=0)))

# Main
if __name__ == "__main__":
    sequence = [random.randint(0, 10000) for _ in range(1000)]
    sorted_sequence = beadsort(sequence)