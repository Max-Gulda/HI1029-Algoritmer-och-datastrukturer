package F6.NB17;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private class itr implements Iterator<E>{
        Node<E> current;

        public itr(Node<E> node){
            current = node;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (current==null) throw new NoSuchElementException();
            E returnValue = current.data;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
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

    private Node<E> getNodeRec(Node<E> current, int index){
        if (current == null || index < 0) return null;
        if (index == 0) return current;
        return getNodeRec(current.next, index - 1);
    }

    private Node<E> getNode(int index){
        return getNodeRec(head,index);
    }

    private void addAfter(Node<E> node, E item){
        node.next = new Node<>(item,node.next);
        size++;
    }

    public int size(){
        return sizeRec(head, 0);
    }

    private int sizeRec(Node<E> current, int currentSize){
        if (current == null) return currentSize;
        return sizeRec(current.next, currentSize + 1);
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

    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder b = new StringBuilder();

        Node<E> tempNode = head;

        b.append("[").append(head.data);
        while(tempNode.next != null){
            tempNode = tempNode.next;
            if(tempNode != null) b.append(", ").append(tempNode.data);
        }
        b.append("]");

        return b.toString();
    }
}
