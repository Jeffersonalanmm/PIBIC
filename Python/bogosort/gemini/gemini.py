import random

def is_sorted(arr):
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True

def bogo_sort(arr):
    while not is_sorted(arr):
        random.shuffle(arr)

if __name__ == "__main__":
    arr = [random.randint(1, 1000) for _ in range(1000)]
    bogo_sort(arr)