import random
from typing import List

def bead_sort(arr: List[int]) -> List[int]:
    if not arr:
        return arr
    
    # Find the maximum value
    max_val = max(arr)
    
    # Create a temporary list for counting
    temp = [0] * len(arr)
    
    # For each value from 1 to max_val
    for i in range(1, max_val + 1):
        # Count beads for each position
        for j in range(len(arr)):
            if arr[j] >= i:
                temp[j] += 1
    
    # Reconstruct the sorted array
    result = []
    for i in range(len(arr)):
        result.append(temp[i])
    
    return result

def main():
    # Generate 1000 random integers between 1 and 10000
    test_array = [random.randint(1, 10000) for _ in range(1000)]
    
    # Sort the array using bead sort
    sorted_array = bead_sort(test_array)
    
    # Verify the sort worked correctly using Python's built-in sorted()
    assert sorted_array == sorted(test_array)

if __name__ == "__main__":
    main()
