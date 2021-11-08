package com.luxoft.datastructures.queue.linked;

import com.luxoft.datastructures.queue.Queue;

import java.util.StringJoiner;

public class LinkedQueue implements Queue {
    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        resetHeadAndTail();
    }

    @Override
    public void enqueue(Object value) {
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        Node next = tail.getNext();
        Node current = new Node(value, tail, next);
        next.setPrevious(current);
        tail.setNext(current);
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Node current = head.getPrevious();
        Node previous = current.getPrevious();
        previous.setNext(head);
        head.setPrevious(previous);
        size--;
        return current.getData();
    }

    @Override
    public Object peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.getPrevious().getData();
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
        if(value == null) {
            throw new NullPointerException("Null is not supported");
        }

        for(Node current = tail.getNext(); current.getNext() != null; current = current.getNext()) {
            if(current.getData().equals(value)) {
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
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for(Node current = head.getPrevious(); current.getPrevious() != null; current = current.getPrevious()) {
            result.add(current.getData().toString());
        }
        return result.toString();
    }

    private void resetHeadAndTail() {
        tail = new Node();
        head = new Node();

        head.setPrevious(tail);
        tail.setNext(head);
    }
}
