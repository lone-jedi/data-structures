package com.luxoft.datastructures.list.array;

import com.luxoft.datastructures.list.AbstractList;

import java.util.Iterator;

public class ArrayList extends AbstractList {
    public static final int INITIAL_CAPACITY = 10;
    public static final double ENSURE_CAPACITY_RATE = 1.5;

    private Object[] arrayList;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    public ArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("ArrayList size must be greater or equals to zero");
        }
        arrayList = new Object[size];
    }

    @Override
    public void add(Object value, int index) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        if (size >= arrayList.length) {
            ensureCapacity();
        }

        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        Object result = arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
        arrayList[--size] = null;
        return result;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }
        return arrayList[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        Object result = arrayList[index];
        arrayList[index] = value;
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayList[i] = null;
        }
        size = 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if (isEmpty()) {
            return -1;
        }

        for (int i = size - 1; i >= 0; --i) {
            if (arrayList[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return size != index;
        }

        @Override
        public Object next() {
            return arrayList[index++];
        }

        public void remove() {
            ArrayList.this.remove(index);
        }
    }

    private void ensureCapacity() {
        Object[] newArrayList = new Object[
                (int) ((arrayList.length == 0 ? 2 : arrayList.length) * ENSURE_CAPACITY_RATE)];
        System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length);
        arrayList = newArrayList;
    }
}
