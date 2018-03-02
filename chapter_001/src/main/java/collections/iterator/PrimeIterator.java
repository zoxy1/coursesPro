package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {
    private int[] array;
    private int index = 0;

    public PrimeIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        Boolean isFound = false;
        if ((this.array.length > index) && (primeFind(false) != null)) {
            isFound = true;
        }
        return isFound;
    }

    @Override
    public Integer next() {
        Integer result = primeFind(true);
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    private Integer primeFind(Boolean offsetCarriage) {
        Integer result = null;

        for (int i = index; i < this.array.length; i++) {
            int value = this.array[i];
            if (value >= 2) {
                if (value == 2 || value == 3) {
                    if (offsetCarriage) {
                        index = i + 1;
                    }
                    result = value;
                    break;
                } else if (value % 2 != 0) {
                    Boolean isPrime = true;
                    for (int j = 2; j <= value / 2; j++) {
                        if (value % j == 0) {
                            isPrime = false;
                        }
                    }
                    if (isPrime) {
                        if (offsetCarriage) {
                            index = i + 1;
                        }
                        result = value;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
