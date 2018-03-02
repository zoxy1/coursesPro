package collections.list;

public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);
    E get(int index);
}
