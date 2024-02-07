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

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 4, 3, 2, 8, 9, 6, 10};
        sort(array);
        for (int element : array) {
            System.out.println(element);
        }
    }
}
