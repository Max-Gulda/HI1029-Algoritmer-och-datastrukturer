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


    private static void merge(int[] a, int[] b, int[] c) {
        int indexA = 0, indexB = 0, indexC = 0;
        while (indexC < c.length && indexB < b.length) {
            if (c[indexC] <= b[indexB]) {
                a[indexA++] = c[indexC++];
            } else {
                a[indexA++] = b[indexB++];
            }
        }

        while (indexC < c.length) {
            a[indexA++] = c[indexC++];
        }

        while (indexB < b.length) {
            a[indexA++] = b[indexB++];
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
