package com.enkode.aatn.network.design.data;

import com.enkode.aatn.network.design.util.Pair;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OptimalNetwork {

  int cost;
  Set<Pair<Integer>> edgeList;
}
