package graph.impl;

import static org.junit.Assert.*;

import common.api.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.impl.NodeImpl;
import org.junit.Test;

public class NodeImplTest {

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

  @Test
  public void getNodeData() {
    Node testNode = new NodeImpl(SAMPLE_NODE_VALUE_1);
    assertTrue(testNode.getNodeData().equals(SAMPLE_NODE_VALUE_1));
  }

  @Test
  public void getNodeName() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1);
    assertTrue(testNode.getNodeName().equals(NODE_NAME_PREFIX + NODE_1));
  }

  @Test
  public void addConnectionNodeWithNoWeight() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2);

    assertFalse(testNode.getAdjacentNodes().contains(testNode2));

    testNode.addConnection(testNode2);

    assertTrue(testNode.getNodeName().equals(NODE_NAME_PREFIX + NODE_1));
    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getNodeData().equals(DEFAULT_NODE_VALUE));
  }

  @Test
  public void addConnectionNodeWithWeight() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);

    assertFalse(testNode.getAdjacentNodes().contains(testNode2));

    testNode.addConnection(testNode2, EDGE_WEIGHT);

    assertTrue(testNode.getNodeName().equals(NODE_NAME_PREFIX + NODE_1));
    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getNodeData().equals(SAMPLE_NODE_VALUE_1));

    assertTrue(testNode.getEdgeWeight(testNode2) == EDGE_WEIGHT);
  }

  @Test
  public void addSameNodeConnectionWithWeightUpdateDoesNothing() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);

    testNode.addConnection(testNode2, EDGE_WEIGHT);
    assertTrue(testNode.getEdgeWeight(testNode2) == EDGE_WEIGHT);

    testNode.addConnection(testNode2, EDGE_WEIGHT * 2);
    assertTrue(testNode.getEdgeWeight(testNode2) == EDGE_WEIGHT);

    testNode.addConnection(testNode2, EDGE_WEIGHT * 3);
    assertTrue(testNode.getEdgeWeight(testNode2) == EDGE_WEIGHT);
  }

  @Test
  public void bulkAddConnectionsWeightsAndNodes() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    Node testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_1);
    Node testNode4 = new NodeImpl(NODE_NAME_PREFIX + NODE_4, SAMPLE_NODE_VALUE_2);

    testNode.bulkAddConnections(EDGE_WEIGHT, testNode2, testNode3, testNode4);
    testNode2.bulkAddConnections(EDGE_WEIGHT, testNode4);

    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getAdjacentNodes().contains(testNode3));
    assertTrue(testNode.getAdjacentNodes().contains(testNode4));
    assertFalse(testNode.getAdjacentNodes().contains(testNode));
    assertFalse(testNode2.getAdjacentNodes().contains(testNode3));
  }

  @Test
  public void bulkAddConnectionsByList() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    Node testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_1);
    Node testNode4 = new NodeImpl(NODE_NAME_PREFIX + NODE_4, SAMPLE_NODE_VALUE_2);

    List<Node> adjNodes = new ArrayList<>();
    adjNodes.add(testNode2);
    adjNodes.add(testNode3);
    adjNodes.add(testNode4);

    testNode.bulkAddConnections(adjNodes);

    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getAdjacentNodes().contains(testNode3));
    assertTrue(testNode.getAdjacentNodes().contains(testNode4));
    assertFalse(testNode.getAdjacentNodes().contains(testNode));
    assertFalse(testNode2.getAdjacentNodes().contains(testNode3));
  }

  @Test
  public void bulkAddConnectionsByListWithWeight() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    Node testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_1);
    Node testNode4 = new NodeImpl(NODE_NAME_PREFIX + NODE_4, SAMPLE_NODE_VALUE_2);

    List<Node> adjNodes = new ArrayList<>();
    adjNodes.add(testNode2);
    adjNodes.add(testNode3);
    adjNodes.add(testNode4);

    testNode.bulkAddConnections(10, adjNodes);

    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getAdjacentNodes().contains(testNode3));
    assertTrue(testNode.getAdjacentNodes().contains(testNode4));
    assertFalse(testNode.getAdjacentNodes().contains(testNode));
    assertFalse(testNode2.getAdjacentNodes().contains(testNode3));

    assertTrue(testNode.getEdgeWeight(testNode2) == 10);
    assertTrue(testNode.getEdgeWeight(testNode3) == 10);
    assertTrue(testNode.getEdgeWeight(testNode4) == 10);
  }

  @Test
  public void bulkAddConnectionsWithNoWeight() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    Node testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_1);
    Node testNode4 = new NodeImpl(NODE_NAME_PREFIX + NODE_4, SAMPLE_NODE_VALUE_2);

    testNode.bulkAddConnections(testNode2, testNode3, testNode4);

    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getAdjacentNodes().contains(testNode3));
    assertTrue(testNode.getAdjacentNodes().contains(testNode4));
    assertFalse(testNode.getAdjacentNodes().contains(testNode));
    assertFalse(testNode2.getAdjacentNodes().contains(testNode3));

    assertTrue(testNode.getEdgeWeight(testNode2) == DEFAULT_EDGE_WEIGHT);
    assertTrue(testNode.getEdgeWeight(testNode3) == DEFAULT_EDGE_WEIGHT);
    assertTrue(testNode.getEdgeWeight(testNode4) == DEFAULT_EDGE_WEIGHT);
  }

  @Test
  public void getEdgeWeight() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    Node testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_2);

    testNode.addConnection(testNode2, EDGE_WEIGHT);
    assertTrue(testNode.getEdgeWeight(testNode2) == EDGE_WEIGHT);

    testNode.addConnection(testNode3);
    assertTrue(testNode.getEdgeWeight(testNode3) == DEFAULT_EDGE_WEIGHT);
  }

  @Test
  public void getAdjacentNodes() {
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1);
    Node testNode2 = new NodeImpl(NODE_NAME_PREFIX + NODE_2, SAMPLE_NODE_VALUE_2);
    Node testNode3 = new NodeImpl(NODE_NAME_PREFIX + NODE_3, SAMPLE_NODE_VALUE_1);
    Node testNode4 = new NodeImpl(NODE_NAME_PREFIX + NODE_4, SAMPLE_NODE_VALUE_2);

    List<Node> adjNodes = new ArrayList<>();
    adjNodes.add(testNode2);
    adjNodes.add(testNode3);
    adjNodes.add(testNode4);

    testNode.bulkAddConnections(adjNodes);

    assertTrue(testNode.getAdjacentNodes().contains(testNode2));
    assertTrue(testNode.getAdjacentNodes().contains(testNode3));
    assertTrue(testNode.getAdjacentNodes().contains(testNode4));
  }

  @Test
  public void getProps() {
    Map<String, Object> props = new HashMap<>();
    props.put(SAMPLE_PROP_KEY, SAMPLE_PROP_VAL);
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1, props);

    assertTrue(testNode.getProps().containsKey(SAMPLE_PROP_KEY));
    assertTrue(testNode.getProps().get(SAMPLE_PROP_KEY).equals(SAMPLE_PROP_VAL));
  }

  @Test
  public void retrieveProp() {
    Map<String, Object> props = new HashMap<>();
    props.put(SAMPLE_PROP_KEY, SAMPLE_PROP_VAL);
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1, props);

    assertTrue(testNode.retrieveProp(SAMPLE_PROP_KEY).equals(SAMPLE_PROP_VAL));
  }

  @Test
  public void retrievePropIfDoesntExist() {
    Map<String, Object> props = new HashMap<>();
    props.put(SAMPLE_PROP_KEY, SAMPLE_PROP_VAL);
    Node testNode = new NodeImpl(NODE_NAME_PREFIX + NODE_1, SAMPLE_NODE_VALUE_1, props);

    assertTrue(testNode.retrieveProp(SAMPLE_PROP_KEY + "wrong") == null);
  }
}
