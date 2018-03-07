package collections.map;

import java.util.*;

/**
 * Created by Zoxy1 on 05.03.18.
 */
public class SimpleHasMap<K, V> implements Iterable<V> {
    private int capacity = 16;
    private Entry[] entries = new Entry[capacity];
    private final float LOAD_FACTOR = 0.75f;
    private int size = 0;
    private Boolean keyHasNull = false;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        if (key == null) {
            resizeCheck();
            entries[0] = new Entry(key, value);
            size++;
            modCount++;
            keyHasNull = true;
            return true;
        }
        if (containsKey(key)) {
            return false;
        }
        resizeCheck();
        entries[getIndex(key)] = new Entry(key, value);
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
        K keyCompare = entries[getIndex(key)] == null ? null : (K) entries[getIndex(key)].getKey();
        if (Objects.equals(keyCompare, key)) {
            return true;
        }
        return false;
    }

    public V get(K key) {
        if (key == null) {
            return (V) entries[0].getValue();
        }
        if (containsKey(key)) {
            return (V) entries[getIndex(key)].getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        if (key == null) {
            entries[0] = null;
            keyHasNull = false;
            modCount++;
            return true;
        }
        if (containsKey(key)) {
            int index = getIndex(key);
            entries[index] = null;
            modCount++;
            return true;
        }
        return false;
    }

    private void resizeCheck() {
        if (size > (int) (capacity * LOAD_FACTOR)) {
            Entry[] entriesNew = new Entry[entries.length * 2];
            capacity = capacity * 2;
            for (int i = 0; i < entries.length; i++) {
                if (entries[i] == null) {
                    continue;
                }
                if (entries[i].getKey() == null) {
                    entriesNew[0] = entries[i];
                } else {
                    int index = hashCodeToIndex(entries[i].getKey().hashCode());
                    entriesNew[index] = entries[i];
                }
            }
            entries = entriesNew;
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
                    for (int i = index; i < entries.length; i++) {
                        if (entries[i] != null && entries[i].getValue() != null) {
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
                    return (V) entries[index++].getValue();
                }
                for (int i = index; i < entries.length; i++) {
                    if (entries[i] != null && entries[i].getValue() != null) {
                        index = i + 1;
                        return (V) entries[i].getValue();
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
