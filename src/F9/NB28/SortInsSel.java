package F9.NB28;

import java.net.SocketTimeoutException;
import java.util.Random;

public class SortInsSel {
    public static void insertionSort(int[] a){
        for(int i = 0; i < a.length; i++){
            int data = a[i];
            int dataIndex = i - 1;
            while(dataIndex >= 0 && a[dataIndex] - data > 0){
                a[dataIndex + 1] = a[dataIndex];
                dataIndex--;
            }
            a[dataIndex + 1] = data;
        }
    }

    public static void selectionSort(int[] a){
        selectionSort(a, 0);
    }

    private static void selectionSort(int[] a, int index){
        if(index == a.length) return;
        int min = index;
        for(int i = index + 1; i < a.length; i++){
            if(a[i] < a[min]) min = i;
        }
        int temp = a[index];
        a[index] = a[min];
        a[min] = temp;
        selectionSort(a, index + 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] list = new int[20];
        for(int i = 0 ; i < list.length; i++){
            list[i] = rand.nextInt(list.length);
        }
        System.out.print("List before sort: ");
        printList(list);
        selectionSort(list);
        System.out.print("List after selection sort: ");
        printList(list);

        for(int i = 0 ; i < list.length; i++){
            list[i] = rand.nextInt(list.length);
        }
        System.out.print("List before sort: ");
        printList(list);
        insertionSort(list);
        System.out.print("List after selection sort: ");
        printList(list);

    }

    private static void printList(int[] a){
        StringBuilder sb = new StringBuilder("[");
        for(int integer: a){
            sb.append(integer).append(", ");
        }
        sb.delete(sb.length() -2, sb.length());
        sb.append("]");
        System.out.println(sb);
    }

}
