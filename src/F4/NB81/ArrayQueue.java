package F4.NB81;

import java.util.Arrays;
public class ArrayQueue<E>{
    private int front, rear, size, maxSize;
    private E[] data;
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialSize){
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }
    public boolean offer(E element){
        if(size==maxSize) reallocate();
        data[rear] = element;
        rear = ( rear + 1 ) % maxSize;
        size++;
        return true;
    }
    public E peek(){
        if(size==0) return null;
        return data[front];
    }
    public E poll(){
        if(size==0){
            return null;
        }else{
            size--;
            E element = data[front];
            front = (front+1) % maxSize;
            return element;
        }
    }
    @SuppressWarnings("unchecked")
    private void reallocate() {
        E[] tempArray = (E[]) new Object[maxSize*2];
        for( int i = 0; i < size; i++){
            tempArray[i] = data[(i + front) % maxSize];
        }
        front = 0;
        rear = size;
        maxSize*=2;
        data= tempArray;
    }

    //Debugging purpose
    @Override
    public String toString() {
        if (size == 0) {
            return "Queue: [], maxSize = " + maxSize + ", Size = " + size;
        }

        StringBuilder b = new StringBuilder("Queue: [");
        for (int i = 0; i < size; i++) {
            b.append(data[(front + i) % maxSize]);
            if (i < size - 1) {
                b.append(", ");
            }
        }
        b.append("], maxSize = ").append(maxSize).append(", Size = ").append(size);
        b.append(" rear is : ").append(rear).append(" front is : ").append(front);
        b.append("\n").append(Arrays.toString(data));
        return b.toString();
    }

}

