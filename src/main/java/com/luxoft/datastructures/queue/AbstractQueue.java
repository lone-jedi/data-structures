package com.luxoft.datastructures.queue;

import java.util.Iterator;
import java.util.StringJoiner;

public abstract class AbstractQueue implements Queue, Iterable {
    @Override
    public abstract void enqueue(Object value);

    @Override
    public abstract Object dequeue();

    @Override
    public abstract Object peek();

    @Override
    public abstract int size();

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException("Null values are not supported");
        }

        for (Object current : this) {
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
        for (Object o : this) {
            result.add(o.toString());
        }
        return result.toString();
    }
}
