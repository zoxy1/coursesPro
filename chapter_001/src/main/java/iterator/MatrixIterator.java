package iterator;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {
    private T[][] arrays;
    private int row = 0;
    private int col = 0;

    public MatrixIterator(T[][] arrays) {
        this.arrays = arrays;
    }

    @Override
    public boolean hasNext() {
        return (arrays.length > row) && (arrays[row].length > col);
    }

    @Override
    public T next() {
        T currentValue = arrays[row][col];

        col++;
        if (col >= arrays[row].length) {
            row++;
            col = 0;
        }
        return currentValue;
    }
}
