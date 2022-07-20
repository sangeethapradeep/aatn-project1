package com.enkode.aatn.network.design;

import com.enkode.aatn.network.design.data.OptimalNetwork;
import com.enkode.aatn.network.design.data.ShortestPathData;
import com.enkode.aatn.network.design.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalNetworkDesign {

  int size;
  Map<Pair<Integer>, Integer> optimalCostMap;
  int[][] trafficDemand;
  int[][] costPerUnit;
  Network network;
  ShortestPath shortestPath;

  public OptimalNetworkDesign(int size, int[][] costPerUnit,
    int[][] trafficDemand) {
    this.size = size;
    this.trafficDemand = trafficDemand;
    this.costPerUnit = costPerUnit;
    this.network = new Network(size, costPerUnit);
    this.shortestPath = new ShortestPath();

    optimalCostMap = new HashMap<>();

    initializeMap(size);
  }

  private void initializeMap(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        optimalCostMap.put(new Pair<>(i, j), 0);
      }
    }
  }

  public OptimalNetwork findOptimalCost() {
    int totalCost = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        Pair<Integer> edge = new Pair<>(i, j);
        ShortestPathData shortedPathData = shortestPath.findShortestPath(network, i, j);
        int cheapestLinkCost = trafficDemand[i][j] * shortedPathData.getCost();
        optimalCostMap.put(edge, cheapestLinkCost);
        markEdgesVisited(shortedPathData.getVertexList());
        totalCost += cheapestLinkCost;
      }
    }
    return new OptimalNetwork(totalCost, network.getVisitedEdges());
  }

  private void markEdgesVisited(List<Integer> edgeList) {
    for (int i = 0; i < edgeList.size() - 1; i++) {
      network.visitEdge(new Pair<>(edgeList.get(i), edgeList.get(i + 1)));
    }
  }


}

