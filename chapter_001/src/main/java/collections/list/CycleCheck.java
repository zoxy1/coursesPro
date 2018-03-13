package collections.list;

public class CycleCheck {
    boolean hasCycle(Node first) {
        Node nodeA = first;
        Node nodeB = nodeA.next;
        for (int index = 0; index < 4; index++) {
            for (int i = 0; i < (4 - index); i++) {
                if (nodeB == null) {
                    return false;
                }
                if (nodeA == nodeB) {
                    return true;
                }
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
            nodeB = nodeA.next;
        }
        return false;
    }
}