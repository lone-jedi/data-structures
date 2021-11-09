package com.luxoft.datastructures.list.linked;

import com.luxoft.datastructures.list.AbstractList;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {
    private Node tail;
    private Node head;

    public LinkedList() {
        tail = new Node();
        head = new Node();
        tail.setNext(head);
        head.setPrevious(tail);
    }

    @Override
    public void add(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null is not supported in LinkedList.add(). First argument is null");
        }

        Node current = index == size ? head : getNode(index);
        Node previous = current.getPrevious();
        Node newNode = new Node(value, previous, current);
        current.setPrevious(newNode);
        previous.setNext(newNode);
        size++;
    }

    @Override
    public Object remove(int index) {
        Node value = getNode(index);
        Node previous = value.getPrevious();
        Node next = value.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
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
        Node previous = oldValue.getPrevious();
        Node next = oldValue.getNext();
        Node newValue = new Node(value, previous, next);
        previous.setNext(newValue);
        next.setPrevious(newValue);
        return oldValue;
    }

    @Override
    public void clear() {
        head.setPrevious(tail);
        tail.setNext(head);
        size = 0;
    }

    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        int i = 0;
        Node current = tail.getNext();
        while(current.getNext() != null) {
            if(current.getData().equals(value)) {
                return i;
            }
            current = current.getNext();
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
        Node current = head.getPrevious();
        while(current.getPrevious() != null) {
            if(current.getData().equals(value)) {
                return i;
            }
            current = current.getPrevious();
            i--;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner string = new StringJoiner(", ", "[", "]");
        Node current = tail;
        for (int i = 0; i < size; i++) {
            current = current.getNext();
            string.add(current.getData().toString());
        }
        return string.toString();
    }

    private Node getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound [0, " + size + "]");
        }

        if(index > size / 2) {
            return getNodeFromHead(index);
        }

        return getNodeFromTail(index);
    }

    private Node getNodeFromTail(int index) {
        int i = -1;
        Node current = tail;
        while(current.getNext() != null) {
            if(index == i) {
                return current;
            }
            current = current.getNext();
            i++;
        }
        return current;
    }

    private Node getNodeFromHead(int index) {
        int i = size;
        Node current = head;
        while(current.getPrevious() != null) {
            if(index == i) {
                return current;
            }
            current = current.getPrevious();
            i--;
        }
        return current;
    }
}