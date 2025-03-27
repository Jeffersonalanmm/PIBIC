import heapq

def dijkstra(graph, start):
    """
    Computes the shortest distances from a starting node to all other nodes in a graph.

    Args:
        graph: A dictionary representing the graph where keys are nodes and values are dictionaries of neighbors with associated edge weights.
        start: The starting node for the shortest path calculation.

    Returns:
        A dictionary containing the shortest distances from the start node to all other nodes.
    """

    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    visited = set()
    priority_queue = [(0, start)]  # (distance, node)

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        if current_node in visited:
            continue

        visited.add(current_node)

        for neighbor, weight in graph[current_node].items():
            new_distance = current_distance + weight
            if new_distance < distances[neighbor]:
                distances[neighbor] = new_distance
                heapq.heappush(priority_queue, (new_distance, neighbor))

    return distances

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