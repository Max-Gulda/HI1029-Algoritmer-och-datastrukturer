package F9;

import java.util.Arrays;
import java.util.Random;

public class sortMaximus {

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] <= a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int data = a[i];
            int dataIndex = i;
            while (dataIndex > 0 && data < a[dataIndex - 1]) {
                a[dataIndex] = a[dataIndex - 1];
                dataIndex--;
            }
            a[dataIndex] = data;
        }
    }

    public static void insertionSortMax(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int data = a[i];
            int dataIndex = i - 1;
            while (dataIndex > 0 && data < a[dataIndex]) {
                a[dataIndex + 1] = a[dataIndex];
                dataIndex--;
            }
            a[dataIndex + 1] = data;
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;

            for (int j = i; j < a.length; j++) {
                minIndex = a[minIndex] > a[j] ? j : minIndex;
            }
            swap(a, i, minIndex);
        }
    }

    public static void shellSort(int[] a) {
        int gap = a.length / 2;
        while (gap > 0) {
            for (int i = gap; i < a.length; i++) {
                int data = a[i];
                int dataIndex = i - gap;
                while (dataIndex >= 0 && data < a[dataIndex]) {
                    a[dataIndex + gap] = a[dataIndex];
                    dataIndex -= gap;
                }
                a[dataIndex + gap] = data;
            }
            if (gap == 2) gap = 1;
            else gap /= 2.2;
        }
    }


    private static void insertionShellsort(int[] a, int gap) {
        for (int i = gap; i < a.length; i++) {
            int dataIndex = i;
            int data = a[i];
            while (dataIndex > gap - 1 && data < a[dataIndex - gap]) {
                a[dataIndex] = a[dataIndex - gap];
                dataIndex -= gap;
            }
            a[dataIndex] = data;
        }
    }

    public static void shellsortJesper(int[] a) {
        int gap = a.length / 2;
        while (gap > 0) {
            insertionShellsort(a, gap);
            if (gap == 2) gap = 1;
            gap = (int) (gap / 2.2);
        }
    }

    public static void mergeSort(int[] a){
        if(a.length <= 1) return;
        int mid = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        mergeSort(left);
        mergeSort(right);
        merge(a,left,right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int indexResult = 0, indexLeft = 0, indexRight = 0;
        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] <= right[indexRight]) {
                result[indexResult++] = left[indexLeft++];
            } else {
                result[indexResult++] = right[indexRight++];
            }
        }

        while(indexLeft < left.length){
            result[indexResult++] = left[indexLeft++];
        }
        while(indexRight < right.length){
            result[indexResult++] = right[indexRight++];
        }
    }

    private static void mergeJ(int[] a, int[] b, int[] c) {
        int indexA = 0, indexB = 0, indexC = 0;
        while (indexA < a.length && indexB < b.length){
            if(a[indexA] <= b[indexB]) c[indexC++] = a[indexA++];
            else c[indexC++] = b[indexB++];
        }
        while(indexA<a.length) c[indexC++] = a[indexA++];
        while(indexB<b.length) c[indexC++] = b[indexB++];
    }

    public static void mergeSortJ(int[] a){
        if(a.length <= 1) return;
        int[] b = Arrays.copyOfRange(a, 0 , a.length/2);
        int[] c = Arrays.copyOfRange(a, a.length/2, a.length);
        mergeSortJ(b);
        mergeSortJ(c);
        mergeJ(b,c,a);
    }

    private static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    private static int[] randomArray(int size) {
        int[] list = new int[size];
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        return list;
    }

    private static boolean isSorted(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]) return false;
        }
        return true;
    }

    public static void quickSort(int[] a){
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] a, int low, int high){
        if(high <= low) return;
        int partition = partition(a, low, high);
        quickSort(a, low, partition - 1);
        quickSort(a, partition + 1, high);
    }
    private static int partition(int[] a, int low, int high){
        int partition = low - 1;
        int pivot = a[high];
        for(int i = low; i < high; i++){
            if(a[i] <= pivot){
                swap(a, i, ++partition);
            }
        }
        partition++;
        swap(a, partition, high);
        return partition;
    }

    public static void countingSort(int[] a){
        int[] count = new int[findMax(a)+1];
        for(int num: a) count[num]++;
        int i = 0;
        for (int j = 0; j < count.length; j++) {
            while(count[j]-- > 0) a[i++] = j;
        }
    }

    private static int findMax(int[] a){
        int max = 0;
        for(int num:a){
            if(num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] list = randomArray(20);

        System.out.println("List before sort: " + Arrays.toString(list));
        countingSort(list);
        System.out.println("List after sort : " + Arrays.toString(list));
        if(isSorted(list)) System.out.println("list is correctly sorted");
        else System.out.println("list incorrectly sorted");
    }
}
