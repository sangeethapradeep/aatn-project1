package com.enkode.aatn.network.params.generator;

import com.enkode.aatn.network.params.constants.GlobalConstants;
import com.enkode.aatn.network.params.utils.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class CostGenerator {

  public CostGenerator() {
  }

  public int[][] getLinkCost(int k) {
    int[][] a_ij = new int[GlobalConstants.SIZE][GlobalConstants.SIZE];
    for (int i = 0; i < GlobalConstants.SIZE; i++) {
      int[] a_i = new int[GlobalConstants.SIZE];
      List<Integer> randomIndices = kRandomIndicesForI(k, i);

      for (int j = 0; j < GlobalConstants.SIZE; j++) {
        if (i == j) {
          a_i[j] = 0;
        } else if (randomIndices.contains(j)) {
          a_i[j] = GlobalConstants.MIN_LINK_COST;
        } else {
          a_i[j] = GlobalConstants.MAX_LINK_COST;
        }
      }
      a_ij[i] = a_i;
    }
    return a_ij;
  }

  private List<Integer> kRandomIndicesForI(int k, int i) {
    List<Integer> randomIndices = new ArrayList<>(k);
    for (int j = 0; j < k; j++) {
      int random = RandomUtils.valueBetween(0, GlobalConstants.SIZE);
      while (randomIndices.contains(random) || random == i) {
        random = RandomUtils.valueBetween(0, GlobalConstants.SIZE);
      }
      randomIndices.add(random);
    }
    return randomIndices;
  }

}
