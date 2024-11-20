def bead_sort(arr):
    n = len(arr)
    max_val = max(arr)
    beads = [0] * (max_val + 1)
    ans = [0] * n

    for i in range(n):
        for j in range(arr[i]):
            beads[j] += 1

    for i in range(max_val + 1):
        prev = 0
        for j in range(n):
            curr = beads[i]
            beads[i] = prev
            prev = curr
        for j in range(n):
            ans[beads[arr[j]] - 1] = arr[j]
            beads[arr[j]] -= 1

    return ans

import random

def main():
    arr = [random.randint(0, 10000) for _ in range(1000)]
    sorted_arr = bead_sort(arr)
    print(sorted_arr)

if __name__ == "__main__":
    main()