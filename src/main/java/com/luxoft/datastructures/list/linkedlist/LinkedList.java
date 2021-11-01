package com.luxoft.datastructures.list.linkedlist;

import com.luxoft.datastructures.list.List;
import java.util.StringJoiner;

public class LinkedList implements List {
    private Node tail;
    private Node head;
    private int size;

    public LinkedList() {
        tail = new Node();
        head = new Node();
        tail.setChild(head);
        head.setParent(tail);
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null is not supported in LinkedList.add(). First argument is null");
        }

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound [0, " + size + "]");
        }

        Node current = index == size ? head : getNode(index);
        Node previous = current.getParent();
        Node newNode = new Node(value, previous, current);
        current.setParent(newNode);
        previous.setChild(newNode);
        size++;
    }

    @Override
    public Object remove(int index) {
        Node value = getNode(index);
        Node parent = value.getParent();
        Node child = value.getChild();
        parent.setChild(child);
        child.setParent(parent);
        size--;
        return value.getData();
    }

    @Override
    public Object get(int index) {
        return getNode(index).getData();
    }

    @Override
    public Object set(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        Node oldValue = getNode(index);
        Node parent = oldValue.getParent();
        Node child = oldValue.getChild();
        Node newValue = new Node(value, parent, child);
        parent.setChild(newValue);
        child.setParent(newValue);
        return oldValue;
    }

    @Override
    public void clear() {
        head.setParent(tail);
        tail.setChild(head);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        int i = 0;
        Node current = tail.getChild();
        while(current.getChild() != null) {
            if(current.getData().equals(value)) {
                return i;
            }
            current = current.getChild();
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        int i = size - 1;
        Node current = head.getParent();
        while(current.getParent() != null) {
            if(current.getData().equals(value)) {
                return i;
            }
            current = current.getParent();
            i--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner string = new StringJoiner(", ", "[", "]");
        Node current = tail;
        for (int i = 0; i < size; i++) {
            current = current.getChild();
            string.add(current.getData().toString());
        }
        return string.toString();
    }

    private Node getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound [0, " + size + "]");
        }

        int i = size;
        Node current = head;
        while(current.getParent() != null) {
            if(index == i) {
                return current;
            }
            current = current.getParent();
            i--;
        }
        return current;
    }
}