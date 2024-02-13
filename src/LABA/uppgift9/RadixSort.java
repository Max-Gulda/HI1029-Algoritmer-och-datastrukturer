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

            for (int i = 0; i < a.length; i++) {
                count[(a[i] / place) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // Build the output array
            for (int i = a.length - 1; i >= 0; i--) {
                count[(a[i] / place) % 10]--;
                output[count[(a[i] / place) % 10]] = a[i];

            }

            for (int i = 0; i < a.length; i++) {
                a[i] = output[i];
            }

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


    public static void main(String[] args) {
        Random rand = new Random();
        int[] list = new int[20];
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(list.length * 10);
        }
        System.out.println("Array before sorting = " + Arrays.toString(list));
        radixSort(list);

        System.out.println("Arrays after sorting = " + Arrays.toString(list));

    }
}
