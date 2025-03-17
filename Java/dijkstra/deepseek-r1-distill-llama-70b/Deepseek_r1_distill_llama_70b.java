import java.util.Random;
public class Deepseek_r1_distill_llama_70b {
    private static class Node implements Comparable<Node> {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int numNodes, List<List<int[]>> adjacencyList, int startNode) {
        // Initialize distances
        int[] distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        // Priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));

        // Visited array
        boolean[] visited = new boolean[numNodes];

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentId = currentNode.id;
            int currentDistance = currentNode.distance;

            if (visited[currentId]) {
                continue;
            }

            visited[currentId] = true;

            // Explore neighbors
            for (int[] edge : adjacencyList.get(currentId)) {
                int neighbor = edge[0];
                int weight = edge[1];

                if (!visited[neighbor]) {
                    int newDistance = currentDistance + weight;
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        pq.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        // Número de nós
        int numNodes = 1000;

        // Gerador de números aleatórios
        Random random = new Random();

        // Lista de adjacência para o grafo
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Criando arestas aleatórias
        for (int i = 0; i < numNodes; i++) {
            // Adicionando arestas de cada nó para outros nós aleatórios
            for (int j = 0; j < 3; j++) {  // Conectando a 3 nós aleatórios (pode ajustar esse número)
                int neighbor = random.nextInt(numNodes);  // Escolhendo um vizinho aleatório
                if (neighbor != i) {  // Não conectar um nó a si mesmo
                    int weight = random.nextInt(10) + 1;  // Peso aleatório entre 1 e 10
                    adjacencyList.get(i).add(new int[]{neighbor, weight});
                }
            }
        }

        // Nó de partida
        int startNode = random.nextInt(numNodes);  // Escolhendo um nó de partida aleatório

        // Calculando as distâncias usando o algoritmo de Dijkstra
        int[] distances = dijkstra(numNodes, adjacencyList, startNode);
    }
}
