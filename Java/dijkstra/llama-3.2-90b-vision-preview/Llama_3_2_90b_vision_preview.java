import java.util.*;

class Node implements Comparable<Node> {
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

public class Llama_3_2_90b_vision_preview {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Initialize distances and visited arrays
        for (int i = 0; i < numNodes; i++) {
            distances[i] = INF;
            visited[i] = false;
        }

        distances[start] = 0; // Distance to start node is 0

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeId = node.id;

            if (visited[nodeId]) {
                continue;
            }

            visited[nodeId] = true;

            for (int neighbor = 0; neighbor < numNodes; neighbor++) {
                if (graph[nodeId][neighbor] > 0 && !visited[neighbor]) {
                    int newDistance = distances[nodeId] + graph[nodeId][neighbor];

                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        queue.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        // Número de nós
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