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

# Example usage
array = [38, 27, 43, 3, 9, 82, 10]
sorted_array = merge_sort(array)
print("Sorted array:", sorted_array)
