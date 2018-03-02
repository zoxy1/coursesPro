package collections.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void add() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();

        assertThat(simpleSet.add(1), is(true));
        assertThat(simpleSet.add(2), is(true));
        assertThat(simpleSet.add(1), is(false));
        Iterator<Integer> iterator = simpleSet.iterator();

        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    @Test
    public void iterator() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator<Integer> iterator = simpleSet.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }
}