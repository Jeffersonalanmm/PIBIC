import java.util.*;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Mixtral_8x7b_32768 {
    private static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        // Número de nós no grafo
        int n = 1000;

        // Criando o grafo com n nós
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Gerador de números aleatórios
        Random random = new Random();

        // Criando arestas aleatórias
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (random.nextDouble() < 0.05) { // 5% de chance de criar uma aresta
                    int weight = random.nextInt(10) + 1; // Peso aleatório entre 1 e 10
                    addEdge(graph, i, j, weight);
                    addEdge(graph, j, i, weight); // Grafo não direcionado
                }
            }
        }

        // Nó de partida aleatório
        int startNode = random.nextInt(n);

        // Executando o algoritmo de Dijkstra a partir do nó de partida aleatório
        int[] dist = dijkstra(graph, startNode);
    }

    private static void addEdge(List<List<Edge>> graph, int from, int to, int weight) {
        graph.get(from).add(new Edge(to, weight));
    }

    private static int[] dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean[] visited = new boolean[n];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(node -> dist[node]));
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) continue;
            visited[node] = true;

            for (Edge edge : graph.get(node)) {
                int next = edge.to;
                int nextDist = dist[node] + edge.weight;
                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    queue.add(next);
                }
            }
        }

        return dist;
    }
}