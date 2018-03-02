package collections.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashSetTest {

    @Test
    public void addStrings() {
        SimpleHashSet simpleHashSet = new SimpleHashSet();
        for (Integer i = 0; i < 13; i++) {
            assertThat(simpleHashSet.add("String" + i.toString()), is(true));
        }
    }

    @Test
    public void contains() {
        SimpleHashSet simpleHashSet = new SimpleHashSet();
        simpleHashSet.add("Test string1");
        simpleHashSet.add("Test string2");
        simpleHashSet.add("Test string3");
        assertThat(simpleHashSet.contains("Test string1"), is(true));
        assertThat(simpleHashSet.contains("Test string2"), is(true));
        assertThat(simpleHashSet.contains("Test string3"), is(true));
    }

    @Test
    public void remove() {
        SimpleHashSet simpleHashSet = new SimpleHashSet();
        simpleHashSet.add("Test string1");
        simpleHashSet.add("Test string2");
        simpleHashSet.add("Test string3");
        simpleHashSet.remove("Test string2");
        assertThat(simpleHashSet.contains("Test string1"), is(true));
        assertThat(simpleHashSet.contains("Test string2"), is(false));
        assertThat(simpleHashSet.contains("Test string3"), is(true));
    }
}