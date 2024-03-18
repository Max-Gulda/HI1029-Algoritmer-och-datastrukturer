package F9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShellSort {

    public static void sort(int[] a) {
        int gap = a.length / 2;
        while (gap > 0) {
            for (int i = gap; i < a.length; i++) {
                int data = a[i];
                int dataIndex = i;
                while (dataIndex > gap-1 && data < a[dataIndex - gap]) {
                    a[dataIndex] = a[dataIndex - gap];
                    dataIndex -= gap;
                }
                a[dataIndex] = data;
            }
            if (gap == 2) gap = 1;
            else gap /= 2.2;
        }
    }

    public static void shellSort(int[] a) {
        int gap = a.length / 2;
        while(gap > 0) {
            for (int i = gap; i < a.length; i++) {
                int data = a[i];
                int dataIndex = i;
                while(dataIndex > gap -1 && data < a[dataIndex- gap]) {
                    a[dataIndex] = a[dataIndex - gap];
                    dataIndex -= gap;
                }
                a[dataIndex] = data;
            }
            if (gap == 2) gap = 1;
            else gap /= 2.2;
        }
    }



    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 32, 4, 3, 2, 1, 0};
        sort(array);
        for (int element : array) {
            System.out.println(element);
        }
    }

}
