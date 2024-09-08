import random

def bubble_sort(arr):
    n = len(arr)
    
    # Traverse through all array elements
    for i in range(n):
        
        # Last i elements are already in place
        for j in range(0, n-i-1):
            
            # Traverse the array from 0 to n-i-1
            # Swap if the element found is greater
            # than the next element
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

def main():
    num_iterations = 1000
    array_size = 1000  # Define the size of the array to sort

    for _ in range(num_iterations):
        # Generate a random array of integers
        arr = [random.randint(1, 1000) for _ in range(array_size)]
        # Sort the array
        bubble_sort(arr)

if __name__ == "__main__":
    main()
