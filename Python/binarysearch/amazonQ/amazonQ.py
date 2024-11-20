from typing import List, Optional
import random

def binary_search_iterative(arr: List[int], target: int) -> Optional[int]:
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
            
    return None

def binary_search_recursive(arr: List[int], target: int, left: int, right: int) -> Optional[int]:
    if left > right:
        return None
        
    mid = left + (right - left) // 2
    
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search_recursive(arr, target, mid + 1, right)
    else:
        return binary_search_recursive(arr, target, left, mid - 1)

def verify_binary_search(arr: List[int], search_func) -> bool:
    # Test for existing values
    for _ in range(100):
        random_index = random.randrange(len(arr))
        target = arr[random_index]
        result = search_func(arr, target)
        if result is None or arr[result] != target:
            return False
    
    # Test for non-existing values
    non_existing = max(arr) + 1
    if search_func(arr, non_existing) is not None:
        return False
        
    return True

def main():
    # Generate 1000 unique random integers
    test_array = random.sample(range(1, 10001), 1000)
    
    # Binary search requires sorted array
    test_array.sort()
    
    # Verify both implementations
    assert verify_binary_search(test_array, binary_search_iterative), "Iterative binary search failed verification"
    assert verify_binary_search(
        test_array,
        lambda arr, target: binary_search_recursive(arr, target, 0, len(arr) - 1)
    ), "Recursive binary search failed verification"
    
    # Additional verification using random targets
    for _ in range(100):
        target = random.randint(1, 10001)
        iterative_result = binary_search_iterative(test_array, target)
        
        # Verify both implementations return the same result
        assert iterative_result == recursive_result, "Implementation mismatch"
        
        # If target was found, verify it's correct
        if iterative_result is not None:
            assert test_array[iterative_result] == target, "Incorrect search result"

if __name__ == "__main__":
    main()
