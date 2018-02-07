package Generic;

public class SimpleArray<T> {
    private Object[] array = new Object[32];
    private int index = 0;
    private int size = 0;

    public SimpleArray(Object[] array) {
        this.array = array;
        size = array.length;
    }

    public SimpleArray() {
    }

    public Boolean add(T model) {
        if (index >= array.length) {
            Object[] arrayNew = new Object[(array.length * 2)];
            System.arraycopy(array, 0, arrayNew, 0, array.length);
            array = arrayNew;
        }
        array[index++] = model;
        size++;
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
        size--;
        return oldValue;

    }

    public T get(int index) {
        rangeCheck(index);
        return (T) array[index];
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Max index is: " + (size - 1));
        }
    }

    public int size() {
        return size;
    }
}
