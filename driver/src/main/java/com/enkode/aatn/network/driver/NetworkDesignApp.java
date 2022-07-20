package com.enkode.aatn.network.driver;

import com.enkode.aatn.network.design.OptimalNetworkDesign;
import com.enkode.aatn.network.design.data.OptimalNetwork;
import com.enkode.aatn.network.params.constants.GlobalConstants;
import com.enkode.aatn.network.params.generator.CostGenerator;
import com.enkode.aatn.network.params.generator.TrafficDemandGenerator;
import com.enkode.aatn.network.visualizer.visualizer.Visualizer;

public class NetworkDesignApp {

  public static void main(String[] args) {
    CostGenerator costGenerator = new CostGenerator();
    TrafficDemandGenerator trafficDemandGenerator = new TrafficDemandGenerator();
    Visualizer visualizer = new Visualizer();

    for (int k = GlobalConstants.MIN_K; k <= GlobalConstants.MAX_K; k++) {
      int[][] a_ij = costGenerator.getLinkCost(k);
      int[][] b_ij = trafficDemandGenerator.getLinkTraffic();

      OptimalNetworkDesign networkDesign = new OptimalNetworkDesign(GlobalConstants.SIZE, a_ij,
        b_ij);

      OptimalNetwork optimalNetwork = networkDesign.findOptimalCost();
      if (k == 3 || k == 8 || k == 14) {
        visualizer.drawGraph(GlobalConstants.SIZE, optimalNetwork.getEdgeList(), k);
      }
      System.out.print("Cost for k=" + k + " :" + optimalNetwork.getCost());

      double density =
        optimalNetwork.getEdgeList().size() / (double) ((GlobalConstants.SIZE * (
          GlobalConstants.SIZE - 1)));
      System.out.println("; Density: " + density);

    }
  }

}
