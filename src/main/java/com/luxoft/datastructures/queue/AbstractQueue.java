package com.luxoft.datastructures.queue;

import java.util.Iterator;
import java.util.StringJoiner;

public abstract class AbstractQueue<T> implements Queue<T>, Iterable<T> {
    @Override
    public abstract void enqueue(T value);

    @Override
    public abstract T dequeue();

    @Override
    public abstract T peek();

    @Override
    public abstract int size();

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T value) {
        if (value == null) {
            throw new NullPointerException("Null values are not supported");
        }

        for (T current : this) {
            if (current.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public abstract void clear();

    @Override
    public abstract Iterator iterator();

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (T o : this) {
            result.add(o.toString());
        }
        return result.toString();
    }
}
