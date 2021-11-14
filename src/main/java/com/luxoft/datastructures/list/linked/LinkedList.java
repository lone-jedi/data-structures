package com.luxoft.datastructures.list.linked;

import com.luxoft.datastructures.list.AbstractList;

import java.util.Iterator;

public class LinkedList extends AbstractList {
    private Node tail;
    private Node head;

    public LinkedList() {
        tail = new Node();
        head = new Node();
        tail.next = head;
        head.previous = tail;
    }

    @Override
    public void add(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null is not supported in LinkedList.add(). First argument is null");
        }

        Node current = index == size ? head : getNode(index);
        Node previous = current.previous;
        Node newNode = new Node(value, previous, current);
        current.previous = newNode;
        previous.next = newNode;
        size++;
    }

    @Override
    public Object remove(int index) {
        Node value = getNode(index);
        Node previous = value.previous;
        Node next = value.next;
        previous.next = next;
        next.previous = previous;
        size--;
        return value.data;
    }

    @Override
    public Object get(int index) {
        return getNode(index).data;
    }

    @Override
    public Object set(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        Node oldValue = getNode(index);
        Node previous = oldValue.previous;
        Node next = oldValue.next;
        Node newValue = new Node(value, previous, next);
        previous.next = newValue;
        next.previous = newValue;
        return oldValue;
    }

    @Override
    public void clear() {
        head.previous = tail;
        tail.next = head;
        size = 0;
    }

    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        int i = 0;
        Node current = tail.next;
        while(current.next != null) {
            if(current.data.equals(value)) {
                return i;
            }
            current = current.next;
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
        Node current = head.previous;
        while(current.previous != null) {
            if(current.data.equals(value)) {
                return i;
            }
            current = current.previous;
            i--;
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator{
        private Node current = tail.next;

        @Override
        public boolean hasNext() {
            return !current.equals(head);
        }

        @Override
        public Object next() {
            current = current.next;
            return current.previous.data;
        }

        @Override
        public void remove() {
            Node previous = current.previous;
            Node next = current.next;
            previous.next = next;
            next.previous = previous;
            current = next;
        }
    }

    private static class Node {
        Object data;
        Node previous;
        Node next;
        
        Node() {}
        
        Node(Object data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
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
        while(current.next != null) {
            if(index == i) {
                return current;
            }
            current = current.next;
            i++;
        }
        return current;
    }

    private Node getNodeFromHead(int index) {
        int i = size;
        Node current = head;
        while(current.previous != null) {
            if(index == i) {
                return current;
            }
            current = current.previous;
            i--;
        }
        return current;
    }
}