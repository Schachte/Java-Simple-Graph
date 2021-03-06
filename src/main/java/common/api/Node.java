package common.api;

import java.util.List;
import java.util.Map;

/**
 * Represents the core data structure that will make up the
 * main {@link Graph} component. Designed to be generic but still adhere to standard
 * graph properties for genericized {@link Graph} creation.
 */
public interface Node<T, U extends Comparable<?>> {

  /**
   * Retrieves the data associated with a particular {@link Node}
   * @return U {@link Node#getNodeData()}
   */
  U getNodeData();

  /**
   * Retrieves the name value for a particular {@link Node}
   * @return T {@link Node#getNodeName()}
   */
  T getNodeName();

  int getVal();

  /**
   * Gets all metadata for a particular {@link Node}
   * @return Map of node metadata
   */
  Map<String, Object> getProps();

  /**
   * Allows retrieval of a value on a particular {@link Node} {@link String} key
   * @return
   */
  Object retrieveProp(String key);

  /**
   * Adds a directed edge connection to a destination {@link Node} with a specified weight
   * @param destinationNode
   * @param weight
   */
  void addConnection(Node destinationNode, double weight);

  /**
   * Adds a connection to a given {@link Node} and a default weight will be given
   * @param destinationNode
   */
  void addConnection(Node destinationNode);

  /**
   * Retrieves a weight for a given {@link Node}
   * @param destinationNode
   * @return the weight between two nodes
   */
  double getEdgeWeight(Node destinationNode);

  /**
   * Enables adding N number of directed edges to a given {@link Node} with a constant weight
   * @param weight
   * @param childNodes
   */
  void bulkAddConnections(int weight, Node ... childNodes);

  /**
   * Enables adding N number of directed edges to a given {@link Node} with a default weight of 0
   * @param childNodes
   */
  void bulkAddConnections(Node ... childNodes);

  /**
   * Enables adding N number of directed edges to a given {@link Node} with a default weight of 0
   * @param childNodes
   */
  void bulkAddConnections(List<Node> childNodes);

  /**
   * Enables adding N number of directed edges to a given {@link Node} with a constant weight
   * @param weight
   * @param childNodes
   */
  void bulkAddConnections(int weight, List<Node> childNodes);

  /**
   * Retrieves all adjacent nodes for a given {@link Node}
   * @return node list
   */
  List<Node<String, Integer>> getAdjacentNodes();

  /**
   * Deletes an edge connection
   * @param destinationNode
   */
  void removeConnection(Node destinationNode);

  /**
   * Used for binary trees
   * @param left
   */
  void addLeftChild(Node left);

  /**
   * Used for binary trees
   * @param right
   */
  void addRightChild(Node right);

  /**
   * Used for retrieving right child in a binary tree
   * @return
   */
  Node getRight();

  /**
   * Used for retrieving left child in a binary tree
   * @return
   */
  Node getLeft();
}
