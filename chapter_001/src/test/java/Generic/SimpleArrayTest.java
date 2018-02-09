package Generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void add() throws Exception {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Object[]{null});
        simpleArray.add(5);
        simpleArray.add(6);
        assertThat(simpleArray.get(0), is(5));
        assertThat(simpleArray.get(1), is(6));
    }

    @Test
    public void set() throws Exception {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[]{1, 2, 3, 4});
        simpleArray.set(0, 10);
        simpleArray.set(1, 11);
        assertThat(simpleArray.get(0), is(10));
        assertThat(simpleArray.get(1), is(11));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setToNonexistentIndexElementThrowException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[]{1, 2, 3, 4});
        simpleArray.set(4, 11);
    }

    @Test
    public void delete() throws Exception {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[]{1, 2, 3, 4});
        simpleArray.delete(1);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(3));
        assertThat(simpleArray.get(2), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteNonexistentIndexElementThrowException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[]{1, 2, 3, 4});
        simpleArray.delete(4);
    }

    @Test
    public void get() throws Exception {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[]{1, 2, 3, 4});
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
        assertThat(simpleArray.get(3), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNonexistentIndexElementThrowException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Integer[]{1, 2, 3, 4});
        simpleArray.get(4);
    }
}