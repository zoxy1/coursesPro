package collections.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LinkedListForCourseTest {
    @Test
    public void add() {
        SimpleContainer<Integer> list = new LinkedListForCourse<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void thenGetNotExistingIndexThrowException() {
        SimpleContainer<Integer> list = new LinkedListForCourse<>();
        list.add(10);
        list.add(20);
        list.get(2);
    }

    @Test
    public void thenGetIteratorReturnWorkedIterator() {
        SimpleContainer<Integer> list = new LinkedListForCourse<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void thenGetNotExistingNextElementThrowException() {
        SimpleContainer<Integer> list = new LinkedListForCourse<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void thenModificationContainerThrowException() {
        SimpleContainer<Integer> list = new LinkedListForCourse<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        list.add(4);
        iterator.next();
    }
}
