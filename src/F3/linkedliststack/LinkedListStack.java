package F3.linkedliststack;


import F3.stack.StackInt;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack<E> implements StackInt<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    }
    private Node<E> top;

    public LinkedListStack(){
        top = null;
    }

    @Override
    public E push(E obj) {
        if (obj == null) throw new NullPointerException("Stack does not accept null");
        top = new Node<>(obj,top);
        return obj;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public E peek(int n) {
        Node<E> current = top;
        for(int i = 0; i < n; i++){
            current = current.next;
            if ( current == null) throw new IndexOutOfBoundsException();
        }
        return current.data;
    }

    public int size(){
        Node<E> current = top;
        int i = 0;
        while(current != null){
            i++;
            current = current.next;
        }
        return i;
    }

    public E flush(){
        if ( top == null) return null;
        Node<E> current = top.next;
        Node<E> previous = top;
        top = null;
        while(current != null){
            previous = current;
            current = current.next;
        }

        return previous.data;
    }
    @Override
    public E pop() {
        if (this.isEmpty()) throw new EmptyStackException();
        E data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder b = new StringBuilder("[");
        Node<E> current = top.next;
        Node<E> previous = top;
        while (current != null){
            b.append(previous.data).append(" => ");
            previous = current;
            current = current.next;
        }
        b.append(previous.data).append("]");
        return b.toString();
    }
}
