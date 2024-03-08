import java.util.*;

public class codeium {
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
        pq.add(source);
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(v);
                }
            }
        }
        
        // Print the shortest distances from the source
        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from " + source + " to " + i + " is " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int nVertices = 1000; // Número de vértices do grafo
    
        // Criação do grafo com 1000 vértices
        int[][] graph = new int[nVertices][nVertices];
        for (int i = 0; i < nVertices; i++) {
           for (int j = 0; j < nVertices; j++) {
                // Lógica para preencher a matriz de adjacência com valores específicos
                // Este exemplo assume um grafo com todos os pesos de aresta iguais a 1
                // Você pode ajustar esta lógica conforme necessário para o seu grafo
                if (i == j) {
                    graph[i][j] = 0; // Distância de um vértice para ele mesmo é zero
                } else {
                    graph[i][j] = 1; // Distância de um vértice para outro é 1 (aresta direta)
                }
            }
        }
    
        // Chama o método dijkstra com o grafo criado
        codeium.dijkstra(graph, 0); // Considerando o nó inicial como 0
    } 
    
}