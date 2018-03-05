package collections.set;

import collections.list.LinkedListForCourse;

import java.util.Iterator;

public class SimpleLinkSet<T> implements Iterable<T> {
    private LinkedListForCourse<T> linkedList = new LinkedListForCourse<>();

    public void add(T e) {
        if (contains(e)) {
            return;
        }
        linkedList.add(e);
    }

    @Override
    public Iterator iterator() {
        return linkedList.iterator();
    }

    private Boolean contains(T model) {
        for (T item : linkedList) {
            if (model.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
