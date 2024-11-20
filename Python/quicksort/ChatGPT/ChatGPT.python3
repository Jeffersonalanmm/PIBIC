from random import randint
def quicksort(arr):
    """Sorts an array using the Quicksort algorithm."""
    # Base case: arrays with fewer than two elements are already sorted
    if len(arr) < 2:
        return arr
    
    # Choose the pivot (here we choose the last element)
    pivot = arr[-1]
    
    # Partitioning step
    lesser = [x for x in arr[:-1] if x <= pivot]  # Elements less than or equal to pivot
    greater = [x for x in arr[:-1] if x > pivot]  # Elements greater than pivot
    
    # Recursively apply quicksort to subarrays and combine
    return quicksort(lesser) + [pivot] + quicksort(greater)

def main():
    # Generate 1000 random values
    random_values = [randint(1, 10000) for _ in range(1000)]

    # Sort the generated random values using quicksort
    sorted_values = quicksort(random_values)

if __name__ == "__main__":
    main()