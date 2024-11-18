import random

def bead_sort(arr):
    max_value = max(arr)
    # Create a list of lists (beads)
    beads = [[0] * len(arr) for _ in range(max_value)]

    # Place beads
    for i in range(len(arr)):
        for j in range(arr[i]):
            beads[j][i] = 1

    # Sum the beads column-wise
    for j in range(len(arr)):
        count = sum(beads[i][j] for i in range(max_value))
        for i in range(count):
            beads[max_value - 1 - i][j] = 1
        for i in range(count, max_value):
            beads[i][j] = 0

    # Read the sorted values back into the array
    for i in range(len(arr)):
        arr[i] = sum(beads[j][i] for j in range(max_value))

def main():
    # Generate 1000 random integers between 0 and 100
    arr = [random.randint(0, 100) for _ in range(1000)]
    
    bead_sort(arr)

if __name__ == "__main__":
    main()