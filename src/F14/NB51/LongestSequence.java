package F14.NB51;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSequence {

    public static int longest(int[] list) {
        return longest(list, 0, Integer.MIN_VALUE, 0, new HashMap<>());
    }

    public static int longest(int[] list, int index, int previousNumber, int currentLength, HashMap<Integer, Integer> memo) {
        if (index == list.length) return currentLength;
        //if(memo.containsKey(index)) return memo.get(index);
        int take = 0;
        if (list[index] > previousNumber) {
            take = longest(list, index + 1, list[index], currentLength + 1, memo);
        }
        int skip = longest(list, index + 1, previousNumber, currentLength, memo);
        int max = Math.max(take, skip);
        //memo.put(index, max);
        return max;
    }

    public static int longestIncreasingSubsequence(int[] list) {
        if (list.length == 0) return 0;

        int[] dp = new int[list.length];
        Arrays.fill(dp, 1);
        int longest = 0;
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > longest) longest = dp[i];
        }
        System.out.println(Arrays.toString(dp));
        return longest;
    }

    public static void main(String[] args) {
        int[] list = {5, 2, 8, 6, 3, 6, 9, 7};
        long startTime = System.nanoTime();
        System.out.println(longestIncreasingSubsequence(list));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("It took: " + (double) elapsedTime/1000000000 + "s");
    }
}
