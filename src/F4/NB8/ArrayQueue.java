package F4.NB8;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private class Itr<E> implements Iterator<E>{
        private int index;
        private int count;

        public Itr(){
            count = 0;
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            E returnValue = (E) data[index];
            index = (index + 1) % maxSize;
            count++;
            return returnValue;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private int front, rear, size, maxSize;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialMaxSize) {
        maxSize = initialMaxSize;
        rear = maxSize - 1;
        front = 0;
        size = 0;
        data = (E[]) new Object[maxSize];
    }

    public ArrayQueue(){
        this(10);
    }

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    @Override
    public boolean offer(E item){
        if (size == maxSize) expand();
        rear = (rear + 1 ) % maxSize;
        data[rear] = item;
        size++;
        return true;
    }

    public E poll(){
        if ( size == 0 ) return null;
        E returnValue = data[front];
        front = ( front + 1 ) % maxSize;
        size--;
        if (size <= maxSize / 4) contract();
        return returnValue;
    }

    @SuppressWarnings("unchecked")
    private void contract(){
        E[] tempArray = (E[]) new Object[maxSize / 2];
        for(int i = 0; i < size; i++) {
            tempArray[i] = data[(front + i) % maxSize];
        }
        front = 0;
        rear = size - 1;
        maxSize /= 2;
        data = tempArray;
    }

    @SuppressWarnings("unchecked")
    private void expand(){
        E[] tempArray = (E[]) new Object[maxSize * 2];
        for ( int i = 0; i < size; i++){
            tempArray[i] = data[(front + i) % maxSize];
        }
        front = 0;
        rear = size-1;
        maxSize *= 2;
        data = tempArray;
    }

    public E peek() {
        if ( size == 0) return null;
        return data[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if(size==0) return "[], Size of array: " + maxSize;
        StringBuilder b = new StringBuilder("[");
        for(int i = 0; i < size - 1; i++){
            b.append(data[(i + front) % maxSize]).append(" => ");
        }
        b.append(data[size-1]).append(']').append(" Size of array: ").append(maxSize);
        return b.toString();
    }
}
