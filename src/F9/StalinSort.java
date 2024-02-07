package F9;

import java.util.Arrays;

public class StalinSort {
    public static int[] sort(int[] array){
        return sort(array, array.length - 1);
    }

    private static int[] sort(int[] array, int index){
        if(index == 0) return array;
        if(array[index - 1] > array[index]) {
            array = gulag(array, index);
        }
        return sort(array, index-1);
    }

    private static int[] gulag(int[] array, int index){
        int[] newArray = new int[array.length-1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,6,4,3,2,8,9,6,10};
        array = sort(array);
        for(int element: array){
            System.out.println(element);
        }
    }
}
