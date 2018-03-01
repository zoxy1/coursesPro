package set;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkSetTest {
    @Test
    public void add() {
        SimpleLinkSet<Integer> simpleLinkSet = new SimpleLinkSet<>();
        simpleLinkSet.add(1);
        simpleLinkSet.add(2);
        Iterator<Integer> iterator = simpleLinkSet.iterator();

        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    @Test
    public void iterator() {
        SimpleLinkSet<Integer> simpleLinkSet = new SimpleLinkSet<>();
        simpleLinkSet.add(1);
        simpleLinkSet.add(2);
        Iterator<Integer> iterator = simpleLinkSet.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }
}