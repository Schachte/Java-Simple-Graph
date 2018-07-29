package graph.example;

import common.api.Graph;
import common.api.Node;
import graph.impl.GraphImpl;
import common.impl.NodeImpl;
import java.util.ArrayList;
import java.util.List;

public class GraphAPIExample {
  public static void main(String[] args) {

    // Init graph
    Graph g = new GraphImpl();

    // Creating Custom Nodes (Name, Value)
    Node<String, Integer> node1 = new NodeImpl("A", 1);
    Node<String, Integer> node2 = new NodeImpl("B", 1);
    Node<String, Integer> node3 = new NodeImpl("C", 1);
    Node<String, Integer> node4 = new NodeImpl("D", 1);
    Node<String, Integer> node5 = new NodeImpl("E", 1);

    // Creating a list of nodes to bulk add
    List<Node> nodeArryList = new ArrayList<>();
    nodeArryList.add(new NodeImpl("F", 1));
    nodeArryList.add(new NodeImpl("G", 1));
    nodeArryList.add(new NodeImpl("H", 1));

    // Adding bulk directed connections
    node1.bulkAddConnections(node2, node3, node4, node5);
    node2.bulkAddConnections(node3, node4, node5);
    node3.bulkAddConnections(nodeArryList);
    node3.addConnection(node1);

    // Adding nodes to the graph
    g.addNode(node1);
    g.addNode(node2);
    g.addNode(node3);

    // Printing the node name data from the graph
    System.out.println("\nExample of printing graph nodes");
    g.getAllNodes()
        .stream()
        .map(Node::getNodeName)
        .forEach(System.out::println);

    // Printing the node adjacent nodes
    System.out.println("\nExample of printing adjacent nodes to a node object");
    node1.getAdjacentNodes()
        .stream()
        .map(Node::getNodeName)
        .forEach(System.out::println);
  }
}
