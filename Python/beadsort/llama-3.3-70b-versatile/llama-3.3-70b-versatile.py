def bead_sort(b):
    """
    Sorts a list of integers using the Bead Sort algorithm.

    Args:
        b (list): A list of integers to be sorted.

    Returns:
        list: A sorted list of integers.
    """
    # Create a list to store the beads
    beads = [0] * max(b)

    # Drop the beads
    for num in b:
        for i in range(num):
            beads[i] += 1

    # Read the beads
    sorted_b = []
    for i, count in enumerate(beads):
        sorted_b.extend([i + 1] * count)

    return sorted_b


import random
def main():
    # Generate a list of 1000 random integers
    numbers = [random.randint(1, 1000) for _ in range(1000)]
    
    # Perform bead sort
    sorted_numbers = bead_sort(numbers)

if __name__ == "__main__":
    main()