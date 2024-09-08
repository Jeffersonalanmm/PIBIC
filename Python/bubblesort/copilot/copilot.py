def bubble_sort(arr):
    n = len(arr)
    for i in range(n-1):
        for j in range(n-i-1):
            if arr[j] > arr[j+1]:
                # Swap arr[j] and arr[j+1]
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

import random

def main():
    num_iterations = 1000
    array_size = 1000  # Tamanho do array a ser ordenado

    for _ in range(num_iterations):
        # Gera um array aleatório com mil valores
        arr = [random.randint(1, 1000) for _ in range(array_size)]
        # Ordena o array
        bubble_sort(arr)

if __name__ == "__main__":
    main()