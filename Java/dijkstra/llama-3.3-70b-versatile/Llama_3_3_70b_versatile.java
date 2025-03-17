import java.util.*;

public class Llama_3_3_70b_versatile {
    private static class Node implements Comparable<Node> {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        int[] previousNodes = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize distances and previous nodes
        for (int i = 0; i < numNodes; i++) {
            distances[i] = Integer.MAX_VALUE;
            previousNodes[i] = -1;
        }
        distances[startNode] = 0;

        // Create a priority queue to hold nodes to visit
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentNodeId = currentNode.id;

            // If we've already visited this node, skip it
            if (visited[currentNodeId]) {
                continue;
            }

            // Mark the node as visited
            visited[currentNodeId] = true;

            // Update distances for neighboring nodes
            for (int i = 0; i < numNodes; i++) {
                int edgeWeight = graph[currentNodeId][i];
                if (edgeWeight > 0 && !visited[i]) {
                    int newDistance = distances[currentNodeId] + edgeWeight;
                    if (newDistance < distances[i]) {
                        distances[i] = newDistance;
                        previousNodes[i] = currentNodeId;
                        queue.add(new Node(i, newDistance));
                    }
                }
            }
        }

        // Print the shortest distances and paths
        System.out.println("Shortest Distances:");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }

        System.out.println("Shortest Paths:");
        for (int i = 0; i < numNodes; i++) {
            if (i != startNode) {
                System.out.print("Path from node " + startNode + " to node " + i + ": ");
                printPath(previousNodes, startNode, i);
                System.out.println();
            }
        }
    }

    private static void printPath(int[] previousNodes, int startNode, int endNode) {
        if (endNode == startNode) {
            System.out.print(startNode);
        } else {
            printPath(previousNodes, startNode, previousNodes[endNode]);
            System.out.print(" -> " + endNode);
        }
    }

    public static void main(String[] args) {
        int numNodes = 1000;

        // Gerador de números aleatórios
        Random random = new Random();

        // Matriz de adjacência para o grafo
        int[][] graph = new int[numNodes][numNodes];

        // Criando arestas aleatórias
        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                if (random.nextDouble() < 0.05) { // 5% de chance de criar uma aresta
                    int weight = random.nextInt(10) + 1;  // Peso aleatório entre 1 e 10
                    graph[i][j] = weight;
                    graph[j][i] = weight;  // Grafo não direcionado
                }
            }
        }

        // Nó de partida aleatório
        int startNode = random.nextInt(numNodes);

        // Calculando as distâncias usando o algoritmo de Dijkstra
        dijkstra(graph, startNode);
    }
}