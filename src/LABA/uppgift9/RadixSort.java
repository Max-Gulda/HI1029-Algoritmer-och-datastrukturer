package LABA.uppgift9;

import java.util.Random;

public class RadixSort {

    public static void sort(int[] a) {
        int[] negative = new int[a.length];
        int[] positive = new int[a.length];
        int negativeIndex = 0, positiveIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                negative[negativeIndex++] = -a[i];
            } else {
                positive[positiveIndex++] = a[i];
            }
        }

        radixSort(negative, negativeIndex);
        radixSort(positive, positiveIndex);


        for (int i = 0; i < negativeIndex; i++) {
            a[i] = -negative[negativeIndex - 1 - i];
        }
        for (int i = 0; i < positiveIndex; i++) {
            a[negativeIndex + i] = positive[i];
        }
    }

    private static void radixSort(int[] a, int length) {
        int maxNumber = findMax(a);
        int[] output = new int[length];
        int place = 1;

        while (maxNumber / place > 0) {
            int[] count = new int[10];

            for (int i = 0; i < length; i++) { //Maska ut & addera på platsen
                count[(a[i] / place) % 10]++;
            }

            for (int i = 1; i < 10; i++) { //Prefix summering
                count[i] += count[i - 1];
            }

            for (int i = length - 1; i >= 0; i--) {
                count[(a[i] / place) % 10]--;
                output[count[(a[i] / place) % 10]] = a[i];

            }

            int[] temp;
            temp = a;
            a = output;
            output = temp;
            //System.arraycopy(output, 0, a, 0, length);

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
            list[i] = rand.nextInt();
        }
        sort(list);
        long endTime = System.nanoTime();
        double runningTime = (double) (endTime - startTime) / 1000000000;
        if (isArraySorted(list)) System.out.println("Array is sorted!");
        else System.out.println("Array is not sorted!");
        System.out.println("Runtime took: " + runningTime + " s");
    }
}
