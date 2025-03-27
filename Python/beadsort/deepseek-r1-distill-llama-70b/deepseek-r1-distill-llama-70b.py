def bead_sort(numbers):
    if not numbers:
        return []
    
    max_num = max(numbers)
    max_digits = len(str(max_num))
    
    # Initialize a list to hold the counts for each digit position
    digit_counts = []
    
    for pos in range(max_digits):
        counts = [0] * 10
        for num in numbers:
            digit = (num // (10 ** pos)) % 10
            counts[digit] += 1
        digit_counts.append(counts)
    
    # Reconstruct the sorted numbers
    sorted_numbers = [0] * len(numbers)
    for i in range(len(numbers)):
        num = 0
        for pos in range(max_digits):
            # Find the smallest digit that has not been used yet
            for digit in range(10):
                if digit_counts[pos][digit] > 0:
                    digit_counts[pos][digit] -= 1
                    num += digit * (10 ** (max_digits - 1 - pos))
                    break
        sorted_numbers[i] = num
    
    return sorted_numbers

import random
def main():
    # Generate a list of 1000 random integers
    numbers = [random.randint(1, 1000) for _ in range(1000)]
    
    # Perform bead sort
    sorted_numbers = bead_sort(numbers)

if __name__ == "__main__":
    main()