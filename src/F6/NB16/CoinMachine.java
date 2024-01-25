package F6.NB16;

import java.util.LinkedList;
import java.util.Queue;

public class CoinMachine {
    private CoinMachine(){}

    private static class State {
        public int moneySpent,currentPoints;
        public State(int m, int p){
            moneySpent = m;
            currentPoints = p;
        }
    }

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

    public static int machineImproved(int points){
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 1));
        while(!q.isEmpty()){
            State s = q.poll();
            if(s.currentPoints == points) return s.moneySpent;
            if(s.currentPoints > points) continue;
            q.offer(new State(s.moneySpent + 10, s.currentPoints * 3));
            q.offer(new State(s.moneySpent + 5, s.currentPoints + 4));
        }
        return -1;
    }
}
