package com.enkode.aatn.network.design;

import com.enkode.aatn.network.design.data.ShortestPathData;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class ShortestPath {

  ShortestPath() {
  }

  public ShortestPathData findShortestPath(Network network, int src, int dest) {
    int shortestPathCost = 0;
    GraphPath<Integer, DefaultWeightedEdge> shortestPath = DijkstraShortestPath.findPathBetween(
      network.getNetwork(), src, dest);
    for (DefaultWeightedEdge edge : shortestPath.getEdgeList()) {
      shortestPathCost += network.getNetwork().getEdgeWeight(edge);
    }

    return new ShortestPathData(shortestPathCost, shortestPath.getVertexList());
  }

}
