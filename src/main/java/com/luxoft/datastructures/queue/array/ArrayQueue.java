package com.luxoft.datastructures.queue.array;

import com.luxoft.datastructures.queue.AbstractQueue;

public class ArrayQueue extends AbstractQueue {
    private int rear;
    private int front;
    private Object[] arrayQueue;

    public ArrayQueue() {
        this(10);
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
            ensureCapacity();
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
    public void clear() {
        for (int i = front; i < rear; ++i) {
            arrayQueue[i] = null;
        }
        front = rear = 0;
    }

    @Override
    protected Object get(int index) {
        if(index + front >= rear) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " out of bound in ArrayList [0, " + (size() - 1) + "]");
        }
        return arrayQueue[index + front];
    }
    
    private void ensureCapacity() {
        Object[] newArrayQueue = new Object[(int)((arrayQueue.length == 0 ? 2 : arrayQueue.length) * 1.5)];

        System.arraycopy(arrayQueue, front, newArrayQueue, 0, size());

        rear = size();
        front = 0;
        arrayQueue = newArrayQueue;
    }
}
