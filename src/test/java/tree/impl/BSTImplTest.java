package tree.impl;

import common.api.Node;
import common.impl.NodeImpl;
import org.junit.Test;
import tree.api.BST;

import static org.junit.Assert.*;

public class BSTImplTest {

    @Test
    public void insert() {
        BST bst = new BSTImpl(10);
        Node root = ((BSTImpl) bst).autoGenerate(10);
        IOT(root);
    }

    public void IOT(Node root) {
        if (root != null) {
            IOT(root.getLeft());
            System.out.println(root.getVal());
            IOT(root.getRight());
        }
    }
}