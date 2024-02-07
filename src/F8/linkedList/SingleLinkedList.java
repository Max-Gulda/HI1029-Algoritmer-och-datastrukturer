package F8.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private class itr implements Iterator<E> {
        private Node<E> current;
        private Node<E> previous;
        private Node<E> beforePrevious; // Needed to update the previous pointer correctly
        private boolean canRemove; // To ensure remove is called after next and only once per next

        public itr(Node<E> node) {
            current = node;
            previous = null;
            beforePrevious = null;
            canRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) throw new NoSuchElementException();
            E returnValue = current.data;
            beforePrevious = previous;
            previous = current;
            current = current.next;
            canRemove = true;
            return returnValue;
        }

        @Override
        public void remove() {
            if (!canRemove) throw new IllegalStateException();
            if (previous == head) {
                // Removing the head of the list
                head = current;
            } else {
                // Removing a middle or last element
                beforePrevious.next = current;
            }
            size--;
            previous = beforePrevious; // Update previous since we've removed the node after it
            canRemove = false; // Reset to ensure remove is called only once per next call
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

    public boolean isEmpty(){
        return size == 0;
    }
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
