import java.util.*;

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {}

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}

public class copilot {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V; // Number of vertices
    List<List<Node>> adj;

    public copilot(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    // Function for Dijkstra's Algorithm
    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // adding the node whose distance is
            // finalized
            settled.add(u);

            e_Neighbours(u);
        }
    }

    // Function to process all the neighbours of the passed node
    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 1000; // Número de vértices do grafo

        // Criação do grafo com 1000 vértices
        List<List<Node>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Preenchendo o grafo com arestas e pesos
        // Este exemplo assume um grafo completo com todos os pesos de aresta iguais a 1
        // Você pode ajustar esta lógica conforme necessário para o seu grafo
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                adj.get(i).add(new Node(j, 1)); // Aresta direta de i para j com peso 1
                adj.get(j).add(new Node(i, 1)); // Aresta direta de j para i com peso 1
            }
        }

        // Criando uma instância de copilot com o número de vértices do grafo
        copilot dijkstra = new copilot(V);

        // Chamando o método dijkstra com o grafo e o nó de origem
        dijkstra.dijkstra(adj, 0); // Considerando o nó inicial como 0
    }
    
}