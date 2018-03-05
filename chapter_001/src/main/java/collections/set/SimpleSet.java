package collections.set;

import collections.list.DynamicList;
import collections.list.SimpleContainer;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleContainer<T> simpleContainer = new DynamicList<>();

    public Boolean add(T model) {
        if (contains(model)) {
            return false;
        }
        simpleContainer.add(model);
        return true;
    }

    @Override
    public Iterator iterator() {
        return simpleContainer.iterator();
    }

    private Boolean contains(T model) {
        for (T item : simpleContainer) {
            if (model.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
