from random import randint
def quick_sort(sequence):
    lesser = []
    equal = []
    greater = []
    if len(sequence) <= 1:
        return sequence
    pivot = sequence[0]
    for element in sequence:
        if element < pivot:
            lesser.append(element)
        elif element > pivot:
            greater.append(element)
        else:
            equal.append(element)
    lesser = quick_sort(lesser)
    greater = quick_sort(greater)
    return lesser + equal + greater


def main():
    # Generate 1000 random values
    random_values = [randint(1, 10000) for _ in range(1000)]

    # Sort the generated random values using quick_sort
    sorted_values = quick_sort(random_values)

if __name__ == "__main__":
    main()