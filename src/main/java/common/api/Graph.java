package common.api;

import java.util.List;

/**
 * Root data structure that may contain N or more {@link Node}s
 * connected by a series of edges.
 */
public interface Graph {

  /**
   * Gets all the {@link Node}s in the form of a {@link List}
   * @return node list for the current graph instance
   */
  List<Node> getAllNodes();

  /**
   * Retrieves the root {@link Node} for traversals and search
   * @return root graph node
   */
  Node getRoot();

  /**
   * The the initial root {@link Node} for traversals and search
   * @param root
   */
  void setRootNode(Node root);

  /**
   * Finds a given {@link Node} by the name
   * @param node
   * @return Node
   */
  Node findNode(String node);

  /**
   * Finds a given {@link Node} by the value
   * @param node
   * @return
   */
  Node findNode(int node);

  /**
   * Adds a singular {@link Node} to a {@link Graph}
   * @param node
   */
  void addNode(Node node);

  /**
   * Adds a variable number of {@link Node}s to the {@link Graph}
   * @param nodes
   */
  void addNodes(Node ... nodes);

  /**
   * Adds a bulk set of nodes to the {@link Graph} from a {@link List}
   * @param nodes
   */
  void addNodes(List<Node> nodes);

  /**
   * Deletes a node from the graph
   * @param node
   */
  void removeNode(Node node);

  /**
   * Prints the node values level-order
   */
  void levelOrderPrint();

  /**
   * Prints the node values pre-order
   */
  void preOrderPrint();

  /**
   * Prints the node value post-order
   */
  void postOrderPrint();

  /**
   * Prints the node values in-order
   */
  void inOrderPrint();
}
