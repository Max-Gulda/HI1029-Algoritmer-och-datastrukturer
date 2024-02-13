package F9.NB29a;

import java.util.Arrays;
import java.util.Random;

public class mergeSort {

    public static void sort(int[] a) {
        if (a.length < 2) return;
        int mid = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        sort(left);
        sort(right);

        merge(a, left, right);
    }


    private static void merge(int[] result, int[] b, int[] a) {
        int indexResult = 0, indexB = 0, indexA = 0;
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] <= b[indexB]) {
                result[indexResult++] = a[indexA++];
            } else {
                result[indexResult++] = b[indexB++];
            }
        }
        while (indexA < a.length) {
            result[indexResult++] = a[indexA++];
        }

        while (indexB < b.length) {
            result[indexResult++] = b[indexB++];
        }
    }

    public static void main(String[] args) {
        int[] list = new int[20];
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(list.length);
        }
        System.out.println("List before sort: " + Arrays.toString(list));
        sort(list);
        System.out.println("List after sort:  " + Arrays.toString(list));
    }

}
