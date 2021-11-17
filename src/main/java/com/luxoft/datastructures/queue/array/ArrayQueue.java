package com.luxoft.datastructures.queue.array;

import com.luxoft.datastructures.queue.AbstractQueue;

import java.util.Iterator;

public class ArrayQueue<T> extends AbstractQueue<T> {
    private int rear;
    private int front;
    private T[] arrayQueue;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size of queue must be more or equal zero");
        }

        arrayQueue = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T value) {
        if (value == null) {
            throw new NullPointerException("Null values are not supported");
        }

        if (arrayQueue.length == rear) {
            ensureCapacity();
        }

        arrayQueue[rear++] = value;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Try to dequeue value from empty queue");
        }

        return arrayQueue[front++];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Try to peek value from empty queue");
        }

        return arrayQueue[front];
    }

    @Override
    public int size() {
        return rear - front;
    }

    @Override
    public void clear() {
        for (int i = front; i < rear; ++i) {
            arrayQueue[i] = null;
        }
        front = rear = 0;
    }

    @Override
    public Iterator iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<T> {
        private int index = front;

        @Override
        public boolean hasNext() {
            return index != rear;
        }

        @Override
        public T next() {
            return arrayQueue[index++];
        }

        @Override
        public void remove() {
            arrayQueue[index] = null;
            System.arraycopy(arrayQueue, index + 1, arrayQueue, index, rear - index);
            rear--;
        }
    }

    private void ensureCapacity() {
        T[] newArrayQueue = (T[]) new Object[(int) (arrayQueue.length * 1.5) + 1];

        System.arraycopy(arrayQueue, front, newArrayQueue, 0, size());

        rear = size();
        front = 0;
        arrayQueue = newArrayQueue;
    }
}
