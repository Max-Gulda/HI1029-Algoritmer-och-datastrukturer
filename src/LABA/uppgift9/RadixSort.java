package LABA.uppgift9;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    private static void radixSort(int[] a) { //Den sista kopieringen är onödig, går detta att undvika?
        int maxNumber = findMax(a);
        int[] output = new int[a.length];
        int place = 1;

        while (maxNumber / place > 0) {
            int[] count = new int[10];

            for (int i = 0; i < a.length; i++) { //Maska ut & addera på platsen
                count[(a[i] / place) % 10]++;
            }

            for (int i = 1; i < 10; i++) { //Prefix summering
                count[i] += count[i - 1];
            }

            // Build the output array
            for (int i = a.length - 1; i >= 0; i--) {
                count[(a[i] / place) % 10]--;
                output[count[(a[i] / place) % 10]] = a[i];

            }

            System.arraycopy(output, 0, a, 0, a.length);

            place *= 10;
        }
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (int i : a) {
            if (i > max) max = i;
        }
        return max;
    }

    private static boolean isArraySorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Random rand = new Random();
        int[] list = new int[1000000];
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        radixSort(list);
        long endTime = System.nanoTime();
        double runningTime = (double) (endTime - startTime) / 1000000000;
        if (isArraySorted(list)) System.out.println("Array is sorted!");
        else System.out.println("Array is not sorted!");
        System.out.println("Runtime took: " + runningTime + " s");
    }
}
