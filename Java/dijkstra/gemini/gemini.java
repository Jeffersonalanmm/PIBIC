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
        int[] dist = new int[V]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; 
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
    }
    public static void main(String[] args) {
        int nVertices = 1000;
        int[][] adjMat = new int[nVertices][nVertices];
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                if (i == j) {
                    adjMat[i][j] = 0; 
                } else {
                    adjMat[i][j] = 1; 
                }
            }
        }
        dijkstra(adjMat, 0);
    }
}
