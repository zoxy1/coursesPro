package list;

public class CycleCheck {

    boolean hasCycle(Node first) {
        Node[] nodes = new Node[5];
        nodes[0] = first;
        for (int i = 1; i < 5; i++) {
            nodes[i] = nodes[i - 1].next;
            if (nodes[i] == null) {
                return false;
            }
            for (int j = 0; j < 5; j++) {
                if (j != i && nodes[i] == nodes[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}