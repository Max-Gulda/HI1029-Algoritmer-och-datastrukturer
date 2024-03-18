package F14.NB50;

public class GridPaths {

    private static int[][] dp;
    public static int countUniquePaths(int m, int n, boolean useDP) {
        dp = new int[m+1][n+1];
        return countPaths(m, n, useDP);
    }

    private static int countPaths(int row, int col, boolean useDP) {
        if (row == 0 && col == 0) {
            return 1;
        }

        if(dp[row][col] != 0){
            return dp[row][col];
        }

        int paths = 0;
        if (col > 0) {
            paths += countPaths(row, col - 1, useDP);
        }
        if (row > 0) {
            paths += countPaths(row - 1, col, useDP);
        }
        if(useDP){
            dp[row][col] = paths;
        }
        return paths;
    }

    public static void main(String[] args) {
        int m = 12; // Antalet rader.
        int n = 12; // Antalet kolumner.
        long startTime = System.nanoTime();
        int NrOfPaths = countUniquePaths(m, n, true);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Antal unika vägar: " + NrOfPaths + " with dp it took: " + (double)endTime/1000000000 + "s");

        startTime = System.nanoTime();
        NrOfPaths = countUniquePaths(m, n, false);
        endTime = System.nanoTime() - startTime;

        System.out.println("Antal unika vägar: " + NrOfPaths + " without dp it took: "+ (double)endTime/1000000000 + "s");
    }
}

