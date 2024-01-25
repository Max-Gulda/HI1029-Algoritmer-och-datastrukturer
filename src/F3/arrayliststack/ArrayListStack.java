package F3.arrayliststack;

import F3.stack.StackInt;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInt<E> {
    private ArrayList<E> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        if (obj == null) throw new NullPointerException("Stack does not support adding null");
        stack.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }

    @Override
    public E pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        if (stack.isEmpty()) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; i < stack.size(); i++) {
            b.append(stack.get(i));
            if (i < stack.size() - 1) {
                b.append(", ");
            }
        }
        b.append("]");
        return b.toString();
    }
}
