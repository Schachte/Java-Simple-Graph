package graph.impl;

import static org.junit.Assert.*;

import common.api.Graph;
import common.api.Node;
import common.impl.NodeImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GraphImplTest {

  private static final int EDGE_WEIGHT = 10;

  private static final String NODE_NAME_PREFIX = "testNode-";

  private static final String SAMPLE_PROP_KEY = "prop-key";

  private static final String SAMPLE_PROP_VAL = "prop-val";

  private static final String NODE_1 = "1";

  private static final String NODE_2 = "2";

  private static final String NODE_3 = "3";

  private static final String NODE_4 = "4";

  private static final int SAMPLE_NODE_VALUE_1 = 20;

  private static final int SAMPLE_NODE_VALUE_2 = 30;

  private static final int DEFAULT_NODE_VALUE = 0;

  private static final int DEFAULT_EDGE_WEIGHT = 0;

  private Graph g;

  private Node testNode;

  private Node testNode2;

  private Node testNode3;

  private Node testNode4;

  @Before
  public void setup() {

    testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_1);
    testNode4 = new NodeImpl(NODE_NAME_PREFIX + NODE_4, SAMPLE_NODE_VALUE_2);

    List<Node> adjNodes = new ArrayList<>();
    adjNodes.add(testNode2);
    adjNodes.add(testNode3);
    adjNodes.add(testNode4);

    testNode.bulkAddConnections(10, adjNodes);

    g = new GraphImpl();
    g.addNodes(testNode, testNode2, testNode3, testNode4);
    g.addNodes(adjNodes);
  }

  @Test
  public void getAllNodes() {
    assertTrue(g.getAllNodes().contains(testNode));
    assertTrue(g.getAllNodes().contains(testNode2));
    assertTrue(g.getAllNodes().contains(testNode3));
    assertTrue(g.getAllNodes().contains(testNode4));
  }

  @Test
  public void getRootSucceeds() {
    g.setRootNode(testNode);
    assertTrue(g.getRoot() == testNode);
  }

  @Test
  public void setRootNodeSucceeds() {
    g.setRootNode(testNode);
    assertTrue(g.getRoot() == testNode);
  }

  @Test
  public void addNodeSucceeds() {
    Node newTestNode = new NodeImpl(NODE_NAME_PREFIX + "new", SAMPLE_NODE_VALUE_1);
    assertFalse(g.getAllNodes().contains(newTestNode));
    g.addNodes(newTestNode);
    g.addNodes(newTestNode);
    g.addNodes(newTestNode);
    g.addNodes(newTestNode);
    g.addNodes(newTestNode);
    assertTrue(g.getAllNodes().contains(newTestNode));
  }

  @Test
  public void addNodesByList() {
    Node newTestNode1 = new NodeImpl(NODE_NAME_PREFIX + "new", SAMPLE_NODE_VALUE_1);
    Node newTestNode2 = new NodeImpl(NODE_NAME_PREFIX + "new", SAMPLE_NODE_VALUE_1);

    List<Node> nodeList = new ArrayList<>();
    nodeList.add(newTestNode1);
    nodeList.add(newTestNode2);

    assertFalse(g.getAllNodes().contains(newTestNode1));
    assertFalse(g.getAllNodes().contains(newTestNode2));

    g.addNodes(nodeList);

    assertTrue(g.getAllNodes().contains(newTestNode1));
    assertTrue(g.getAllNodes().contains(newTestNode2));
  }

  @Test
  public void addNodesInBulk() {
    Node newTestNode1 = new NodeImpl(NODE_NAME_PREFIX + "new", SAMPLE_NODE_VALUE_1);
    Node newTestNode2 = new NodeImpl(NODE_NAME_PREFIX + "new", SAMPLE_NODE_VALUE_1);

    assertFalse(g.getAllNodes().contains(newTestNode1));
    assertFalse(g.getAllNodes().contains(newTestNode2));

    g.addNodes(newTestNode1, newTestNode2);

    assertTrue(g.getAllNodes().contains(newTestNode1));
    assertTrue(g.getAllNodes().contains(newTestNode2));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void levelOrderPrint() {
    g.levelOrderPrint();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void preOrderPrint() {
    g.preOrderPrint();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void postOrderPrint() {
    g.postOrderPrint();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void inOrderPrint() {
    g.inOrderPrint();
  }
}
