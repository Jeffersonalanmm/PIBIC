import sys
import heapq
import random
def dijkstra(graph, start_node):
    """
    Dijkstra's algorithm implementation.

    Args:
    - graph (dict): A dictionary representing the graph, where each key is a node and its corresponding value is another dictionary.
                    The inner dictionary's keys are the neighboring nodes, and its values are the edge weights.
    - start_node (str): The node to start the search from.

    Returns:
    - distances (dict): A dictionary containing the shortest distances from the start node to all other nodes.
    - previous_nodes (dict): A dictionary containing the previous node in the shortest path from the start node to each node.
    """

    # Initialize distances and previous nodes dictionaries
    distances = {node: sys.maxsize for node in graph}
    distances[start_node] = 0
    previous_nodes = {node: None for node in graph}

    # Create a priority queue
    priority_queue = [(0, start_node)]

    while priority_queue:
        # Extract the node with the minimum distance from the priority queue
        current_distance, current_node = heapq.heappop(priority_queue)

        # If the current distance is greater than the already known distance, skip this node
        if current_distance > distances[current_node]:
            continue

        # Iterate over the neighbors of the current node
        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            # If a shorter path to the neighbor is found, update the distance and previous node
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                previous_nodes[neighbor] = current_node
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances, previous_nodes


def reconstruct_path(previous_nodes, start_node, end_node):
    """
    Reconstruct the shortest path from the start node to the end node.

    Args:
    - previous_nodes (dict): A dictionary containing the previous node in the shortest path from the start node to each node.
    - start_node (str): The node to start the search from.
    - end_node (str): The node to end the search at.

    Returns:
    - path (list): A list of nodes representing the shortest path from the start node to the end node.
    """

    path = []
    current_node = end_node

    while current_node is not None:
        path.append(current_node)
        current_node = previous_nodes[current_node]

    # Reverse the path to get it in the correct order
    path.reverse()

    return path


def generate_random_graph(num_nodes):
    graph = {str(i): {} for i in range(num_nodes)}
    for i in range(num_nodes):
        for j in range(i + 1, num_nodes):
            weight = random.randint(1, 100)
            graph[str(i)][str(j)] = weight
            graph[str(j)][str(i)] = weight
    return graph

def main():
    num_nodes = 1000
    graph = generate_random_graph(num_nodes)
    start_node = '0'
    dijkstra(graph, start_node)

if __name__ == "__main__":
    main()