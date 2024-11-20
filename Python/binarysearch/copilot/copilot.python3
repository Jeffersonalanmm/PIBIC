def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1

def main():
    # Create a sorted list of 1000 values
    arr = list(range(1000))
    target = 500  # Example target value to search for
    binary_search(arr, target)

if __name__ == "__main__":
    main()