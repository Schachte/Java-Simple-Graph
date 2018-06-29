package graph.impl;

import static org.junit.Assert.*;

import graph.api.Edge;
import graph.api.Node;
import org.junit.Test;

public class EdgeImplTest {

  @Test
  public void getDestination() {
    Node node1 = new NodeImpl("name", 0);
    Node node2 = new NodeImpl("name2", 1);

    Edge edgeTest = new EdgeImpl(55, node1);

    assertTrue(edgeTest.getDestination() == node1);
  }

  @Test
  public void getWeight() {
    Node node1 = new NodeImpl("name", 0);
    Node node2 = new NodeImpl("name2", 1);

    Edge edgeTest = new EdgeImpl(55, node1);

    assertTrue(edgeTest.getWeight() == 55);
  }
}
