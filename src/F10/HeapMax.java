package F10;

import java.util.Arrays;
import java.util.Random;

public class HeapMax<E extends Comparable<E>> {
    int size;
    E[] data;
    int nextPos;

    @SuppressWarnings("unchecked")
    public HeapMax(int size) {
        this.size = size;
        this.data = (E[]) new Comparable[size];
        this.nextPos = 0;
    }

    public static void heapSort(int[] a){
        HeapMax<Integer> heap = new HeapMax<>(a.length);
        for(int i: a){
            heap.insert(i);
        }
        for(int i = a.length - 1; i >= 0; i--){
            a[i] = heap.extract();
        }
    }

    public boolean insert(E newData) {
        if (nextPos >= size) return false;

        this.data[nextPos] = newData;
        int currentPos = nextPos;
        nextPos++;

        while (currentPos > 0 && this.data[currentPos].compareTo(this.data[parent(currentPos)]) > 0) {
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }

        return true;
    }

    public E extract() {
        if (nextPos == 0) return null;

        E removedData = this.data[0];
        this.data[0] = this.data[nextPos - 1];
        nextPos--;

        int currentPos = 0;
        while (leftChild(currentPos) < nextPos) {
            int largerChild = leftChild(currentPos);
            if (rightChild(currentPos) < nextPos && this.data[rightChild(currentPos)].compareTo(this.data[leftChild(currentPos)]) > 0) {
                largerChild = rightChild(currentPos);
            }

            if (this.data[currentPos].compareTo(this.data[largerChild]) >= 0) break;

            swap(currentPos, largerChild);
            currentPos = largerChild;
        }

        return removedData;
    }

    private int leftChild(int currentPos) {
        return (2 * currentPos) + 1;
    }

    private int rightChild(int currentPos) {
        return (2 * currentPos) + 2;
    }

    private int parent(int currentPos) {
        return (currentPos - 1) / 2;
    }

    private void swap(int pos1, int pos2) {
        E temp = this.data[pos1];
        this.data[pos1] = this.data[pos2];
        this.data[pos2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        HeapMax<Integer> heap = new HeapMax<>(10);
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            heap.insert(rand.nextInt(10));
        }
        System.out.println(heap);

        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());

    }
}
