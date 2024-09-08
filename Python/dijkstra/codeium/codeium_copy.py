import heapq

def dijkstra(graph, start_node):
    """
    Dijkstra's Algorithm to find the shortest path from start_node to all other nodes in the graph.

    Args:
        graph (dict): Adjacency list representation of the graph, where each key is a node and its value is a dictionary of neighboring nodes with their edge weights.
        start_node (str): The node to start the search from.

    Returns:
        distances (dict): A dictionary of the shortest distances from start_node to all other nodes.
        previous_nodes (dict): A dictionary of the previous node in the shortest path from start_node to all other nodes.
    """

    # Initialize distances and previous nodes dictionaries
    distances = {node: float('infinity') for node in graph}
    distances[start_node] = 0
    previous_nodes = {node: None for node in graph}

    # Create a priority queue to hold nodes to be processed
    priority_queue = [(0, start_node)]

    while priority_queue:
        # Extract the node with the minimum distance from the priority queue
        current_distance, current_node = heapq.heappop(priority_queue)

        # If the current distance is greater than the already known distance, skip this node
        if current_distance > distances[current_node]:
            continue

        # Iterate over the neighbors of the current node
        for neighbor, weight in graph[current_node].items():
            # Calculate the distance to the neighbor through the current node
            distance = current_distance + weight

            # If this distance is less than the already known distance, update the distances and previous nodes dictionaries
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                previous_nodes[neighbor] = current_node
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances, previous_nodes

# Example usage:
graph = {
    'A': {'B': 1, 'C': 4},
    'B': {'A': 1, 'C': 2, 'D': 5},
    'C': {'A': 4, 'B': 2, 'D': 1},
    'D': {'B': 5, 'C': 1}
}

start_node = 'A'

distances, previous_nodes = dijkstra(graph, start_node)

print("Shortest distances:")
for node, distance in distances.items():
    print(f"{start_node} -> {node}: {distance}")

print("\nPrevious nodes:")
for node, previous_node in previous_nodes.items():
    print(f"{node}: {previous_node}")