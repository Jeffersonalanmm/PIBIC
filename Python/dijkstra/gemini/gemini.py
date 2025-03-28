import heapq
import random

def dijkstra(graph, start):
    """
    Implements Dijkstra's algorithm to find the shortest paths from a given start node to all other nodes in a graph.

    Args:
        graph: A dictionary representing the graph, where keys are nodes and values are dictionaries of neighboring nodes and their corresponding weights.
        start: The starting node for the algorithm.

    Returns:
        A dictionary containing the shortest distances from the start node to all other nodes.
    """

    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    priority_queue = [(0, start)]
    visited = set()

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        if current_node in visited:
            continue

        visited.add(current_node)

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances

if __name__ == "__main__":
    # Generate a random graph with 1000 nodes
    num_nodes = 1000
    nodes = [f"Node_{i}" for i in range(num_nodes)]
    graph = {node: {} for node in nodes}

    # Add random edges with weights
    for node in nodes:
        num_edges = random.randint(1, 10)  # Each node has 1 to 10 neighbors
        neighbors = random.sample(nodes, num_edges)
        for neighbor in neighbors:
            if neighbor != node:
                graph[node][neighbor] = random.randint(1, 100)  # Random weight between 1 and 100

    # Select a random start node
    start_node = random.choice(nodes)
    # Run Dijkstra's algorithm
    dijkstra(graph, start_node)
