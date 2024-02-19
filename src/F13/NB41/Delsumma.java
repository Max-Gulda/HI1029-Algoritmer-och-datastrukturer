package F13.NB41;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Delsumma {

    public static int maxSum(int[] a, int left, int right){
        if(left > right) return 0;
        if(left == right) return Math.max(0, a[left]);

        int mid = (left + right) / 2;
        int sum = 0, maxLeft = 0;
        for(int i = mid; i >= left; i--){
            sum += a[i];
            maxLeft = Math.max(maxLeft, sum);
        }

        int maxRight = 0;
        sum = 0;
        for(int i = mid + 1; i <= right; i++){
            sum += a[i];
            maxRight = Math.max(maxRight, sum);
        }

        int maxCrossMid = maxLeft + maxRight;
        int maxLeftSubarray = maxSum(a, left, mid);
        int maxRightSubarray = maxSum(a, mid + 1, right);

        return Math.max(maxCrossMid, Math.max(maxLeftSubarray, maxRightSubarray));
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int[] list;
        while(true){
            System.out.print("Enter amount of numbers: ");
            int times = scan.nextInt();
            if(times==0) break;
            else{
                list = new int[times];
                for(int i = 0; i < times; i++){
                    list[i] = rand.nextInt(-1000,1000);
                }
                System.out.println("List is : ");
                System.out.println(Arrays.toString(list));
                System.out.println("Max sum is : " + maxSum(list, 0, list.length - 1));
            }
        }
    }
}
