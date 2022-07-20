package com.enkode.aatn.network.design.data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShortestPathData {

  private int cost;
  private List<Integer> vertexList;

}
