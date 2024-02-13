package F11.Djikstra;

import java.util.Arrays;
import java.util.HashSet;

public class Djik {

    public static int[] grafDjikstra(int[][] w) {
        int[] d = new int[w.length];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        int[] p = new int[w.length];

        boolean[] taken = new boolean[w.length];
        Arrays.fill(taken, false);

        for (int count = 0; count < w.length; count++) {
            int nodeIndex = findMinIndex(d, taken);
            taken[nodeIndex] = true;

            for (int i = 0; i < w.length; i++) {
                if (w[nodeIndex][i] < Integer.MAX_VALUE && d[i] > d[nodeIndex] + w[nodeIndex][i]) {
                    d[i] = d[nodeIndex] + w[nodeIndex][i];
                    p[i] = nodeIndex;
                }
            }
        }
        printDistance(d, p);
        return d;
    }

    private static void printDistance(int[] d, int[] p) {
        for (int i = 0; i < d.length; i++) {
            char node = (char) ('A' + i);
            char via = (char) ('A' + p[i]);
            System.out.println("Nod " + node + " har avstånd " + d[i] + " till nod A via " + via);
        }
    }

    private static int findMinIndex(int[] d, boolean[] taken) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < d.length; i++) {
            if (!taken[i] && d[i] <= min) {
                min = d[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int[][] w = {{x, 2, x, x, x, 1, x, x},
                {2, x, 2, 2, 4, x, x, x},
                {x, 2, x, x, 3, x, x, 1},
                {x, 2, x, x, 3, 1, x, x},
                {x, 4, 3, 3, x, x, 7, x},
                {1, x, x, 1, x, x, 5, x},
                {x, x, x, x, 7, 5, x, 6},
                {x, x, 1, x, x, x, 6, x}};
        int[] result = grafDjikstra(w);
        System.out.println(Arrays.toString(result));
    }
}
