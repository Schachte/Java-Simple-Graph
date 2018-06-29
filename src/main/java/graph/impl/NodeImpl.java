package graph.impl;

import graph.api.Edge;
import graph.api.Node;
import graph.exceptions.NodeException.EdgeInvalidException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NodeImpl implements Node<String, Integer> {

  private final static Logger LOGGER = Logger.getLogger(NodeImpl.class.getName());

  private final String nodeName;

  private final int nodeValue;

  private final Map<String, Object> props;

  private Map<Node<String, Integer>, Edge> edgeAdjacency = new HashMap<>();

  public NodeImpl(String nodeName, int nodeValue) {
    this.nodeName = nodeName;
    this.nodeValue = nodeValue;
    this.props = new HashMap<>();
  }

  public NodeImpl(String nodeName) {
    this.nodeName = nodeName;
    this.nodeValue = 0;
    this.props = new HashMap<>();
  }

  public NodeImpl(int nodeValue) {
    this.nodeValue = nodeValue;
    this.nodeName = "node-name";
    this.props = new HashMap<>();
  }

  public NodeImpl(String nodeName, int nodeValue, Map<String, Object> props) {
    this.nodeName = nodeName;
    this.nodeValue = nodeValue;
    this.props = props;
  }

  public Integer getNodeData() {
    return this.nodeValue;
  }

  public String getNodeName() {
    return this.nodeName;
  }

  public void addConnection(Node destinationNode, double weight) {
    if (!edgeAdjacency.containsKey(destinationNode))
      edgeAdjacency.put(destinationNode, new EdgeImpl(weight, destinationNode));
    else
      LOGGER.info("Node already exists... Ignoring operation");
  }

  public void addConnection(Node destinationNode) {
    if (!edgeAdjacency.containsKey(destinationNode))
      edgeAdjacency.put(destinationNode, new EdgeImpl(destinationNode));
  }

  public void bulkAddConnections(int weight, Node ... childNodes) {
    for (Node node : childNodes) {
      if (!edgeAdjacency.containsKey(node))
        edgeAdjacency.put(node, new EdgeImpl(weight, node));
    }
  }

  public void bulkAddConnections(Node ... childNodes) {
    for (Node node : childNodes) {
      if (!edgeAdjacency.containsKey(node))
        edgeAdjacency.put(node, new EdgeImpl(node));
    }
  }

  public void bulkAddConnections(List<Node> childNodes) {
    for (Node node : childNodes) {
      if (!edgeAdjacency.containsKey(node))
        edgeAdjacency.put(node, new EdgeImpl(node));
    }
  }

  public void bulkAddConnections(int weight, List<Node> childNodes) {
    for (Node node : childNodes) {
      if (!edgeAdjacency.containsKey(node))
        edgeAdjacency.put(node, new EdgeImpl(weight, node));
    }
  }

  public double getEdgeWeight(Node destinationNode) {
    if (edgeAdjacency.containsKey(destinationNode)) return edgeAdjacency.get(destinationNode).getWeight();
    throw new EdgeInvalidException("Edge doesn't exist for requested destination node");
  }

  public List<Node<String, Integer>> getAdjacentNodes() {
    return edgeAdjacency
        .keySet()
        .stream()
        .collect(Collectors.toList());
  }

  public Map<String, Object> getProps() {
    return this.props;
  }

  public Object retrieveProp(String key) {
    if (this.props.containsKey(key))
      return this.props.get(key);

    LOGGER.info("Key prop doesn't exist!");
    return null;
  }
}
