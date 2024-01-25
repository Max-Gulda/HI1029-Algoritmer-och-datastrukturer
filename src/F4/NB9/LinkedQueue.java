package F4.NB9;

import java.util.NoSuchElementException;

public class LinkedQueue<E> {

    private class Node<E>{
        private Node<E> next;
        private E data;
        public Node(Node<E> next, E data){
            this.next = next;
            this.data = data;
        }
    }
    private Node<E> head, tail;
    private int size;

    public LinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(E data){
        if(size == 0){
            head = new Node<>(null, data);
            tail = head;
        } else {
            tail.next = new Node<>(null, data);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue(){
        if(size == 0) throw new NoSuchElementException();
        size--;
        E returnValue = head.data;
        head = head.next;
        return returnValue;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        if (size == 0) return "Queue: []";
        StringBuilder b = new StringBuilder("Queue: [");
        Node<E> current = head;
        for(int i = 0 ; i < size; i++){
            b.append(current.data);
            current = current.next;
            if(i != size - 1) b.append(", ");
        }
        b.append("]");
        return b.toString();
    }

}
