package com.enkode.aatn.network.visualizer.visualizer;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.mutNode;

import com.enkode.aatn.network.design.util.Pair;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Visualizer {

  public void drawGraph(int size, Set<Pair<Integer>> edges, int graphNo) {
    MutableGraph g = mutGraph("example1").setDirected(true);

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        if (i != j && edges.contains(new Pair<>(i - 1, j - 1))) {
          g.add(mutNode("" + i).addLink(mutNode("" + j)));
        }
      }
      try {
        Graphviz.fromGraph(g).render(Format.PNG)
          .toFile(new File("example/graph" + graphNo + ".png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
