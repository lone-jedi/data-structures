package com.luxoft.datastructures.queue;

public class ArrayQueue implements Queue {
    private int rear;
    private int front;
    private Object[] arrayQueue;

    public ArrayQueue() {
        arrayQueue = new Object[100];
    }

    public ArrayQueue(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("Size of queue must be more or equal zero");
        }

        arrayQueue = new Object[size];
    }

    @Override
    public void enqueue(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not supported");
        }

        if(arrayQueue.length == rear) {
            expandSize();
        }

        arrayQueue[rear++] = value;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Try to dequeue value from empty queue");
        }

        return arrayQueue[front++];
    }

    @Override
    public Object peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Try to peek value from empty queue");
        }

        return arrayQueue[front];
    }

    @Override
    public int size() {
        return rear - front;
    }

    @Override
    public boolean isEmpty() {
        return rear <= front;
    }

    @Override
    public boolean contains(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not supported");
        }

        for (int i = front; i < rear; ++i) {
            if(arrayQueue[i].equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        int i = front;
        while(i < rear - 1) {
            result.append(arrayQueue[i++]);
            result.append(", ");
        }

        if(i + 1 == rear) {
            result.append(arrayQueue[i]);
        }

        result.append("]");

        return result.toString();
    }
    
    private void expandSize() {
        Object[] newArrayQueue = new Object[(arrayQueue.length == 0 ? 1 : arrayQueue.length) * 2];

        for (int i = front, counter = 0; i < rear; ++i, ++counter) {
            newArrayQueue[counter] = arrayQueue[i];
        }

        rear = size();
        front = 0;
        arrayQueue = newArrayQueue;
    }
}
