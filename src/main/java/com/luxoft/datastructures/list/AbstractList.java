package com.luxoft.datastructures.list;

public abstract class AbstractList implements List {
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
        return size <= 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public abstract int indexOf(Object value);

    @Override
    public abstract int lastIndexOf(Object value);
}
