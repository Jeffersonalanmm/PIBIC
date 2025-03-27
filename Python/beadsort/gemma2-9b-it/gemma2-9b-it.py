def bead_sort(arr):
    """
    Sorts a list of integers using the Bead Sort algorithm.

    Args:
        arr: A list of integers to be sorted.

    Returns:
        The sorted list.
    """

    max_val = max(arr)
    num_beads = max_val + 1
    beads = [0] * num_beads

    # Count the occurrences of each element
    for num in arr:
        beads[num] += 1

    # Calculate the cumulative count
    for i in range(1, num_beads):
        beads[i] += beads[i - 1]

    # Place elements in sorted order
    sorted_arr = [0] * len(arr)
    for num in arr:
        index = beads[num] - 1
        sorted_arr[index] = num
        beads[num] -= 1

    return sorted_arr

import random
def main():
    # Generate a list of 1000 random integers
    numbers = [random.randint(1, 1000) for _ in range(1000)]
    
    # Perform bead sort
    sorted_numbers = bead_sort(numbers)

if __name__ == "__main__":
    main()