package F12.NB34;

import java.util.Arrays;

public class Change {
    public static int[] exchange(int sum, int[] values){
        int index = 0;
        int[] retur = new int[values.length];
        while (sum > 0){
            if (sum - values[index] < 0){
                index++;
            }else{
                sum -= values[index];
                retur[index]++;
            }
        }
        return retur;
    }

    public static void main(String[] args) {
        int[] arr = exchange(789, new int[]{1000,500,100,50,20,10,5,1});
        System.out.println(Arrays.toString(arr));
    }
}
