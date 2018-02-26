package list;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleCheckTest {
    @Test
    public void hasCycle() {
        CycleCheck cycleCheck = new CycleCheck();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        assertTrue(cycleCheck.hasCycle(first));
    }

    @Test
    public void hasCycleThenThirdToTwoNode() {
        CycleCheck cycleCheck = new CycleCheck();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;

        assertTrue(cycleCheck.hasCycle(first));
    }

    @Test
    public void hasNotCycle() {
        CycleCheck cycleCheck = new CycleCheck();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = null;
        four.next = first;

        assertFalse(cycleCheck.hasCycle(first));
    }
}
