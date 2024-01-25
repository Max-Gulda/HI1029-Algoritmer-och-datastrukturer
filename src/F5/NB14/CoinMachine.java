package F5.NB14;

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
}
