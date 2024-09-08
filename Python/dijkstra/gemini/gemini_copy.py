import heapq

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