import java.util.Arrays;

public class BlackBox {

    private static final int NO_PARENT = -1;

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

    public static void dijkstra(int[][] adjMat, int startNode) {
        int nVertices = adjMat[0].length;

        int[] shortestDistances = new int[nVertices];
        boolean[] added = new boolean[nVertices];

        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        Arrays.fill(added, false);

        shortestDistances[startNode] = 0;

        int[] parents = new int[nVertices];
        parents[startNode] = NO_PARENT;

        for (int i = 1; i < nVertices; ++i) {
            int nearestNode = -1;
            int smallestDistance = Integer.MAX_VALUE;
            for (int j = 0; j < nVertices; ++j) {
                if (!added[j] && shortestDistances[j] < smallestDistance) {
                    nearestNode = j;
                    smallestDistance = shortestDistances[j];
                }
            }

            added[nearestNode] = true;

            for (int k = 0; k < nVertices; ++k) {
                int edgeDistance = adjMat[nearestNode][k];
                if (edgeDistance > 0 && ((smallestDistance + edgeDistance) < shortestDistances[k])) {
                    parents[k] = nearestNode;
                    shortestDistances[k] = smallestDistance + edgeDistance;
                }
            }
        }

        //printSolution(startNode, shortestDistances, parents);
    }

    /*private static void printSolution(int startNode, int[] distances, int[] parents) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; ++vertexIndex) {
            if (vertexIndex != startNode) {
                System.out.print("\n" + startNode + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }

    private static void printPath(int currentVertex, int[] parents) {
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }*/
}
