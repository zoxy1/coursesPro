package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator<T> implements Iterator<T> {
    private T[][] arrays;
    private int row = 0;
    private int col = 0;

    public MatrixIterator(T[][] arrays) {
        this.arrays = arrays;
    }

    @Override
    public boolean hasNext() {
        return (row < arrays.length) && (col < arrays[row].length);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T currentValue = arrays[row][col];
        col++;
        if (col >= arrays[row].length) {
            row++;
            col = 0;
        }
        return currentValue;
    }
}
