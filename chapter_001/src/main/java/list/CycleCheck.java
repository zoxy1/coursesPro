package list;

public class CycleCheck {
    private Node putNodes() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        return first;
    }


    boolean hasCycle(Node first) {
        Node node = first;
        while (node.next != null) {

        }
        return false;
    }
}
