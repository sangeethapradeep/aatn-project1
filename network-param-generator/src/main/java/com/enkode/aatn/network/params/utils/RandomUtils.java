package com.enkode.aatn.network.params.utils;

import java.util.Random;

public class RandomUtils {

  public static int valueBetween(int min, int max) {
    Random random = new Random();
    return random.nextInt(max + min) + min;
  }
}
