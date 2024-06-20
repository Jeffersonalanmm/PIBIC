package com.dijkstra.amazonQ;

import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class amazonQ {

  private static class Node implements Comparable<Node> {
    int vertex; 
    double distance;

    public Node(int vertex, double distance) {
      this.vertex = vertex;
      this.distance = distance;
    }

    public int compareTo(Node other) {
      if (this.distance < other.distance) {
        return -1;
      }
      if (this.distance > other.distance) {
        return 1;
      }
      return 0;
    }
  }

  public static void dijkstra(Graph graph, int source) {
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    Map<Integer, Double> distances = new HashMap<>();

    for (Map.Entry<Integer, Node> entry : graph.nodes.entrySet()) {
      int vertex = entry.getKey();
      distances.put(vertex, Double.MAX_VALUE);
    }

    distances.put(source, 0d);
    priorityQueue.add(new Node(source, 0d));

    while (!priorityQueue.isEmpty()) {
      Node node = priorityQueue.poll();
      int current = node.vertex;

      if (distances.get(current) < node.distance) {
        continue; 
      }

      for (Map.Entry<Integer, Double> adjacent : graph.getAdjacentNodes(current).entrySet()) {
        int destination = adjacent.getKey();
        double distance = adjacent.getValue();
        double newDistance = distances.get(current) + distance;

        if (newDistance < distances.get(destination)) {
          distances.put(destination, newDistance);
          priorityQueue.add(new Node(destination, newDistance));
        }
      }
    }

    // print results
    /*distances.forEach((key, value) -> {
      System.out.println("Distance to " + key + ": " + value);
    });*/
  }
}
