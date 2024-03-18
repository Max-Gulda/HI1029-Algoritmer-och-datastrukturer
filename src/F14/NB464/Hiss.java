package F14.NB464;

import java.util.Arrays;

public class Hiss {
    static class Result {
        int steps;
        String path;

        public Result(int steps, String path) {
            this.steps = steps;
            this.path = path;
        }
    }

    static Result[] tab;

    public static void elevator(int nrOfFloors, int destination) {
        tab = new Result[nrOfFloors + 1];
        Result result = elevator(nrOfFloors, 1, destination, 0);
        System.out.println("The floor can be reached in : " + result.steps + " steps. Path: " + result.path);
    }

    public static Result elevator(int nrOfFloors, int currentFloor, int destination, int depth) {
        if (destination == currentFloor) {
            return new Result(0, "" + currentFloor);
        }

        if (depth == 30) return new Result(Integer.MAX_VALUE / 2, "");

        if (tab[currentFloor] != null) return tab[currentFloor];

        Result minResult = new Result(38, "");
        int minSteps = minResult.steps;

        if (currentFloor * 3 <= nrOfFloors) {
            Result multiplied = elevator(nrOfFloors, currentFloor * 3, destination, depth + 1);
            if (minSteps > multiplied.steps + 1) {
                minSteps = multiplied.steps + 1;
                minResult = new Result(minSteps, currentFloor + " -> " + multiplied.path);
            }
        }

        if (currentFloor + 7 <= nrOfFloors) {
            Result addSeven = elevator(nrOfFloors, currentFloor + 7, destination, depth + 1);
            if (minSteps > addSeven.steps + 1) {
                minSteps = addSeven.steps + 1;
                minResult = new Result(minSteps, currentFloor + " -> " + addSeven.path);
            }
        }

        if (currentFloor - 5 > 0) {
            Result minusFive = elevator(nrOfFloors, currentFloor - 5, destination, depth + 1);
            if (minSteps > minusFive.steps + 1) {
                minSteps = minusFive.steps + 1;
                minResult = new Result(minSteps, currentFloor + " -> " + minusFive.path);
            }
        }

        if (minResult.steps != Integer.MAX_VALUE / 2) tab[currentFloor] = minResult;

        return minResult;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        elevator(45, 31);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time = " + (double) endTime / 1000000000);
    }
}
