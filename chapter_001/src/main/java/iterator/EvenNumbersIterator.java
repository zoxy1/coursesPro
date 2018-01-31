package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private int[] values;
    private int index = 0;

    public EvenNumbersIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        Boolean isFound = false;

        if (values.length > index) {
            for (int i = index; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    isFound = true;
                }
            }
        }
        return isFound;
    }

    @Override
    public Integer next() {
        Integer value = null;

        for (int i = index; i < values.length; i++) {
            index++;
            if (values[i] % 2 == 0) {
                value = values[i];
                break;
            }
        }
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }
}
