package telematics.nosova.lab2;

import java.util.Collection;
import java.util.Iterator;

// сделать pom зависисомсть

public class MyQueue<T> implements IMyQueue<T>, Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    MyQueue() {
        head = tail = null;
        size = 0;
    }

    MyQueue(Collection<? extends T> col) {
        head = tail = null;
        size = 0;
        for (T obj : col)
            add(obj);
    }

    public class MyQueueIterator implements Iterator<T> {
        private Node<T> node;

        public boolean hasNext() {
            return node.getNext() != null;
        }

        public T next() {
            node = node.getNext();
            return node.getData();
        }

        MyQueueIterator() {
            node = new Node<T>(null);
            node.setNext(head);
        }
    }

    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

    public int size() {
        return size;
    }

    public boolean contains(T obj) {
        Node<T> link = head;
        while (link != tail) {
            if (link.getData().equals(obj))
                return true;
            link = link.getNext();
        }
        if (link.getData().equals(obj))
            return true;
        return false;
    }

    public void add(T obj) {
        Node<T> newn = new Node<T>(obj);
        if (head == null) {
            head = tail = newn;
        } else {
            newn.setNext(head);
            head = newn;
        }
        size++;
    }

    public T remove() {
        if (tail == null) {
            return null;
        } else if (tail == head) {
            T tmp = head.getData();
            head = tail = null;
            size--;
            return tmp;
        } else {
            T tmp = tail.getData();
            Node<T> link = head;
            while (link.getNext() != tail) {
                link = link.getNext();
            }
            tail = link;
            tail.setNext(null);
            size--;
            return tmp;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node<T> p = head;
            for (int i = 0; i < index; i++) {
                p = p.getNext();
            }
            return p.getData();
        }
    }
}