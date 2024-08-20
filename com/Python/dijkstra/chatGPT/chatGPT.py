import heapq

def dijkstra(graph, start):
    # Priority queue to hold (cost, node)
    pq = [(0, start)]
    # Dictionary to hold the shortest path to each node
    shortest_paths = {start: (None, 0)}
    visited = set()

    while pq:
        current_cost, current_node = heapq.heappop(pq)

        if current_node in visited:
            continue

        visited.add(current_node)

        for neighbor, weight in graph[current_node].items():
            cost = current_cost + weight

            if neighbor not in shortest_paths or cost < shortest_paths[neighbor][1]:
                shortest_paths[neighbor] = (current_node, cost)
                heapq.heappush(pq, (cost, neighbor))

    return shortest_paths

# Example usage
if __name__ == "__main__":
    # The graph is represented as a dictionary of dictionaries
    graph = {
        'A': {'B': 1, 'C': 4},
        'B': {'A': 1, 'C': 2, 'D': 5},
        'C': {'A': 4, 'B': 2, 'D': 1},
        'D': {'B': 5, 'C': 1}
    }
    start_node = 'A'
    shortest_paths = dijkstra(graph, start_node)

    for node in shortest_paths:
        path = []
        while node is not None:
            path.append(node)
            node = shortest_paths[node][0]
        print(f"Path to {path[-1]}: {' -> '.join(reversed(path))} with total cost {shortest_paths[path[-1]][1]}")
