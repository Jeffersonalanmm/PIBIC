////////////////////////////////////////////////////////////////////////////////
// INCLUDES
#include <stdio.h>
#include <stdlib.h>

////////////////////////////////////////////////////////////////////////////////
// DATA STRUCTURES
/**
 * Defining the structure of the node which contains 'data' (type : integer),
 * two pointers 'next' and 'pre' (type : struct node).
 */
struct node {
    int data;          // Data to store (integer)
    struct node *next; // Pointer to the next node in the list
    struct node *pre;  // Pointer to the previous node in the list
} *head, *tail, *tmp;

////////////////////////////////////////////////////////////////////////////////
// GLOBAL VARIABLES
int count = 0; // Keeps track of the number of elements in the queue

////////////////////////////////////////////////////////////////////////////////
// FUNCTION DECLARATIONS

void create();        // Initializes the queue (empty list)
void enque(int x);    // Adds an element to the queue
int deque();          // Removes and returns an element from the queue
int peek();           // Returns the front element without removing it
int size();           // Returns the number of elements in the queue
int isEmpty();        // Checks if the queue is empty

////////////////////////////////////////////////////////////////////////////////
// FUNCTION DEFINITIONS

/**
 * Initializes the queue (empty list).
 */
void create()
{
    head = NULL;
    tail = NULL;
    count = 0;
}

/**
 * Adds an element to the queue (enqueue).
 * @param x The element to add.
 */
void enque(int x)
{
    struct node* tmp = (struct node*)malloc(sizeof(struct node)); // Create a new node
    tmp->data = x;  // Set the data of the new node
    tmp->next = NULL;  // This will be the last node, so next is NULL
    tmp->pre = tail;   // Set the previous pointer to the tail

    if (tail != NULL) {
        tail->next = tmp;  // If the queue is not empty, link the current tail to the new node
    }
    tail = tmp;  // Move the tail pointer to the new node

    if (head == NULL) {
        head = tmp;  // If the queue was empty, the head also points to the new node
    }
    count++;  // Increment the count of elements in the queue
}

/**
 * Removes and returns the front element from the queue (dequeue).
 * @return The element removed from the front of the queue.
 */
int deque()
{
    if (head == NULL) {
        exit(1);  // Exit the program if trying to dequeue from an empty queue
    }

    int returnData = head->data;  // Get the data from the front node
    struct node* tmp = head;  // Temporarily store the head

    head = head->next;  // Move the head to the next node
    if (head == NULL) {
        tail = NULL;  // If the queue becomes empty, the tail must also be NULL
    } else {
        head->pre = NULL;  // Set the previous pointer of the new head to NULL
    }

    free(tmp);  // Free the memory of the old head node
    count--;  // Decrease the count of elements in the queue
    return returnData;  // Return the data of the removed node
}

/**
 * Returns the front element without removing it (peek).
 * @return The front element of the queue.
 */
int peek()
{
    if (head == NULL) {
        exit(1);  // Exit if the queue is empty
    }
    return head->data;  // Return the data of the front element
}

/**
 * Returns the number of elements in the queue.
 * @return The size of the queue.
 */
int size()
{
    return count;  // Simply return the count variable
}

/**
 * Checks if the queue is empty.
 * @return 1 if the queue is empty, 0 otherwise.
 */
int isEmpty()
{
    return (head == NULL);  // The queue is empty if the head is NULL
}

////////////////////////////////////////////////////////////////////////////////
// MAIN ENTRY POINT

int main(int argc, char const *argv[])
{
    create();  // Initialize the queue

    // Seed the random number generator
    srand(time(NULL));

    // Generate and enqueue 1000 random values
    for (int i = 0; i < 1000; i++) {
        int random_value = rand() % 1000;  // Generate a random number between 0 and 999
        enque(random_value);  // Add the value to the queue
    }
}