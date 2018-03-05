package collections.Generic;

import java.util.Arrays;

public class SimpleArray<T> {
    private Object[] array;
    private int size = 0;

    public SimpleArray() {
        this.array = new Object[16];
    }

    public SimpleArray(Object[] array) {
        this.array = array;
        size = array.length;
    }

    public Boolean add(T model) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = model;
        return true;
    }

    public void set(int index, T model) {
        rangeCheck(index);
        array[index] = model;
    }

    public T delete(int index) {
        rangeCheck(index);
        T oldValue = (T) array[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[size - 1] = null;
        size--;
        return oldValue;

    }

    public T get(int index) {
        rangeCheck(index);
        return (T) array[index];
    }

    private void rangeCheck(int index) {
        if (index > (size - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Max index is: " + (size - 1));
        }
    }

    public int size() {
        return size;
    }
}
