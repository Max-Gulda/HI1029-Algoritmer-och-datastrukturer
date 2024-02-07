package F9;

public class SelectionSort {
    public static void sort(int[] array) {
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,32,4,3,2,1,0};
        sort(array);
        for(int element: array){
            System.out.println(element);
        }
    }
}
