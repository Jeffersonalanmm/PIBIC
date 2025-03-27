import heapq
import random
class Graph:
    def __init__(self):
        """
        Initialize an empty graph.
        """
        self.nodes = set()
        self.edges = {}

    def add_node(self, node):
        """
        Add a node to the graph.

        Args:
            node (str): The node to add.
        """
        self.nodes.add(node)
        if node not in self.edges:
            self.edges[node] = []

    def add_edge(self, from_node, to_node, weight):
        """
        Add an edge to the graph.

        Args:
            from_node (str): The node where the edge starts.
            to_node (str): The node where the edge ends.
            weight (int): The weight of the edge.
        """
        self.edges[from_node].append((to_node, weight))

    def dijkstra(self, start_node):
        """
        Run Dijkstra's algorithm to find the shortest paths from the start node.

        Args:
            start_node (str): The node where the algorithm starts.

        Returns:
            distances (dict): A dictionary with the shortest distances from the start node to all other nodes.
            previous_nodes (dict): A dictionary with the previous node in the shortest path from the start node to all other nodes.
        """
        distances = {node: float('infinity') for node in self.nodes}
        distances[start_node] = 0
        previous_nodes = {node: None for node in self.nodes}

        priority_queue = [(0, start_node)]

        while priority_queue:
            current_distance, current_node = heapq.heappop(priority_queue)

            if current_distance > distances[current_node]:
                continue

            for neighbor, weight in self.edges[current_node]:
                distance = current_distance + weight

                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    previous_nodes[neighbor] = current_node
                    heapq.heappush(priority_queue, (distance, neighbor))

        return distances, previous_nodes

    def get_shortest_path(self, start_node, end_node):
        """
        Get the shortest path from the start node to the end node.

        Args:
            start_node (str): The node where the path starts.
            end_node (str): The node where the path ends.

        Returns:
            path (list): A list of nodes representing the shortest path from the start node to the end node.
        """
        distances, previous_nodes = self.dijkstra(start_node)
        path = []
        current_node = end_node

        while current_node is not None:
            path.append(current_node)
            current_node = previous_nodes[current_node]

        path.reverse()
        return path


def main():
    graph = Graph()

    # Criar 1000 nós numerados de 0 a 999
    for i in range(1000):
        graph.add_node(str(i))

    # Adicionar arestas aleatórias entre os nós com pesos aleatórios
    for _ in range(1000):  # Criar 3000 conexões aleatórias
        from_node = str(random.randint(0, 999))
        to_node = str(random.randint(0, 999))
        weight = random.randint(1, 100)  # Peso entre 1 e 100
        if from_node != to_node:  # Evita laços
            graph.add_edge(from_node, to_node, weight)

    # Definir um nó inicial e executar Dijkstra
    start_node = '0'
    distances, _ = graph.dijkstra(start_node)

if __name__ == "__main__":
    main()