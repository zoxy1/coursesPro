package set;

import list.DynamicList;
import list.SimpleContainer;

import java.util.Iterator;

public class SimpleSet<T> {
    private SimpleContainer<T> simpleContainer = new DynamicList<>();

    public Boolean add(T model) {
        for (T item : simpleContainer) {
            if (model.equals(item)) {
                return false;
            }
        }
        simpleContainer.add(model);
        return true;
    }

    public Iterator iterator() {
        return simpleContainer.iterator();
    }
}
