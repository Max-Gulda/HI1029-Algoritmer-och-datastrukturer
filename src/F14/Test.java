package F14;

public class Test {
    private static class Vara {
        public int pris, vikt;

        public Vara(int pris, int vikt) {
            this.vikt = vikt;
            this.pris = pris;
        }
    }

    public static int kappsäck(int vikt, Vara[] varor) {
        int[][] dp = new int[varor.length+1][vikt + 1];

        for (int i = 0; i <= varor.length; i++) {
            for (int j = 0; j <= vikt; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (varor[i - 1].vikt <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - varor[i - 1].vikt] + varor[i - 1].pris);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[varor.length][vikt];
    }

    public static void main(String[] args) {
        Vara[] varor = {
                new Vara(60, 10), // Pris 60, Vikt 10
                new Vara(100, 20), // Pris 100, Vikt 20
                new Vara(120, 30)  // Pris 120, Vikt 30
        };

        int viktKapacitet = 50;

        int maximaltVarde = kappsäck(viktKapacitet, varor);

        System.out.println("Det maximala värdet som kan uppnås är: " + maximaltVarde);
    }
}
