package tree.impl;

import common.api.Node;
import common.impl.NodeImpl;
import tree.api.BST;

import java.util.Random;

public class BSTImpl implements BST {
    private Random r = new Random();
    private Node rootVal;

    public BSTImpl(final int rootVal) {
        this.rootVal = new NodeImpl(rootVal);
    }

    /**
     * Generates a BST with N nodes between 0 & 1000
     */
    public Node autoGenerate(int numberNodes) {
        for (int i = 0; i < numberNodes; i++) {
            insert(rootVal, r.nextInt(1001));
        }
        return this.rootVal;
    }

    /**
     * Generates a BST with N nodes between X & Y
     */
    public Node autoGenerate(int numberNodes, int low, int high) {
        int result = r.nextInt(high-low) + low;
        for (int i = 0; i < numberNodes; i++) {
            insert(rootVal, result);
        }
        return this.rootVal;
    }

    public Node getRoot() {
        return this.rootVal;
    }

    /**
     * Recursively insert new node value into the tree
     */
    @Override
    public Node insert(Node root, int val) {
        if (root == null) {
            root = new NodeImpl(val);
            return root;
        }

        if (val < root.getVal()) {
            root.addLeftChild(insert(root.getLeft(), val));
        } else if (val > root.getVal()) {
            root.addRightChild(insert(root.getRight(), val));
        }

        return root;
    }
}
