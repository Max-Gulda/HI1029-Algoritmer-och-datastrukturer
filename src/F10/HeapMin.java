package F10;

import java.util.Arrays;
import java.util.Random;

public class HeapMin<E extends Comparable<E>>{
    int size;
    E[] data;
    int nextPos;

    public HeapMin(int size){
        this.size = size;
        this.data = (E[]) new Comparable[size];
        this.nextPos = 0;
    }

    public boolean insert(E newData) {
        if(nextPos >= size) expand();

        data[nextPos] = newData;
        int currentPos = nextPos;
        int parent = parent(currentPos);
        nextPos++;

        while(currentPos > 0 && data[currentPos].compareTo(data[parent]) < 0){
            swap(currentPos, parent);
            currentPos = parent;
            parent = parent(currentPos);
        }

        return true;
    }

    private int parent(int p){
        return (p-1) / 2;
    }

    private int rightChild(int p){
        return (p * 2) + 2;
    }

    private int leftChild(int p){
        return (p * 2) + 1;
    }

    private void swap(int p1, int p2){
        E temp = data[p1];
        data[p1] = data[p2];
        data[p2] = temp;
    }

    @SuppressWarnings("unchecked")
    private void expand(){
        E[] temp = (E[])new Comparable[size*2];
        for(int i = 0; i < nextPos; i++){
            temp[i] = data[i];
        }
        size *= 2;
        data = temp;
    }

    public E extract() {
        if (nextPos == 0) return null;

        E returnVal = data[0];
        data[0] = data[nextPos - 1];
        data[nextPos - 1] = null;
        nextPos--;

        int currentPos = 0;
        while (leftChild(currentPos) < nextPos) {
            int left = leftChild(currentPos);
            int right = rightChild(currentPos);
            int smallerChild = left;
            if (right < nextPos && data[right].compareTo(data[left]) < 0) {
                smallerChild = right;
            }
            if (data[currentPos].compareTo(data[smallerChild]) <= 0) {
                break;
            }
            swap(currentPos, smallerChild);
            currentPos = smallerChild;
        }
        return returnVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < nextPos; i++){
            sb.append(data[i]).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        HeapMin<String> stringHeap = new HeapMin<>(2);

        stringHeap.insert("Päron");
        stringHeap.insert("Äpple");
        stringHeap.insert("Banan");
        stringHeap.insert("Druva");
        stringHeap.insert("Clementin");
        stringHeap.insert("Apelsin");
        stringHeap.insert("Mango");

        System.out.println("Heap innan extraktion: " + stringHeap);
        System.out.println("Extraherat: " + stringHeap.extract());
        System.out.println("Extraherat: " + stringHeap.extract());
        System.out.println("Extraherat: " + stringHeap.extract());
        System.out.println("Heap efter extraktioner: " + stringHeap);
    }

}
