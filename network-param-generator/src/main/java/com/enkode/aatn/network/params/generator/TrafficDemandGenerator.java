package com.enkode.aatn.network.params.generator;

import com.enkode.aatn.network.params.constants.GlobalConstants;

public class TrafficDemandGenerator {

  public TrafficDemandGenerator() {
  }

  public int[][] getLinkTraffic() {
    int[][] b_ij = new int[GlobalConstants.SIZE][GlobalConstants.SIZE];
    for (int i = 0; i < GlobalConstants.SIZE; i++) {
      int[] b_i = new int[GlobalConstants.SIZE];

      for (int j = 0; j < GlobalConstants.SIZE; j++) {
        int d_i = GlobalConstants.NET_ID[i];
        int d_j = GlobalConstants.NET_ID[j];
        b_i[j] = Math.abs(d_i - d_j);
      }
      b_ij[i] = b_i;
    }
    return b_ij;
  }
}
