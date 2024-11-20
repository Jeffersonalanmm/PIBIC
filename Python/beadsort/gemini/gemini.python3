def bead_sort(array):
    """
    Implements the Bead Sort algorithm.

    Args:
        array: The input array to be sorted.

    Returns:
        The sorted array.
    """

    max_value = max(array)
    rows = [[0] * max_value for _ in range(len(array))]

    # Fill the rows with beads
    for i, num in enumerate(array):
        for j in range(num):
            rows[i][j] = 1

    # Count beads in each column
    for j in range(max_value):
        bead_count = 0
        for i in range(len(array)):
            bead_count += rows[i][j]
        for i in range(len(array) - 1, -1, -1):
            if bead_count > 0:
                rows[i][j] = 1
                bead_count -= 1
            else:
                rows[i][j] = 0

    # Extract the sorted values from the rows
    sorted_array = [sum(row) for row in rows]

    return sorted_array

if __name__ == "__main__":
    import random
    array = [random.randint(1, 1000) for _ in range(1000)]
    sorted_array = bead_sort(array)
    # You can uncomment the following line to print the sorted array
    # print(sorted_array)