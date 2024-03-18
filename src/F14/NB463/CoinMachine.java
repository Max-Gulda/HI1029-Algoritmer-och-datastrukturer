package F14.NB463;

public class CoinMachine {
    private CoinMachine() {
    }

    public static int machine(int points) {
        int result = theMachine2(1, points);
        if (result == Integer.MAX_VALUE / 2) return -1;
        else return result;
    }

    public static int theMachine2(int currentPoints, int pointsToReach) {
        if (currentPoints == pointsToReach) return 0;
        if (currentPoints > pointsToReach) return Integer.MAX_VALUE / 2;

        int addTen = theMachine2(currentPoints * 3, pointsToReach) + 10;
        int addFive = theMachine2(currentPoints + 4, pointsToReach) + 5;

        return Math.min(addTen, addFive);
    }

    static int[] tab;
    public static int machineTab(int points) {
        tab = new int[points];
        int result = theMachineTab(1, points);
        if (result == Integer.MAX_VALUE / 2) return -1;
        else return result;
    }

    public static int theMachineTab(int currentPoints, int pointsToReach) {
        if (currentPoints == pointsToReach) return 0;
        if (currentPoints > pointsToReach) return Integer.MAX_VALUE / 2;
        if(tab[currentPoints] != 0) return tab[currentPoints];
        int addTen = theMachineTab(currentPoints * 3, pointsToReach) + 10;
        int addFive = theMachineTab(currentPoints + 4, pointsToReach) + 5;
        int min = Math.min(addTen, addFive);
        tab[currentPoints] = min;
        return min;
    }
    public static void main(String[] args) {
        int points = 109;
        long startTime = System.nanoTime();
        int result1 = machine(points);
        long elapsedTime1 = System.nanoTime() - startTime;
        System.out.println("Result is : " + result1 + ", and it took : " + (double)elapsedTime1/1000000000);


        startTime = System.nanoTime();
        result1 = machineTab(points);
        elapsedTime1 = System.nanoTime() - startTime;
        System.out.println("Result is : " + result1 + ", and it took : " + (double)elapsedTime1/1000000000);

    }

}
