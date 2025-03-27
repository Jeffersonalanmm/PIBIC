def bubble_sort(lst):
    n = len(lst)
    for i in range(n):
        swapped = False
        for j in range(0, n - i - 1):
            if lst[j] > lst[j + 1]:
                lst[j], lst[j + 1] = lst[j + 1], lst[j]
                swapped = True
        if not swapped:
            break
    return lst

import random

def main():
    lst = [random.randint(1, 1000) for _ in range(1000)]
    bubble_sort(lst)

if __name__ == "__main__":
    main()
