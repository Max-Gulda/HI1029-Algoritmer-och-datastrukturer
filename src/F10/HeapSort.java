package F10;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Random;

public class HeapSort {


    public static void heapSort(int[] array){
        heapify(array); // Build the max heap
        int size = array.length;
        for(int i = array.length - 1; i > 0; i--){
            swap(array, 0, i);
            size--;
            siftDown(array, 0, size);
        }
    }

    public static int extractFromHeap(int[] array, int size) {
        if (size < 1) {
            return array[0];
        }

        int maxValue = array[0];

        array[0] = array[size - 1];

        siftDown(array, 0, size);

        return maxValue;
    }

    public static void heapify(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            siftDown(array, i, array.length);
        }
    }

    private static void siftDown(int[] array, int i, int size) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            siftDown(array, largest, size);
        }
    }


    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static boolean isMaxHeap(int[] array) {
        if (array.length < 2) return true;
        int index = array.length - 1;
        while (index != 0) {
            if (array[parent(index)] < array[index]) return false;
            index--;
        }
        return true;
    }

    private static int parent(int currentPos) {
        return (currentPos - 1) / 2;
    }

    private static int leftChild(int currentPos) {
        return (currentPos * 2) + 1;
    }

    private static int rightChild(int currentPos) {
        return (currentPos * 2) + 2;
    }

    public static void main(String[] args) {
        int[] list = new int[20];
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(list.length);
        }
        System.out.println(Arrays.toString(list));
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }
}
