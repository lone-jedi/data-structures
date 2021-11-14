package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public abstract class AbstractList<T> implements List<T>, Iterable<T> {
    protected int size;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public abstract void add(T value, int index);

    @Override
    public abstract T remove(int index);

    @Override
    public abstract T get(int index);

    @Override
    public abstract T set(T value, int index);

    @Override
    public abstract void clear();

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }

        int index = 0;
        for (T current : this) {
            if(current.equals(value)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public abstract int lastIndexOf(T value);

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
