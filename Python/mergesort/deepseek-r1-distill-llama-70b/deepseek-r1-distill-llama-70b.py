def merge_sort(arr):
    """
    Sorts an array using the Merge Sort algorithm.
    
    Args:
        arr (list): The list of elements to be sorted.
    
    Returns:
        list: A new list containing all elements of 'arr' in ascending order.
    """
    # Base case: If the array has 1 or 0 elements, it's already sorted.
    if len(arr) <= 1:
        return arr
    
    # Find the middle point and split the array into two halves.
    mid = len(arr) // 2
    left_half = arr[:mid]
    right_half = arr[mid:]
    
    # Recursively sort the left and right halves.
    left = merge_sort(left_half)
    right = merge_sort(right_half)
    
    # Merge the sorted halves and return the result.
    return merge(left, right)


def merge(left, right):
    """
    Merges two sorted lists into one sorted list.
    
    Args:
        left (list): The first sorted list.
        right (list): The second sorted list.
    
    Returns:
        list: A new list containing all elements from 'left' and 'right' in ascending order.
    """
    merged = []
    left_index = 0
    right_index = 0
    
    # Merge smaller elements first.
    while left_index < len(left) and right_index < len(right):
        if left[left_index] <= right[right_index]:
            merged.append(left[left_index])
            left_index += 1
        else:
            merged.append(right[right_index])
            right_index += 1
    
    # If there are remaining elements in either the left or right, append them.
    merged.extend(left[left_index:])
    merged.extend(right[right_index:])
    
    return merged


import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    merge_sort(arr)

if __name__ == "__main__":
    main()
