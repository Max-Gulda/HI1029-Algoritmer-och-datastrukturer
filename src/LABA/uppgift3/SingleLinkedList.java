package LABA.uppgift3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private class itr implements Iterator<E>{
        Node<E> current;
        Node<E> previous;
        Node<E> beforePrevious;

        public itr(Node<E> node){
            current = node;
            previous = null;
            beforePrevious = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current==null) throw new NoSuchElementException();
            E returnValue = current.data;
            beforePrevious = previous;
            previous = current;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            if (previous == null || previous == beforePrevious) {
                throw new IllegalStateException();
            }

            if (beforePrevious == null) {
                head = current;
            } else {
                beforePrevious.next = current;
            }
            previous = beforePrevious;
            size--;
        }
    }

    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    public void add(int index, E item){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException(Integer.toString(index));
        if(index == 0){
            addFirst(item);
        }else{
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    private void addFirst(E item){
        head = new Node<E> (item, head);
        size++;
    }

    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i = 0; i < index && node != null; i++){
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item){
        node.next = new Node<>(item,node.next);
        size++;
    }

    public boolean add(E item){
        this.add(size, item);
        return true;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException(Integer.toString(index));
        return getNode(index).data;
    }

    public Iterator<E> iterator(){
        return new itr(head);
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
