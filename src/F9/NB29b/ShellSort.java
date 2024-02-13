package F9.NB29b;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void sort(int[] a){
        int gap = a.length / 2;
        while(gap > 0){
            for(int i = gap; i < a.length; i++){
                int data = a[i];
                int dataIndex = i - gap;
                while(dataIndex >= 0 && data < a[dataIndex]){
                    a[dataIndex + gap] = a[dataIndex];
                    dataIndex -= gap;
                }
                a[dataIndex + gap] = data;
            }
            if(gap == 2) gap = 1;
            else gap /= 2.2;
        }
    }

    public static void main(String[] args) {
        int[] list = new int[20];
        Random rand = new Random();
        for(int i = 0; i < list.length; i++){
            list[i] = rand.nextInt(list.length);
        }
        System.out.println("List before sort: "+Arrays.toString(list));
        sort(list);
        System.out.println("List after sort : " + Arrays.toString(list));
    }
}
