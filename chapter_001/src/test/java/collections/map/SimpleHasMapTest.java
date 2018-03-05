package collections.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Zoxy1 on 05.03.18.
 */
public class SimpleHasMapTest {
    @Test
    public void insert() {
        SimpleHasMap<String, Integer> simpleHasMap = new SimpleHasMap<>();
        assertTrue(simpleHasMap.insert("First", 1));
        assertTrue(simpleHasMap.insert("Second", 2));
        assertTrue(simpleHasMap.insert("Third", 3));
        assertFalse(simpleHasMap.insert("Third", 3));
        assertTrue(simpleHasMap.insert(null, 5));
        assertTrue(simpleHasMap.insert(null, null));

    }

    @Test
    public void get() {
        SimpleHasMap<String, Integer> simpleHasMap = new SimpleHasMap<>();
        assertTrue(simpleHasMap.insert("First", 1));
        assertThat(simpleHasMap.get("First"), is(1));

        assertTrue(simpleHasMap.insert("Second", 2));
        assertThat(simpleHasMap.get("Second"), is(2));

        assertTrue(simpleHasMap.insert("Third", 3));
        assertThat(simpleHasMap.get("Third"), is(3));

        assertTrue(simpleHasMap.insert(null, 5));
        assertThat(simpleHasMap.get(null), is(5));

        assertTrue(simpleHasMap.insert(null, null));
        assertNull(simpleHasMap.get(null));
    }

    @Test
    public void delete() {
        SimpleHasMap<String, Integer> simpleHasMap = new SimpleHasMap<>();
        assertTrue(simpleHasMap.insert("First", 1));
        assertTrue(simpleHasMap.insert("Second", 2));
        assertTrue(simpleHasMap.insert("Third", 3));
        assertTrue(simpleHasMap.insert(null, 5));

        assertThat(simpleHasMap.delete(null), is(true));
        assertThat(simpleHasMap.delete("Second"), is(true));

        assertThat(simpleHasMap.containsKey("Second"), is(false));
        assertThat(simpleHasMap.containsKey(null), is(false));
    }

    @Test
    public void containsKey() {
        SimpleHasMap<String, Integer> simpleHasMap = new SimpleHasMap<>();
        assertTrue(simpleHasMap.insert("First", 1));
        assertTrue(simpleHasMap.insert("Second", 2));
        assertTrue(simpleHasMap.insert("Third", 3));
        assertThat(simpleHasMap.containsKey(null), is(false));
        assertTrue(simpleHasMap.insert(null, 5));
        assertThat(simpleHasMap.containsKey(null), is(true));
        assertThat(simpleHasMap.delete("Second"), is(true));
        assertThat(simpleHasMap.containsKey("Second"), is(false));
        assertThat(simpleHasMap.delete(null), is(true));
        assertThat(simpleHasMap.containsKey(null), is(false));
    }

    @Test
    public void iterator() {
        SimpleHasMap<String, Integer> simpleHasMap = new SimpleHasMap<>();
        assertTrue(simpleHasMap.insert("First", 1));
        assertTrue(simpleHasMap.insert("Second", 2));
        assertTrue(simpleHasMap.insert("Third", 3));
        assertTrue(simpleHasMap.insert(null, 5));
        Iterator iterator = simpleHasMap.iterator();
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        System.out.println(iterator.next());
        assertThat(iterator.hasNext(), is(false));
    }
}