import random

# Function to check if the list is sorted
def is_sorted(arr):
    return all(arr[i] <= arr[i + 1] for i in range(len(arr) - 1))

# Bogosort algorithm
def bogosort(arr):
    while not is_sorted(arr):
        random.shuffle(arr)  # Shuffle the list until sorted
    return arr

# Default main function
if __name__ == "__main__":
    # Generate a list of 1000 random values
    arr = [random.randint(1, 1000) for _ in range(1000)]
    
    # Perform bogosort
    bogosort(arr)
