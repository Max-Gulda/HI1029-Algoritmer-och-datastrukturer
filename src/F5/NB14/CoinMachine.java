package F5.NB14;

public class CoinMachine {
    private CoinMachine(){}

    public static int machine(int points){
        int result = theMachine(1, points, 0);
        if(result == Integer.MAX_VALUE / 2) return -1;
        else return result;
    }

    private static int theMachine(int currentPoints, int pointsToReach, int moneySpent){
        if(currentPoints == pointsToReach) return moneySpent;
        if(currentPoints > pointsToReach) return Integer.MAX_VALUE / 2;
        int addTen = theMachine(currentPoints * 3, pointsToReach, moneySpent + 10);
        int addFive = theMachine(currentPoints + 4, pointsToReach, moneySpent +  5);

        return Math.min(addTen, addFive);
    }

    public static int theMachine2(int currentPoints, int pointsToReach) {
        if (currentPoints == pointsToReach) return 0;
        if (currentPoints > pointsToReach) return Integer.MAX_VALUE / 2;

        int addTen = theMachine2(currentPoints * 3, pointsToReach) + 10;
        int addFive = theMachine2(currentPoints + 4, pointsToReach) + 5;

        return Math.min(addTen, addFive);
    }

}
