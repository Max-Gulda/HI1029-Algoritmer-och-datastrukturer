package LABA.uppgift2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    private class Itr implements Iterator<E> {
        Node<E> current;

        Itr(Node<E> node) {
            current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public SingleLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean add(E item) {
        if(item == null){
            throw new NullPointerException("Cannot add null to list");
        }
        addLast(item);
        return true;
    }

    public void add(int index, E item) {
        if(item == null){
            throw new NullPointerException("Cannot add null to list");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<E> node = getNode(index - 1);
            node.next = new Node<>(item, node.next);
            size++;
        }
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    private void addLast(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E remove(int index) { // ta bort sista elementet?
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return removeFirst();
        }
        Node<E> previous = getNode(index - 1);
        Node<E> toRemove = previous.next;
        previous.next = toRemove.next;
        if (index == size - 1) {
            tail = previous;
        }
        size--;
        return toRemove.data;
    }

    private E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size - 1) {
            return tail;
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }

    private String toStringRec(Node<E> current, StringBuilder b){
        if (current == null ) return b.append("]").toString();
        b.append(current.data);
        if(current.next != null) b.append("->");
        return toStringRec(current.next, b);
    }

    @Override
    public String toString() {
        if(head == null ) return "[]";
        StringBuilder b = new StringBuilder("[");
        return toStringRec(head, b);
    }
}
