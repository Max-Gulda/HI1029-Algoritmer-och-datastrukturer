package F9;

import java.util.Arrays;

public class InsertionSort {
    public static int[] sort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int data = array[index];
            int dataIndex = index;
            while (dataIndex > 0 && data < array[dataIndex - 1]) {
                array[dataIndex] = array[dataIndex - 1];
                dataIndex--;
            }
            array[dataIndex] = data;
        }
        return array;
    }

    public static int[] shellSort(int[] a){
        int gap = a.length/2;
        while(gap > 0){
            for(int i = gap; i < a.length; i++){
                int data = a[i];
                int dataIndex = i;
                while (dataIndex > gap-1 && data < a[dataIndex-gap]){
                    a[dataIndex] = a[dataIndex-gap];
                    dataIndex-=gap;
                }
                a[dataIndex] = data;
            }
            if(gap == 2) gap = 1;
            else gap /= 2.2;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 6};
        shellSort(array);
        for (int element : array) {
            System.out.println(element);
        }
    }
}
