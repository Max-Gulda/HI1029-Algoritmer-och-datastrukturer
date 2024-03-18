package F14.NB54;

import java.util.HashMap;
import java.util.Map;

public class TSPDynamicProgramming {

    private int n;
    private int[][] distance;
    private Map<String, Integer> memo;
    private Map<String, Integer> nextNode; // To track the next node in the path

    public TSPDynamicProgramming(int[][] distance) {
        this.n = distance.length;
        this.distance = distance;
        this.memo = new HashMap<>();
        this.nextNode = new HashMap<>(); // Initialize the path tracking map
    }

    public void findOptimalTour() {
        long startTime = System.currentTimeMillis();

        int visited = 1; // Starting city visited
        int position = 0; // Start from the first city
        int cost = tsp(position, visited);

        long endTime = System.currentTimeMillis();
        System.out.println("Minimum Cost: " + cost);
        System.out.println("Calculation Time: " + (endTime - startTime) + " ms");

        // Reconstruct and print path
        reconstructPath();
    }

    private int tsp(int position, int visited) {
        String key = position + "," + visited;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (visited == (1 << n) - 1) {
            return distance[position][0]; // Return to starting city
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            if ((mask & visited) == 0) {
                int newVisited = visited | mask;
                int cost = distance[position][i] + tsp(i, newVisited);
                if (cost < minCost) {
                    minCost = cost;
                    nextNode.put(key, i); // Track the next node for this state
                }
            }
        }

        memo.put(key, minCost);
        return minCost;
    }

    private void reconstructPath() {
        int visited = 1;
        int position = 0;
        System.out.print("Path: 0 ");

        for (int i = 1; i < n; i++) {
            String key = position + "," + visited;
            position = nextNode.get(key); // Get the next position based on the tracked path
            visited |= (1 << position);
            System.out.print(position + " ");
        }
        System.out.println("0"); // Return to the starting city
    }

    public static void main(String[] args) {
        // Example distance matrix
        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        TSPDynamicProgramming tsp = new TSPDynamicProgramming(distance);
        tsp.findOptimalTour();
    }
}
