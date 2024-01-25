package F3.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack <E> implements StackInt <E>{
    private E[] stack;
    private int maxSize;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(){
        maxSize = 10;
        top = -1;
        stack = (E[]) new Object[maxSize];
    }

    @SuppressWarnings("unchecked")
    private void expand(){
        maxSize *= 2;
        E[] tempStack = (E[]) new Object[maxSize];
        System.arraycopy(stack, 0, tempStack, 0, top);
        stack = tempStack;
    }

    @Override
    public E push(E obj) {
        if (obj == null) throw new NullPointerException("Stack does not accept null");
        top++;
        if (top == maxSize - 1) expand();
        stack[top] = obj;
        return obj;
    }


    @Override
    public E peek() {
        if(this.isEmpty()) throw new EmptyStackException();
        return stack[top];
    }

    @Override
    public E pop() {
        if(this.isEmpty()) throw new EmptyStackException();
        return stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        if ( this.isEmpty() ) return "[]";
        StringBuilder b = new StringBuilder("[");
        for(int i = top; i > 0; i--){
            b.append(stack[i]).append(", ");
        }
        b.append(stack[0]).append("]");
        return b.toString();
    }
}
