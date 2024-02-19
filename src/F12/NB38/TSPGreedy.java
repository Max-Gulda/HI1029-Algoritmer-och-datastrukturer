package F12.NB38;

import java.util.ArrayList;
import java.util.BitSet;

public class TSPGreedy {
    private int numberOfCities;
    private double[][] distanceMatrix;
    private BitSet visitedCities;
    private ArrayList<Integer> path;
    private double totalDistance;

    public TSPGreedy( double[][] distanceMatrix) {
        this.numberOfCities = distanceMatrix.length;
        this.distanceMatrix = distanceMatrix;
        this.visitedCities = new BitSet(numberOfCities);
        this.path = new ArrayList<>(numberOfCities);
        this.totalDistance = 0;
        this.solve();
    }

    public void solve() {
        int currentCity = 0;
        visitedCities.set(currentCity);
        path.add(currentCity);

        for (int i = 1; i < numberOfCities; i++) {
            int nearestCity = findNearestCity(currentCity);
            visitedCities.set(nearestCity);
            path.add(nearestCity);
            totalDistance += distanceMatrix[currentCity][nearestCity];
            currentCity = nearestCity;
        }
    }

    private int findNearestCity(int currentCity) {
        double minDistance = Double.MAX_VALUE;
        int nearestCity = -1;
        for (int i = 0; i < numberOfCities; i++) {
            if (!visitedCities.get(i) && distanceMatrix[currentCity][i] < minDistance) {
                minDistance = distanceMatrix[currentCity][i];
                nearestCity = i;
            }
        }
        return nearestCity;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : path) {
            sb.append((char) (integer + 'A')).append(" -> ");
        }
        sb.delete(sb.length()-4, sb.length());
        return sb.toString();
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public static void main(String[] args) {
        double[][] distances = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        TSPGreedy tsp = new TSPGreedy(distances);
        System.out.println("Path: " + tsp.getPath());
        System.out.println("Total distance: " + tsp.getTotalDistance());
    }
}

