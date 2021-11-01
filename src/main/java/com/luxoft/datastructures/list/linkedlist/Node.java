package com.luxoft.datastructures.list.linkedlist;

public class Node {
    private Object data;
    private Node parent;
    private Node child;

    public Node() {}

    public Node(Object data, Node parent, Node child) {
        this.data = data;
        this.parent = parent;
        this.child = child;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }
}
