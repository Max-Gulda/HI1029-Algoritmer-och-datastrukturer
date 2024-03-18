package F14.NB47;

import java.util.Arrays;

public class Change {

    private static class Money {
        public int nrOfCoins; // Antal mynt som används för att nå summan
        public int[] answers; // Antal av varje mynt som används

        // Konstruktor
        public Money(int nrOfCoins, int[] answers) {
            this.nrOfCoins = nrOfCoins;
            this.answers = Arrays.copyOf(answers, answers.length);
        }
    }

    public static Money coinChange(int[] coins, int amount) {
        Money[] memo = new Money[amount + 1];
        return coinChangeHelper(coins, amount, memo);
    }

    private static Money coinChangeHelper(int[] coins, int amount, Money[] memo) {
        if (amount < 0) return new Money(Integer.MAX_VALUE, new int[coins.length]);
        if (amount == 0) return new Money(0, new int[coins.length]);
        if (memo[amount] != null) return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        int[] minCombination = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            Money result = coinChangeHelper(coins, amount - coin, memo);
            if (result.nrOfCoins < minCoins - 1) {
                minCoins = result.nrOfCoins + 1;
                minCombination = result.answers.clone();
                minCombination[i]++;
            }
        }

        memo[amount] = new Money(minCoins, minCombination);
        return memo[amount];
    }

    public static int coinChangeBottomUp(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {3, 2, 5};
        int amount = 53;

        long startTime = System.nanoTime();
        Money result = coinChange(coins, amount);
        long endTime1 = System.nanoTime() - startTime;

        System.out.println("Det minsta antalet mynt som behövs: " + result.nrOfCoins);
        System.out.println("Antal av varje mynt: " + Arrays.toString(result.answers));
        System.out.println("Top down tog: " + (double)endTime1/1000000000 + " sekunder");

        startTime = System.nanoTime();
        int bottomUp = coinChangeBottomUp(amount, coins);
        long endTime2 = System.nanoTime() - startTime;

        System.out.println("Det minsta antalet mynt som behövs bottom up: " + bottomUp);
        System.out.println("Bottom up tog: " + (double)endTime2/1000000000 + " sekunder");
    }
}
