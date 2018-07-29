package common.api;

/**
 * Represents the directed link between two {@link Node} objects and may contain
 * and optional weight. Used in many search algorithms, traversal problems.
 */
public interface Edge {

  /**
   * Gets the weight between two {@link Node}s
   * @return node weight
   */
  double getWeight();

  /**
   * Gets the {@link Node} that a source is pointing to
   * @return node destination
   */
  Node getDestination();
}
