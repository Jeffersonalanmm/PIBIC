import java.util.*;

public class gemini {

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];  // Stores shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;  // Distance of source from itself is 0
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.node;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " : " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        int nVertices = 1000; // Número de vértices do grafo

        // Criação do grafo com 100.000 vértices
        int[][] adjMat = new int[nVertices][nVertices];
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                // Lógica para preencher a matriz de adjacência com valores específicos
                // Este exemplo assume um grafo com todos os pesos de aresta iguais a 1
                // Você pode ajustar esta lógica conforme necessário para o seu grafo
                if (i == j) {
                    adjMat[i][j] = 0; // Distância de um vértice para ele mesmo é zero
                } else {
                    adjMat[i][j] = 1; // Distância de um vértice para outro é 1 (aresta direta)
                }
            }
        }

        // Chama o algoritmo de Dijkstra com o grafo criado
        dijkstra(adjMat, 0); // Considerando o nó inicial como 0
    }
}
