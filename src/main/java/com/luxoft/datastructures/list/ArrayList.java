package com.luxoft.datastructures.list;

public class ArrayList implements List{
    private int head;
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
    public void add(Object value) {
        add(value, head);
    }

    @Override
    public void add(Object value, int index) {
        if(value == null) {
            throw new NullPointerException("Null values are not support");
        }

        if(index < 0 || index > head) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }

        if(head >= arrayList.length) {
            resize();
        }

        for (int i = head; i > index; --i) {
            arrayList[i] = arrayList[i - 1];
        }

        arrayList[index] = value;

        head++;
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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");

        int i = 0;

        while(i < head - 1) {
            string.append(arrayList[i++]);
            string.append(", ");
        }

        if(i == head - 1) {
            string.append(arrayList[i]);
        }

        string.append("]");

        return string.toString();
    }

    private void resize() {
        Object[] newArrayList = new Object[(int) ((arrayList.length == 0 ? 2 : arrayList.length) * 1.5)];

        for (int i = 0; i < arrayList.length; i++) {
            newArrayList[i] = arrayList[i];
        }

        arrayList = newArrayList;
    }
}
