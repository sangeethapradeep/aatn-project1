package com.enkode.aatn.network.design;

import com.enkode.aatn.network.design.util.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

@Getter
public class Network {

  private final int size;
  private final int[][] linkCost;
  private final SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> network;
  private final Set<Pair<Integer>> visitedEdges;

  Network(int size, int[][] weights) {
    this.size = size;
    this.linkCost = weights;
    this.network = new SimpleDirectedWeightedGraph<>(
      DefaultWeightedEdge.class);
    constructGraph();
    this.visitedEdges = new HashSet<>();
  }

  private void constructGraph() {
    addNodes();
    addEdges();
  }

  private void addEdges() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i != j) {
          DefaultWeightedEdge edge = network.addEdge(i, j);
          network.setEdgeWeight(edge, linkCost[i][j]);
        }
      }
    }
  }

  private void addNodes() {
    for (int i = 0; i < size; i++) {
      network.addVertex(i);
    }
  }

  public void visitEdge(Pair<Integer> edge) {
    this.visitedEdges.add(edge);
  }
}
