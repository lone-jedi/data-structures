package com.luxoft.datastructures.queue.linked;

import com.luxoft.datastructures.queue.AbstractQueue;

import java.util.Iterator;

public class LinkedQueue extends AbstractQueue {
    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        resetHeadAndTail();
    }

    @Override
    public void enqueue(Object value) {
        if (value == null) {
            throw new NullPointerException("Null is not supported");
        }

        Node next = tail.next;
        Node current = new Node(value, tail, next);
        next.previous = current;
        tail.next = current;
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Node current = head.previous;
        Node previous = current.previous;
        previous.next = head;
        head.previous = previous;
        size--;
        return current.data;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.previous.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException("Null is not supported");
        }

        for (Node current = tail.next; current.next != null; current = current.next) {
            if (current.data.equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        resetHeadAndTail();
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private static class LinkedListIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    private static class Node {
        Object data;
        Node previous;
        Node next;

        Node() {
        }

        Node(Object data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    private void resetHeadAndTail() {
        tail = new Node();
        head = new Node();

        head.previous = tail;
        tail.next = head;
    }
}
