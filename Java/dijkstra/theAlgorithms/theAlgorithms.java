class theAlgorithms {

    int k = 9;

    int minDist(int[] dist, Boolean[] Set) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int r = 0; r < k; r++) {
            if (!Set[r] && dist[r] <= min) {
                min = dist[r];
                min_index = r;
            }
        }

        return min_index;
    }

    void print(int[] dist) {
        System.out.println("Vertex \t\t Distance");
        for (int i = 0; i < k; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[k];
        Boolean[] Set = new Boolean[k];

        for (int i = 0; i < k; i++) {
            dist[i] = Integer.MAX_VALUE;
            Set[i] = false;
        }

        dist[src] = 0;

        for (int c = 0; c < k - 1; c++) {
            int u = minDist(dist, Set);

            Set[u] = true;

            for (int v = 0; v < k; v++) {
                if (!Set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        print(dist);
    }
    public static void main(String[] args) {
        int nVertices = 1000; // Número de vértices do grafo

        // Criação do grafo com 1000 vértices
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

        // Criando uma instância de theAlgorithms
        theAlgorithms alg = new theAlgorithms();

        // Chama o método dijkstra na instância criada
        alg.dijkstra(adjMat, 0); // Considerando o nó inicial como 0
    }
}