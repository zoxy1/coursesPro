package collections.Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(parent)) {
                el.add(new Node<>(child));
                return true;
            }
            for (Node<E> childAdd : el.leaves()) {
                data.offer(childAdd);
            }
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
//                Queue<Node<E>> data = new LinkedList<>();
//                data.offer(root);
//                while (!data.isEmpty()) {
//                    Node<E> el = data.poll();
//                    if (!el.leaves().isEmpty()) {
//                        return true;
//                    }
//                    for (Node<E> childAdd : el.leaves()) {
//                        if (!childAdd.leaves().isEmpty()) {
//                            return true;
//                        }
//                        data.offer(childAdd);
//                    }
//                }
                return false;
            }

            @Override
            public E next() {

                return null;
            }
        };
    }
}
