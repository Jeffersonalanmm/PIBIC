def bubble_sort(seq):
    """Inefficiently sort the mutable sequence (list) in place.
       seq MUST BE A MUTABLE SEQUENCE.

       As with list.sort() and random.shuffle this does NOT return 
    """
    changed = True
    while changed:
        changed = False
        for i in range(len(seq) - 1):
            if seq[i] > seq[i+1]:
                seq[i], seq[i+1] = seq[i+1], seq[i]
                changed = True
    return seq

if __name__ == "__main__":
   """Sample usage and simple test suite"""

   from random import shuffle

   testset = [_ for _ in range(100)]
   testcase = testset.copy() # make a copy
   shuffle(testcase)
   assert testcase != testset  # we've shuffled it
   bubble_sort(testcase)
   assert testcase == testset  # we've unshuffled it back into a copy

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