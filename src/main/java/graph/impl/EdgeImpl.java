package graph.impl;

import common.api.Edge;
import common.api.Node;

public class EdgeImpl implements Edge {

  private double weight;

  private Node destination;

  public EdgeImpl(double weight, Node destination) {
    this.weight = weight;
    this.destination = destination;
  }

  public EdgeImpl(Node destination) {
    //TODO: Make this a constant
    this.weight = 0;
    this.destination = destination;
  }

  public Node getDestination() {
    return this.destination;
  }

  public double getWeight() {
    return this.weight;
  }
}
