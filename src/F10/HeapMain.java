package F10;

import java.util.Arrays;
import java.util.Random;

public class HeapMain {
    public static void main(String[] args) {
        int[] list = new int[10];
        Random rand = new Random();
        for(int i = 0; i < list.length; i++){
            list[i] = rand.nextInt(list.length);
        }
        System.out.println("Array before heapSort: " + Arrays.toString(list));
        HeapMax.heapSort(list);
        System.out.println("Array after heapSort : " + Arrays.toString(list));
    }
}
