import heapq

def dijkstra(graph, start):
    """
    Dijkstra's Algorithm: finds the shortest path from `start` to all other nodes in `graph`

    Args:
        graph: a dictionary of adjacency lists, where each key is a node and each value is a list of tuples (neighbor, weight)
        start: the starting node

    Returns:
        A dictionary of shortest distances from `start` to all other nodes, and a dictionary of predecessors
    """
    # Initialize distances and predecessors
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    predecessors = {node: None for node in graph}

    # Priority queue of nodes to visit, with their distances
    queue = [(0, start)]

    while queue:
        # Extract the node with the minimum distance from the queue
        current_distance, current_node = heapq.heappop(queue)

        # If we've already processed this node, skip it
        if current_distance > distances[current_node]:
            continue

        # Visit all neighbors of the current node
        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight

            # If we've found a shorter path to the neighbor, update its distance and predecessor
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                predecessors[neighbor] = current_node
                heapq.heappush(queue, (distance, neighbor))

    return distances, predecessors

# Example usage:
graph = {
    'A': [('B', 2), ('C', 3)],
    'B': [('A', 2), ('D', 4), ('E', 5)],
    'C': [('A', 3), ('F', 1)],
    'D': [('B', 4)],
    'E': [('B', 5), ('F', 2)],
    'F': [('C', 1), ('E', 2)]
}

start_node = 'A'
distances, predecessors = dijkstra(graph, start_node)

print("Shortest distances from", start_node)
for node, distance in distances.items():
    print(f"{node}: {distance}")

print("\nPredecessors:")
for node, predecessor in predecessors.items():
    print(f"{node}: {predecessor}")