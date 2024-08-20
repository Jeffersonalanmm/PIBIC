import java.util.*;

public class chatGPT {
    private static final int INF = Integer.MAX_VALUE;

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

    public static void dijkstra(int[][] graph, int src) { //mudou de private para public
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
