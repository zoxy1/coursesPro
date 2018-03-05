package collections.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DynamicListTest {
    @Test
    public void add() {
        DynamicList<Integer> dynamicList = new DynamicList<>();
        dynamicList.add(1);
        dynamicList.add(2);
        assertThat(dynamicList.get(0), is(1));
        assertThat(dynamicList.get(1), is(2));
    }

    @Test
    public void get() {
        DynamicList<Integer> dynamicList = new DynamicList<>(new Integer[] {1, 2});
        assertThat(dynamicList.get(0), is(1));
        assertThat(dynamicList.get(1), is(2));
    }
    @Test
    public void whenTakeIteratorShouldBeIterator() {
        DynamicList<Integer> dynamicList = new DynamicList<>(new Integer[] {1, 2});
        Iterator iterator = dynamicList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenChangedDynamicListIteratorThrowException() {
        DynamicList<Integer> dynamicList = new DynamicList<>(new Integer[] {1, 2});
        Iterator iterator = dynamicList.iterator();
        dynamicList.add(3);
        assertThat(iterator.next(), is(true));
    }
}
