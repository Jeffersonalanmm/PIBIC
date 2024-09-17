import random
def merge_sort(arr):
    # Base case: an array of 0 or 1 element is already sorted
    if len(arr) <= 1:
        return arr

    # Split the array into two halves
    mid = len(arr) // 2
    left_half = arr[:mid]
    right_half = arr[mid:]

    # Recursively sort both halves
    left_sorted = merge_sort(left_half)
    right_sorted = merge_sort(right_half)

    # Merge the sorted halves
    return merge(left_sorted, right_sorted)

def merge(left, right):
    sorted_array = []
    i = j = 0

    # Merge elements from both halves in sorted order
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            sorted_array.append(left[i])
            i += 1
        else:
            sorted_array.append(right[j])
            j += 1

    # Append any remaining elements from the left half
    sorted_array.extend(left[i:])
    # Append any remaining elements from the right half
    sorted_array.extend(right[j:])

    return sorted_array

if __name__ == "__main__":
    # Generate 1000 random values
    random_list = [random.randint(0, 1000) for _ in range(1000)]
    
    # Sort the list using merge sort
    sorted_list = merge_sort(random_list)