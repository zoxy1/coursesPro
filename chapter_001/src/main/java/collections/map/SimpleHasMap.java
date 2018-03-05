package collections.map;

import java.util.*;

/**
 * Created by Zoxy1 on 05.03.18.
 */
public class SimpleHasMap<K, V> implements Iterable<V> {
    private int capacity = 16;
    private Object[] keys = new Object[capacity];
    private Object[] values = new Object[capacity];
    private final float LOAD_FACTOR = 0.75f;
    private int size = 0;
    private Boolean keyHasNull = false;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        if (key == null) {
            resizeCheck();
            keys[0] = key;
            values[0] = value;
            size++;
            modCount++;
            keyHasNull = true;
            return true;
        }
        if (containsKey(key)) {
            return false;
        }
        resizeCheck();
        keys[getIndex(key)] = key;
        values[getIndex(key)] = value;
        size++;
        modCount++;
        return true;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            if (keyHasNull) {
                return true;
            }
            return false;
        }
        if (Objects.equals(keys[getIndex(key)], key)) {
            return true;
        }
        return false;
    }

    public V get(K key) {
        if (key == null) {
            return (V) values[0];
        }
        if (containsKey(key)) {
            return (V) values[getIndex(key)];
        }
        return null;
    }

    public boolean delete(K key) {
        if (key == null) {
            keys[0] = null;
            values[0] = null;
            keyHasNull = false;
            modCount++;
            return true;
        }
        if (containsKey(key)) {
            int index = getIndex(key);
            keys[index] = null;
            values[index] = null;
            modCount++;
            return true;
        }
        return false;
    }

    private void resizeCheck() {
        if (size > (int) (capacity * LOAD_FACTOR)) {
            Object[] keysNew = new Object[keys.length * 2];
            Object[] valuesNew = new Object[values.length * 2];
            capacity = capacity * 2;
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null) {
                    keysNew[0] = keys[i];
                    valuesNew[0] = values[i];
                } else {
                    int index = hashCodeToIndex(keys[i].hashCode());
                    keysNew[index] = keys[i];
                    valuesNew[index] = values[i];
                }
            }
            keys = keysNew;
            values = valuesNew;
        }
    }

    private int hashCodeToIndex(int hashCode) {
        return hashCode == 0 ? 0 : (hashCode ^ (hashCode >>> 16)) & (capacity - 1);
    }

    private int getIndex(K key) {
        return hashCodeToIndex(key == null ? 0 : key.hashCode());
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
                if (index == 0 && keyHasNull) {
                    isFound = true;
                } else {
                    for (int i = index; i < values.length; i++) {
                        if (values[i] != null) {
                            isFound = true;
                        }
                    }
                }
                return isFound;
            }

            @Override
            public V next() {
                checkModification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (index == 0) {
                    return (V) values[index++];
                }
                for (int i = index; i < values.length; i++) {
                    if (values[i] != null) {
                        index = i + 1;
                        return (V) values[i];
                    }
                }
                return null;
            }

            private void checkModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
