import random

def bead_sort(arr):
    # Find the maximum value to set the size of the beads array
    max_value = max(arr)
    
    # Create a list to hold the beads for each number in the input array
    beads = [[0] * num for num in arr]
    
    # Drop the beads down (simulate gravity)
    for i in range(len(arr)):
        for j in range(arr[i]):
            beads[i][j] = 1
    
    # Sum the beads in each column to get the sorted values
    for j in range(max_value):
        column_sum = sum(beads[i][j] for i in range(len(arr)))
        for i in range(len(arr)):
            beads[i][j] = 1 if i < column_sum else 0
    
    # Reconstruct the sorted array based on the bead positions
    return [sum(row) for row in beads]

def main():
    # Generate a list of 1000 random values between 1 and 100
    arr = [random.randint(1, 100) for _ in range(1000)]
    
    # Sort the array using bead sort
    sorted_arr = bead_sort(arr)
    
    return sorted_arr

if __name__ == "__main__":
    sorted_array = main()
