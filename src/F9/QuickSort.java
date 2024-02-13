package F9;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(int[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high){
        if(low >= high) return;
        int pivotIndex = partition(a, low, high);
        sort(a, low, pivotIndex - 1);
        sort(a, pivotIndex + 1, high);
    }

    private static int partition(int[] a, int low, int high){
        int pivot = a[high];
        int pivotIndex = low - 1;
        for(int i = low; i < high; i++){
            if(a[i] <= pivot){
                pivotIndex++;
                swap(a, i, pivotIndex);
            }
        }
        pivotIndex++;
        swap(a, high, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] a, int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main(String[] args) {
        int[] list = new int[20];
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(list.length);
        }
        System.out.println("List before sort: " + Arrays.toString(list));
        sort(list);
        System.out.println("List after sort : " + Arrays.toString(list));
    }
}
