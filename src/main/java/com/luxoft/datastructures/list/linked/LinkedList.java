package com.luxoft.datastructures.list.linked;

import com.luxoft.datastructures.list.AbstractList;

import java.util.Iterator;

public class LinkedList<T> extends AbstractList<T> {
    private Node<T> tail;
    private Node<T> head;

    public LinkedList() {
        tail = new Node<T>();
        head = new Node<T>();
        tail.next = head;
        head.previous = tail;
    }

    @Override
    public void add(T value, int index) {
        if (value == null) {
            throw new NullPointerException("Null is not supported in LinkedList.add(). First argument is null");
        }

        Node current = index == size ? head : getNode(index);
        Node previous = current.previous;
        Node newNode = new Node<T>(value, previous, current);
        current.previous = newNode;
        previous.next = newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> value = getNode(index);
        Node<T> previous = value.previous;
        Node<T> next = value.next;
        previous.next = next;
        next.previous = previous;
        size--;
        return value.data;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T set(T value, int index) {
        if (value == null) {
            throw new NullPointerException("Null is not supported");
        }

        Node<T> oldValue = getNode(index);
        Node<T> previous = oldValue.previous;
        Node<T> next = oldValue.next;
        Node<T> newValue = new Node<T>(value, previous, next);
        previous.next = newValue;
        next.previous = newValue;
        return oldValue.data;
    }

    @Override
    public void clear() {
        head.previous = tail;
        tail.next = head;
        size = 0;
    }

    @Override
    public int lastIndexOf(T value) {
        if (value == null) {
            throw new NullPointerException("Null is not supported");
        }

        int i = size - 1;
        Node<T> current = head.previous;
        while (current.previous != null) {
            if (current.data.equals(value)) {
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

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = tail.next;

        @Override
        public boolean hasNext() {
            return !current.equals(head);
        }

        @Override
        public T next() {
            current = current.next;
            return current.previous.data;
        }

        @Override
        public void remove() {
            Node<T> previous = current.previous;
            Node<T> next = current.next;
            previous.next = next;
            next.previous = previous;
            current = next;
        }
    }

    private static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        Node() {
        }

        Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound [0, " + size + "]");
        }

        if (index > size / 2) {
            return getNodeFromHead(index);
        }

        return getNodeFromTail(index);
    }

    private Node<T> getNodeFromTail(int index) {
        int i = -1;
        Node current = tail;
        while (current.next != null) {
            if (index == i) {
                return current;
            }
            current = current.next;
            i++;
        }
        return current;
    }

    private Node<T> getNodeFromHead(int index) {
        int i = size;
        Node current = head;
        while (current.previous != null) {
            if (index == i) {
                return current;
            }
            current = current.previous;
            i--;
        }
        return current;
    }
}