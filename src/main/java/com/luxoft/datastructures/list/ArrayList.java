package com.luxoft.datastructures.list;

public class ArrayList implements List{
    private int head;
    private Object[] arrayList;

    public ArrayList() {
        arrayList = new Object[10000];
    }

    @Override
    public void add(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }
        arrayList[head++] = value;
    }

    @Override
    public void add(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if(index < 0 || index >= head) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        for (int i = head; i > index; --i) {
            arrayList[i] = arrayList[i - 1];
        }

        arrayList[index] = value;
    }

    @Override
    public Object remove(int index) {
        if(index < 0 || index >= head) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        Object result = arrayList[index];

        for (int i = index; i < head - 1; ++i) {
            arrayList[i] = arrayList[i + 1];
        }

        arrayList[--head] = null;

        return result;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= head) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }
        return arrayList[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if(index < 0 || index >= head) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        Object result = arrayList[index];
        arrayList[index] = value;
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < head; i++) {
            arrayList[i] = null;
        }
        head = 0;
    }

    @Override
    public int size() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return head == 0;
    }

    @Override
    public boolean contains(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        for (int i = 0; i < head; i++) {
            if(arrayList[i].equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(Object value) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        for (int i = 0; i < head; i++) {
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

        for (int i = head - 1; i >= 0; --i) {
            if(arrayList[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
}
