package collections.iterator;

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
        return (nextEvenValue(IndexUp.NO) != null);
    }

    @Override
    public Integer next() {
        Integer value = nextEvenValue(IndexUp.YES);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    private Integer nextEvenValue(IndexUp indexUp) {
        Integer value = null;
        if (values.length > index) {
            for (int i = index; i < values.length; i++) {
                if (indexUp == IndexUp.YES) {
                    index++;
                }
                if (values[i] % 2 == 0) {
                    value = values[i];
                    break;
                }
            }
        }
        return value;
    }
}
