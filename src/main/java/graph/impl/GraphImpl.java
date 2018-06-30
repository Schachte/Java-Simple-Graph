package graph.impl;

import graph.api.Graph;
import graph.api.Node;
import graph.exceptions.NodeException.NonExistentNodeException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GraphImpl implements Graph {

  private final static Logger LOGGER = Logger.getLogger(GraphImpl.class.getName());

  private List<Node> nodes = new ArrayList<>();

  private Node root;

  @Override
  public List<Node> getAllNodes() {
    LOGGER.info("Retrieving all nodes in the current graph");
    return nodes;
  }

  @Override
  public Node getRoot() {
    if (root == null) throw new NonExistentNodeException("Root node on graph is null");
    return root;
  }

  @Override
  public void setRootNode(Node root) {
    this.root = root;
  }

  @Override
  public Node findNode(String node) {
    for (Node n : nodes) {
      if (n.getNodeName().equals(node)) {
        return n;
      }
    }
    return null;
  }

  @Override
  public Node findNode(int node) {
    for (Node n : nodes) {
      if (n.getNodeData().equals(node)) {
        return n;
      }
    }
    return null;
  }

  @Override
  public void addNode(Node node) {
    if (!this.nodes.contains(node)) {
      nodes.add(node);
    }
    this.addNodes(node.getAdjacentNodes());
  }

  @Override
  public void addNodes(Node... nodes) {
    for (Node node : nodes) {
      LOGGER.info("Added node: " + node.getNodeName());
      if (!this.nodes.contains(node))
        this.nodes.add(node);
    }
  }

  @Override
  public void addNodes(List<Node> nodes) {
    for (Node node : nodes) {
      LOGGER.info("Added node: " + node.getNodeName());
      if (!this.nodes.contains(node))
        this.nodes.add(node);
    }
  }

  @Override
  public void removeNode(Node node) {
    nodes.remove(node);
  }

  @Override
  public void levelOrderPrint() {
    throw new NotImplementedException();
  }

  @Override
  public void preOrderPrint() {
    throw new NotImplementedException();
  }

  @Override
  public void postOrderPrint() {
    throw new NotImplementedException();
  }

  @Override
  public void inOrderPrint() {
    throw new NotImplementedException();
  }
}
