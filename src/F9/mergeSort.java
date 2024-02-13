package F9;

import java.util.Random;

public class mergeSort {
    public static int[] sort(int[] a) {
        return sort(a, 0, a.length-1);
    }

    private static int[] sort(int[] a, int low, int high) {
        if (low >= high) return a;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
        return a;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        for(i = low, k = 0; i <= high; i++, k++){
            a[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] list = new int[100];
        Random rand = new Random();
        for(int i = 0; i < list.length; i++){
            list[i] = rand.nextInt(100);
        }
        StringBuilder b = new StringBuilder("[");
        for(int i: list){
            b.append(i).append(", ");
        }
        b.delete(b.length() - 2, b.length());
        b.append("]");
        System.out.println(b.toString());

        sort(list);

        b = new StringBuilder("[");
        for(int i: list){
            b.append(i).append(", ");
        }
        b.delete(b.length() - 2, b.length());
        b.append("]");
        System.out.println(b.toString());
    }

}
