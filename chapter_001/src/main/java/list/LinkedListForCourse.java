package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListForCourse<T> implements SimpleContainer<T> {
    private Node<T> first;
    private Node<T> last;
    private int modCount = 0;
    private int size = 0;

    @Override
    public void add(T e) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T item;
        if (index < (size / 2)) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            item = node.item;
        } else {
            Node<T> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            item = node.item;
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> lastReturned;
            private Node<T> next = first;
            private int nextIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.item;
            }
        };
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
