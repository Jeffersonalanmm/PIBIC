import random

def is_sorted(arr):
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True

def bogo_sort(arr):
    while not is_sorted(arr):
        random.shuffle(arr)
    return arr

def main():
    arr = [random.randint(0, 1000) for _ in range(1000)]
    sorted_arr = bogo_sort(arr)
    return sorted_arr

if __name__ == "__main__":
    main()