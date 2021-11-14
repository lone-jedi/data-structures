package com.luxoft.datastructures.queue.linked;

import com.luxoft.datastructures.list.linked.LinkedList;
import com.luxoft.datastructures.queue.AbstractQueue;

import java.util.Iterator;

public class LinkedQueue<T> extends AbstractQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        resetHeadAndTail();
    }

    @Override
    public void enqueue(T value) {
        if (value == null) {
            throw new NullPointerException("Null is not supported");
        }

        Node<T> next = tail.next;
        Node<T> current = new Node(value, tail, next);
        next.previous = current;
        tail.next = current;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Node<T> current = head.previous;
        Node<T> previous = current.previous;
        previous.next = head;
        head.previous = previous;
        size--;
        return current.data;
    }

    @Override
    public T peek() {
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
    public void clear() {
        resetHeadAndTail();
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head.previous;

        @Override
        public boolean hasNext() {
            return !current.equals(tail);
        }

        @Override
        public T next() {
            current = current.previous;
            return current.next.data;
        }

        @Override
        public void remove() {
            Node<T> previous = current.previous;
            Node<T> next = current.next;
            previous.next = next;
            next.previous = previous;
            current = previous;
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

    private void resetHeadAndTail() {
        tail = new Node<T>();
        head = new Node<T>();

        head.previous = tail;
        tail.next = head;
    }
}
