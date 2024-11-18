#include <stdio.h>
#include <stdlib.h>

/* Displays the array, passed to this method */
void display(int arr[], int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }

    printf("\n");
}

/* Swap function to swap two values */
void swap(int *first, int *second)
{
    int temp = *first;
    *first = *second;
    *second = temp;
}

/* Partition method which selects a pivot
  and places each element which is less than the pivot value to its left
  and the elements greater than the pivot value to its right
  arr[] --- array to be partitioned
  lower --- lower index
  upper --- upper index
*/
int partition(int arr[], int lower, int upper)
{
    int i = (lower - 1);

    int pivot = arr[upper];  // Selects last element as the pivot value

    int j;
    for (j = lower; j < upper; j++)
    {
        if (arr[j] <= pivot)
        {  // if current element is smaller than the pivot

            i++;  // increment the index of smaller element
            swap(&arr[i], &arr[j]);
        }
    }

    swap(&arr[i + 1], &arr[upper]);  // places the last element i.e, the pivot
                                     // to its correct position

    return (i + 1);
}

/* This is where the sorting of the array takes place
    arr[] --- Array to be sorted
    lower --- Starting index
    upper --- Ending index
*/
void quickSort(int arr[], int lower, int upper)
{
    if (upper > lower)
    {
        // partitioning index is returned by the partition method , partition
        // element is at its correct position

        int partitionIndex = partition(arr, lower, upper);

        // Sorting elements before and after the partition index
        quickSort(arr, lower, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, upper);
    }
}

int main()
{
    int n = 1000;  // Fixed array size of 1000

    // Allocate memory for 1000 integers
    int *arr = (int *)malloc(sizeof(int) * n);

    // Seed the random number generator
    srand(time(NULL));

    // Generate 1000 random values and store them in the array
    for (int i = 0; i < n; i++)
    {
        arr[i] = rand() % 1000;  // Random number between 0 and 999
    }

    // Sort the array using quickSort
    quickSort(arr, 0, n - 1);

    // Free allocated memory
    free(arr);

    return 0;
}
