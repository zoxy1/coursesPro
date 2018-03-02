package collections.set;

import collections.list.LinkedListForCourse;
import java.util.Iterator;

public class SimpleLinkSet<T> {
    private LinkedListForCourse<T> linkedList = new LinkedListForCourse<>();

    public void add(T e) {
        for (T item : linkedList) {
            if (e.equals(item)) {
                return;
            }
        }
        linkedList.add(e);
    }

    public Iterator iterator() {
        return linkedList.iterator();
    }
}
