import heapq
import random

def dijkstra(graph, start):
    # Initialize distances with infinity
    distances = {vertex: float('infinity') for vertex in graph}
    distances[start] = 0

    # Priority queue to hold vertices to be processed
    priority_queue = [(0, start)]
    
    while priority_queue:
        current_distance, current_vertex = heapq.heappop(priority_queue)

        # Nodes can only be added once to the priority queue
        if current_distance > distances[current_vertex]:
            continue

        # Check neighbors
        for neighbor, weight in graph[current_vertex].items():
            distance = current_distance + weight

            # Only consider this new path if it's better
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
 