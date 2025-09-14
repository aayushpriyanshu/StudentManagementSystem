package com.infosys.sms.dsa;

public class ScoreBST {
    private static class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }

    private Node root;

    public void insert(int k) { root = insertRec(root, k); }

    private Node insertRec(Node n, int k) {
        if (n == null) return new Node(k);
        if (k < n.key) n.left = insertRec(n.left, k);
        else if (k > n.key) n.right = insertRec(n.right, k);
        return n;
    }

    public boolean contains(int k) {
        Node c = root;
        while (c != null) {
            if (k == c.key) return true;
            c = (k < c.key) ? c.left : c.right;
        }
        return false;
    }

    public Integer min() {
        Node c = root;
        if (c == null) return null;
        while (c.left != null) c = c.left;
        return c.key;
    }

    public Integer max() {
        Node c = root;
        if (c == null) return null;
        while (c.right != null) c = c.right;
        return c.key;
    }
}
