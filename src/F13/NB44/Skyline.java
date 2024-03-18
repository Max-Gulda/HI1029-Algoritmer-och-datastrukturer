package F13.NB44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Skyline {
    private static class House {
        public int x1, x2, y1;

        public House(int x1, int x2, int y1) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
        }
    }

    // Entry point to start the divide-and-conquer algorithm
    public static ArrayList<int[]> computeSkyline(ArrayList<House> houses) {
        Collections.sort(houses, Comparator.comparingInt(a -> a.x1));
        return skyLine(houses, 0, houses.size() - 1);
    }

    // Recursive function to compute the skyline
    private static ArrayList<int[]> skyLine(ArrayList<House> houses, int left, int right) {
        if (left == right) {
            ArrayList<int[]> result = new ArrayList<>();
            House house = houses.get(left);
            // Starting point of the house
            result.add(new int[]{house.x1, house.y1});
            // Ending point of the house
            result.add(new int[]{house.x2, 0});
            return result;
        }

        int mid = (left + right) / 2;
        ArrayList<int[]> leftSkyline = skyLine(houses, left, mid);
        ArrayList<int[]> rightSkyline = skyLine(houses, mid + 1, right);
        return merge(leftSkyline, rightSkyline);
    }

    // Merge two skylines
    private static ArrayList<int[]> merge(ArrayList<int[]> left, ArrayList<int[]> right) {
        ArrayList<int[]> result = new ArrayList<>();
        int currentHeightLeft = 0, currentHeightRight = 0;
        int height = 0;
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            int x, newHeight;
            if (left.get(i)[0] < right.get(j)[0]) {
                x = left.get(i)[0];
                currentHeightLeft = left.get(i)[1];
                i++;
            } else if (left.get(i)[0] > right.get(j)[0]) {
                x = right.get(j)[0];
                currentHeightRight = right.get(j)[1];
                j++;
            } else {
                x = left.get(i)[0];
                currentHeightLeft = left.get(i)[1];
                currentHeightRight = right.get(j)[1];
                i++;
                j++;
            }
            newHeight = Math.max(currentHeightLeft, currentHeightRight);

            if (result.isEmpty() || newHeight != height) {
                result.add(new int[]{x, newHeight});
                height = newHeight;
            }
        }

        // Append the rest of the left and right skylines
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    // Print the skyline visually
    public static void printSkyline(ArrayList<int[]> skyline) {
        int maxHeight = 0;
        for (int[] point : skyline) {
            maxHeight = Math.max(maxHeight, point[1]);
        }

        int maxWidth = skyline.get(skyline.size() - 1)[0];

        char[][] grid = new char[maxHeight][maxWidth];

        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }

        int currentHeight = 0;
        for (int i = 0; i < skyline.size(); i++) {
            int[] point = skyline.get(i);
            int nextX = (i + 1 < skyline.size()) ? skyline.get(i + 1)[0] : point[0];

            for (int y = maxHeight - 1; y >= maxHeight - point[1]; y--) {
                for (int x = point[0]; x < nextX; x++) {
                    grid[y][x] = '*';
                }
            }

            currentHeight = point[1];
        }

        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        ArrayList<House> houses = new ArrayList<>();
        houses.add(new House(1, 5, 3));
        houses.add(new House(2, 7, 6));
        houses.add(new House(3, 9, 8));
        houses.add(new House(12, 16, 7));
        houses.add(new House(7, 18, 2));
        ArrayList<int[]> skyline = computeSkyline(houses);
        printSkyline(skyline);
    }
}
