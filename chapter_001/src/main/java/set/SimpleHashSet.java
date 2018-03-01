package set;

public class SimpleHashSet<T> {
    private int capacity = 16;
    private Object[] basket = new Object[capacity];
    private final float LOAD_FACTOR = 0.75f;
    private int size = 0;

    public boolean add(T e) {
        int hashCode = 0;
        if (e != null) {

            hashCode = e.hashCode();
        }
        if (++size > (int) (capacity * LOAD_FACTOR)) {
            Object[] basketNew = new Object[basket.length * 2];
            capacity = capacity * 2;
            for (int i = 0; i < size; i++) {
                if (basket[i] != null) {
                    basketNew[hashCodeToIndex(basket[i].hashCode())] = basket[i];
                }
            }
            basket = basketNew;
        }
        basket[hashCodeToIndex(hashCode)] = e;
        return true;
    }

    public boolean contains(T e) {
        if (basket[hashCodeToIndex(e.hashCode())] != null) {
            return true;
        }
        return false;
    }

    public boolean remove(T e) {
        if (contains(e)) {
            basket[hashCodeToIndex(e.hashCode())] = null;
            return true;
        }
        return false;
    }

    private int hashCodeToIndex(int hashCode) {
        return hashCode == 0 ? 0 : (hashCode & (capacity - 1)) % capacity;
    }
}
