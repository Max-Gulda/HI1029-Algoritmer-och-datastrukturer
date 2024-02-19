package F12.NB40;

import java.util.Arrays;
import java.util.Random;

public class NNumbers {

    public static int findMinimumIntervals(double[] points){
        Arrays.sort(points);
        double coverage = 0;
        int nrOfIntervals = 0;
        for(double i: points){
            if(i == 0 || i > coverage){
                coverage = i + 2;
                nrOfIntervals++;
            }
        }
        return nrOfIntervals;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10; // Antal punkter
        double[] points = new double[n];

        // Generera slumpmässiga punkter
        for (int i = 0; i < n; i++) {
            points[i] = rand.nextDouble() * 100; // Punkter mellan 0 och 100
        }



        int intervals = findMinimumIntervals(points);
        System.out.println("Punkter: " + Arrays.toString(points));
        System.out.println("Minsta antal intervall: " + intervals);
    }

    //Genom att placera ett intervall som börjar vid varje ny oöverlappad punkt och
    // sträcker sig 2,0 längdenheter framåt, garanterar vi att vi täcker den punkten
    // plus eventuella omedelbart efterföljande punkter som också passar inom samma intervall.
}
