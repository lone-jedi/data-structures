package com.luxoft.datastructures.list.array;

import com.luxoft.datastructures.list.AbstractList;

public class ArrayList extends AbstractList {
    private Object[] arrayList;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("ArrayList size must be greater or equals to zero");
        }
        arrayList = new Object[size];
    }

    @Override
    public void add(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        if(size >= arrayList.length) {
            ensureCapacity();
        }

        for (int i = size; i > index; --i) {
            arrayList[i] = arrayList[i - 1];
        }

        arrayList[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        Object result = arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
        arrayList[--size] = null;
        return result;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }
        return arrayList[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if(index < 0 || index >= size) {
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
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        for (int i = 0; i < size; i++) {
            if(arrayList[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if(isEmpty()) {
            return -1;
        }

        for (int i = size - 1; i >= 0; --i) {
            if(arrayList[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    private void ensureCapacity() {
        Object[] newArrayList = new Object[(int) ((arrayList.length == 0 ? 2 : arrayList.length) * 1.5)];
        System.arraycopy(arrayList, 0, newArrayList, 0, arrayList.length);
        arrayList = newArrayList;
    }
}
