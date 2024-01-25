package F3.stack;

public interface StackInt<E> {
    E push(E obj);
    E peek();
    E pop();
    boolean isEmpty();
}
