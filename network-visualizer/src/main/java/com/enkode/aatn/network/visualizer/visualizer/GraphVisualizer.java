package com.enkode.aatn.network.visualizer.visualizer;

import com.enkode.aatn.network.design.util.Pair;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphVisualizer {

  DefaultDirectedGraph<Integer, DefaultEdge> g;

  public GraphVisualizer() {
    this.g = new DefaultDirectedGraph<>(DefaultEdge.class);
  }

  public void drawGraph(int size, List<Pair<Integer>> edges, int graphNo) {

    addVertices(size);
    addEdges(edges);

    JGraphXAdapter<Integer, DefaultEdge> graphAdapter = new JGraphXAdapter<>(g);
    graphAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, 1);
    mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
    layout.execute(graphAdapter.getDefaultParent());

    BufferedImage image =
      mxCellRenderer.createBufferedImage(graphAdapter, null, 6, Color.WHITE, true, null);
    try {
      ImageIO.write(image, "PNG", new File("example/graph" + graphNo + ".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void addVertices(int size) {
    for (int i = 1; i <= size; i++) {
      g.addVertex(i);
    }
  }

  private void addEdges(List<Pair<Integer>> edges) {
    for (Pair<Integer> edge : edges) {
      if (!g.containsEdge(edge.getItem1() + 1, edge.getItem2() + 1)) {
        g.addEdge(edge.getItem1() + 1, edge.getItem2() + 1);
      }
    }
  }


}
