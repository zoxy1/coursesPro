package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    private Iterator<Integer> currentIterator;
    private Boolean firstIterate = true;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private void saveIteratorIfFirstIterate() {
                if (firstIterate && it.hasNext()) {
                    currentIterator = it.next();
                    firstIterate = false;
                }
            }

            @Override
            public boolean hasNext() {
                Boolean isFound = false;

                saveIteratorIfFirstIterate();
                if (currentIterator != null && currentIterator.hasNext()) {
                    isFound = true;
                } else {
                    while (it.hasNext()) {
                        currentIterator = it.next();
                        if (currentIterator != null && currentIterator.hasNext()) {
                            isFound = true;
                            break;
                        }
                    }
                }
                return isFound;
            }

            @Override
            public Integer next() {
                Integer value = null;

                saveIteratorIfFirstIterate();
                if (currentIterator != null && currentIterator.hasNext()) {
                    value = currentIterator.next();
                } else {
                    while (it.hasNext()) {
                        currentIterator = it.next();
                        if (currentIterator != null && currentIterator.hasNext()) {
                            value = currentIterator.next();
                            break;
                        }
                    }
                }
                if (value == null) {
                    throw new NoSuchElementException();
                }
                return value;
            }
        };
    }
}