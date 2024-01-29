package LABA.uppgift4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport {
    static Queue<Integer> landingQueue, takeOffQueue;

    private static final int CONVERT_YEAR_TO_5_MINUTES_INTERVALS = (int) (60 * 24 * 365.25 / 5);
    private static final double LANDING_PROBABILITY = 0.05;
    private static final double TAKEOFF_PROBABILITY = 0.05;
    private static final int LANDING_TIME = 20 / 5;
    private static final int TAKEOFF_TIME = 20 / 5;

    public static void airportSimulation(int years){

        int currentTime = 0;
        int landings = 0;
        int takeoffs = 0;
        int landingWaitTime = 0;
        int takeoffWaitTime = 0;
        int nextAvailableTime = 0;

        landingQueue = new LinkedList<>();
        takeOffQueue = new LinkedList<>();

        int simulationDuration = years * CONVERT_YEAR_TO_5_MINUTES_INTERVALS;
        Random rand = new Random();

        while(currentTime < simulationDuration) {
            if(rand.nextDouble() < LANDING_PROBABILITY){
                landingQueue.offer(currentTime);
            }
            if(rand.nextDouble() < TAKEOFF_PROBABILITY){
                takeOffQueue.offer(currentTime);
            }
            if(!landingQueue.isEmpty() && currentTime >= nextAvailableTime){
                int planeArrivalTime = landingQueue.poll();
                landings++;
                landingWaitTime += currentTime - planeArrivalTime;
                nextAvailableTime = currentTime + LANDING_TIME;
            } else if (!takeOffQueue.isEmpty() && currentTime >= nextAvailableTime) {
                int planeArrivalTime = takeOffQueue.poll();
                takeoffs++;
                takeoffWaitTime += currentTime - planeArrivalTime;
                nextAvailableTime = currentTime + TAKEOFF_TIME;
            }
            currentTime++;
        }
        double averageLiftWait = ((double)takeoffWaitTime / takeoffs) * 5;
        double averageLandWait = ((double)landingWaitTime / landings) * 5;

        System.out.println("Genomsnittlig väntetid för landning: " + averageLandWait + " min");
        System.out.println("Genomsnittlig väntetid för start: " + averageLiftWait + " min");
    }
    public static void main(String[] args) {
        airportSimulation(10);
    }
}
