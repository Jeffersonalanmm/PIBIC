import heapq

def dijkstra(graph, start):
    """
    Dijkstra's algorithm to find the shortest paths from the start node to all other nodes.

    Args:
        graph (dict): An adjacency list representation of the graph.
        start (any): The node from which to start the search.

    Returns:
        tuple: A tuple containing two dictionaries. The first dictionary contains the shortest distances from the start node to each node. The second dictionary maps each node to its predecessor in the shortest path.

    Raises:
        ValueError: If the start node is not present in the graph.
    """
    if start not in graph:
        raise ValueError("Start node not in graph")

    # Initialize distances to infinity and previous nodes to None
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0
    previous = {node: None for node in graph}

    # Priority queue is a heap of (distance, node)
    priority_queue = []
    heapq.heappush(priority_queue, (0, start))

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        # If the current distance is greater than the known distance, skip
        if current_distance > distances[current_node]:
            continue

        # Visit all neighbors
        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            # If a shorter path is found, update distances and previous node
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                previous[neighbor] = current_node
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances, previous

import random

def generate_graph(n):
    graph = {str(i): {} for i in range(n)}
    for i in range(n):
        for j in range(i + 1, n):
            weight = random.randint(1, 100)
            graph[str(i)][str(j)] = weight
            graph[str(j)][str(i)] = weight
    return graph

def main():
    graph = generate_graph(1000)
    start_node = '0'
    dijkstra(graph, start_node)

if __name__ == "__main__":
    main()