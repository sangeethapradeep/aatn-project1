package com.enkode.aatn.network.design.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Pair<k> {

  k item1;
  k item2;

}