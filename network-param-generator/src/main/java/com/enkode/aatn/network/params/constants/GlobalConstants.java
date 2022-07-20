package com.enkode.aatn.network.params.constants;

public class GlobalConstants {

  public static final int[] NET_ID = new int[]{2, 0, 2, 1, 5, 9, 6, 0, 6, 8, 2, 0, 2, 1, 5, 9, 6, 0,
    6, 8, 2};
  public static final int SIZE = 21;
  public static final int MAX_K = 14;
  public static final int MIN_K = 3;
  public static final int MAX_LINK_COST = 100;
  public static final int MIN_LINK_COST = 1;

  private GlobalConstants() {
    throw new Error("Can't initiate a singleton class");
  }
}
