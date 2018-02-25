package list;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Zoxy1 on 25.02.18.
 */
public class SimpleStack<T> {
    LinkedListForCourse<T> list = new LinkedListForCourse<>();

    public T poll() {
        return list.removeLast();
    }

    public void push(T value) {
        list.add(value);
    }
}

