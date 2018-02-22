package list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<T> implements SimpleContainer<T> {
    private int modCount = 0;
    private Object[] container = new Object[10];
    private int size = 0;

    public DynamicList(Object[] container) {
        this.container = container;
        size = container.length;
    }

    public DynamicList() {
    }

    @Override
    public void add(T model) {
        if (size >= container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return (T) container[index];
    }

    private void rangeCheck(int index) {
        if (index > (size - 1) || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Max index is: " + (size - 1));
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModification();
                Boolean isFound = false;
                if (container.length > index) {
                    isFound = true;
                }
                return isFound;
            }

            @Override
            public T next() {
                checkModification();
                T value;
                if (hasNext() == false) {
                    throw new NoSuchElementException();
                } else {
                    value = (T) container[index++];
                }
                return value;
            }

            private void checkModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
