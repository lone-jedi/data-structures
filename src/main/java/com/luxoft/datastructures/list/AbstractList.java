package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public abstract class AbstractList implements List, Iterable {
    protected int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public abstract void add(Object value, int index);

    @Override
    public abstract Object remove(int index);

    @Override
    public abstract Object get(int index);

    @Override
    public abstract Object set(Object value, int index);

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
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }

        int index = 0;
        for (Object current : this) {
            if(current.equals(value)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public abstract int lastIndexOf(Object value);

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
