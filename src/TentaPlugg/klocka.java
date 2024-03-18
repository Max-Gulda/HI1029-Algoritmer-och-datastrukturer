package TentaPlugg;

import java.util.Arrays;
import java.util.HashMap;

public class klocka {
    public static int klocka(int end, int start){
        end %= 12;
        start %= 12;
        return klocka(end,start,0, new HashMap<>());
    }

    public static int klocka(int end, int start, int points, HashMap<Integer, Integer> memo){
        int diff = Math.abs(end - start);
        if(memo.containsKey(diff)){
            return memo.get(diff);
        }
        if(end == start){
            return points;
        }
        if(points == 15){
            return Integer.MAX_VALUE;
        }
        int ten = klocka(end, (start + 10)%12, points + 1, memo);
        int seven = klocka(end, (start + 7)%12, points + 1, memo);
        int min = Math.min(ten,seven);
        memo.put(diff,min);
        return min;
    }

    public static int watch(int end, int start){
        end %= 12;
        start %= 12;
        return watch(end,start,0);
    }

    public static int watch(int end, int start, int points){
        if(end == start){
            return points;
        }
        if(points == 15){
            return Integer.MAX_VALUE;
        }
        int ten = watch(end, (start + 10)%12, points + 1);
        int seven = watch(end, (start + 7)%12, points + 1);
        return Math.min(ten,seven);
    }

    public static int klocka2(int end, int start){
        end %= 12;
        start %= 12;
        return klocka2(end,start,0, new int[13]);
    }

    public static int klocka2(int end, int start, int points, int[] dp){
        int diff = Math.abs(end - start);
        if(dp[diff] != 0){
            return dp[diff];
        }
        if(end == start){
            return points;
        }
        if(points == 15){
            return Integer.MAX_VALUE;
        }
        int ten = klocka2(end, (start + 10)%12, points + 1, dp);
        int seven = klocka2(end, (start + 7)%12, points + 1, dp);
        int min = Math.min(ten,seven);
        dp[diff] = min;
        return min;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(klocka(11,12));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("klocka : Elapsed time = " + (double)elapsedTime/1000000000);

        long startTime2 = System.nanoTime();
        System.out.println(watch(11,12));
        long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("watch : Elapsed time = " + (double)elapsedTime2/1000000000);


        long startTime3 = System.nanoTime();
        System.out.println(klocka2(11,12));
        long elapsedTime3 = System.nanoTime() - startTime3;
        System.out.println("klocka 2 : Elapsed time = " + (double)elapsedTime3/1000000000);
    }
}
