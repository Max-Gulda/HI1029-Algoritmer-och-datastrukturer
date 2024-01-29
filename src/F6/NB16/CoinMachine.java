package F6.NB16;

import java.util.LinkedList;
import java.util.Queue;

public class CoinMachine {
    private CoinMachine(){}


    public static int machine(int points){
        int result = theMachine(1, points, 0);
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
    }

    private static int theMachine(int currentPoints, int pointsToReach, int moneySpent){
        if(currentPoints == pointsToReach) return moneySpent;
        if(currentPoints > pointsToReach) return Integer.MAX_VALUE;
        int addTen = theMachine(currentPoints * 3, pointsToReach, moneySpent + 10);
        int addFive = theMachine(currentPoints + 4, pointsToReach, moneySpent +  5);

        return Math.min(addTen, addFive);
    }

    public static int theMachineImproved(int pointsToReach){
        //if(currentPoints == pointsToReach) return moneySpent;
        Queue<machine> queue = new LinkedList<>();
        queue.offer(new machine(1,0));
        machine scenario;
        while(!queue.isEmpty()){
            scenario = queue.poll();
            if(scenario.currentPoints == pointsToReach) return scenario.moneySpent;
            if(scenario.currentPoints > pointsToReach) continue;
            queue.offer(new machine(scenario.currentPoints * 3, scenario.moneySpent + 10));
            queue.offer(new machine(scenario.currentPoints + 4,  scenario.moneySpent + 5));
        }
        return -1;
    }

    private static class machine{
        public int currentPoints,  moneySpent;

        public machine(int currentPoints, int moneySpent) {
            this.currentPoints = currentPoints;
            this.moneySpent = moneySpent;
        }
    }
}
