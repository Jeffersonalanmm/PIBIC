def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
            
    return -1  # Target not found

def main():
    # Create a sorted list of 1000 values
    arr = list(range(1000))  # Sorted list from 0 to 999
    target = 500  # Example target to search for
    
    result = binary_search(arr, target)
    # You can use the result variable as needed
    # For example, you can check if the target was found:
    if result != -1:
        pass  # Target found at index result
    else:
        pass  # Target not found

if __name__ == "__main__":
    main()