import random
def merge_sort(arr):
    # Base case: if the array has 1 or fewer elements, it's already sorted
    if len(arr) <= 1:
        return arr
    
    # Divide the array into two halves
    mid = len(arr) // 2
    left_half = arr[:mid]
    right_half = arr[mid:]
    
    # Recursively sort both halves
    left_half = merge_sort(left_half)
    right_half = merge_sort(right_half)
    
    # Merge the sorted halves
    return merge(left_half, right_half)

def merge(left, right):
    result = []
    left_index, right_index = 0, 0
    
    # Compare elements from both lists and add the smaller one to the result
    while left_index < len(left) and right_index < len(right):
        if left[left_index] < right[right_index]:
            result.append(left[left_index])
            left_index += 1
        else:
            result.append(right[right_index])
            right_index += 1
    
    # Add any remaining elements from the left list
    result.extend(left[left_index:])
    
    # Add any remaining elements from the right list
    result.extend(right[right_index:])
    
    return result

if __name__ == "__main__":
    # Generate 1000 random values
    random_list = [random.randint(0, 1000) for _ in range(1000)]
    
    # Sort the list using merge sort
    sorted_list = merge_sort(random_list)