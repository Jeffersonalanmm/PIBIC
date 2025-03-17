import java.util.*;

public class Gemma2_9b_it {

    private static final int INF = Integer.MAX_VALUE;

    public static Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        // Initialize distances to infinity and add source node to queue
        for (int node : graph.keySet()) {
            distances.put(node, INF);
        }
        distances.put(source, 0);
        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int u = current.node;

            if (visited.contains(u)) {
                continue;
            }

            visited.add(u);

            // Update distances to neighbors
            for (Map.Entry<Integer, Integer> neighbor : graph.get(u).entrySet()) {
                int v = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDistance = distances.get(u) + weight;

                if (newDistance < distances.get(v)) {
                    distances.put(v, newDistance);
                    queue.add(new Node(v, newDistance));
                }
            }
        }

        return distances;
    }

    static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        // Número de nós
        int numNodes = 1000;

        // Gerador de números aleatórios
        Random random = new Random();

        // Grafo representado como um mapa de mapas
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        // Inicializando o grafo
        for (int i = 0; i < numNodes; i++) {
            graph.put(i, new HashMap<>());
        }

        // Criando arestas aleatórias
        for (int i = 0; i < numNodes; i++) {
            // Adicionando arestas de cada nó para outros nós aleatórios
            for (int j = 0; j < 3; j++) {  // Conectando a 3 nós aleatórios (pode ajustar esse número)
                int neighbor = random.nextInt(numNodes);  // Escolhendo um vizinho aleatório
                if (neighbor != i) {  // Não conectar um nó a si mesmo
                    int weight = random.nextInt(10) + 1;  // Peso aleatório entre 1 e 10
                    graph.get(i).put(neighbor, weight);
                }
            }
        }

        // Nó de partida
        int source = random.nextInt(numNodes);  // Escolhendo um nó de partida aleatório

        // Calculando as distâncias usando o algoritmo de Dijkstra
        Map<Integer, Integer> distances = dijkstra(graph, source);
    }
}