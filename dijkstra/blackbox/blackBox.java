package com.dijkstra;

import java.util.Arrays;

public class blackBox {

    private static final int NO_PARENT = -1;

    /*public static void main(String[] args) {
        int adjMat [] [] = {
                {0, 2, 0, 4, 0, 0},
                {0, 0, 3, 2, 0, 0},
                {2, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };

        dijkstra(adjMat, 0);
    }*/

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

        printSolution(startNode, shortestDistances, parents);
    }

    private static void printSolution(int startNode, int[] distances, int[] parents) {
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
    }
}
