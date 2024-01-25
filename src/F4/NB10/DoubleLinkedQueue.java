package F4.NB10;

import java.util.NoSuchElementException;

public class DoubleLinkedQueue<E> {
    private class Node<E>{

        private Node<E> next, previous;
        private E data;

        public Node(Node<E> next, Node<E> previous, E data){
            this.next = next;
            this.data = data;
            this.previous = previous;
        }
        @Override
        public String toString(){
            return data.toString();
        }
    }

    private Node<E> head, tail;
    private int size;

    public DoubleLinkedQueue(){
        size = 0;
        head = null;
        tail = null;
    }

    public void offerFirst(E data){
        Node<E> newNode = new Node<>(head, null, data);
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void offerLast(E data){
        Node<E> newNode = new Node<>(null, tail, data);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    public E pollFirst(){
        if (size == 0) throw new NoSuchElementException();
        E returnValue = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return returnValue;
    }

    public E pollLast(){
        E returnValue;
        if(size == 0) throw new NoSuchElementException();
        if(size == 1) {
            returnValue = head.data;
            head = null;
            tail = null;
        }else{
            returnValue = tail.data;
            tail = tail.previous;
            tail.next = null;
        }

        size--;
        return returnValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleLinkedQueue: [");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
