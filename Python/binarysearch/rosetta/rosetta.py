def binary_search(l, value):
    low = 0
    high = len(l)-1
    while low <= high: 
        mid = (low+high)//2
        if l[mid] > value: high = mid-1
        elif l[mid] < value: low = mid+1
        else: return mid
    return -1

if __name__ == "__main__":
    sequence = [random.randint(0, 10000) for _ in range(1000)]
    sorted_sequence = binary_search(sequence)
