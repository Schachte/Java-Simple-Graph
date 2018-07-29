package tree.api;

import common.api.Node;

public interface BST {
    Node getRoot();
    Node insert(Node root, int val);
}
