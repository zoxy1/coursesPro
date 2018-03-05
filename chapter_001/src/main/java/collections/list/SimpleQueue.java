package collections.list;

/**
 * Created by Zoxy1 on 25.02.18.
 */
public class SimpleQueue<T> {
    LinkedListForCourse<T> list = new LinkedListForCourse<>();

    public T poll() {
        return list.removeFirst();
    }

    public void push(T value) {
        list.add(value);
    }
}

