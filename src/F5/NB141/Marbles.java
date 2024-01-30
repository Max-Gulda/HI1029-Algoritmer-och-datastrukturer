package F5.NB141;

import java.util.Scanner;

public class Marbles {
    private Marbles(){}

    public static int marbles(int nrOfRed, int nrOfBlue, int nrOfWhite){
        return noOfSwaps(nrOfRed,nrOfBlue,nrOfWhite,0);
    }
    private static int noOfSwaps(int nrOfRed, int nrOfBlue, int nrOfWhite, int swaps){
        if(nrOfRed == nrOfBlue && nrOfWhite == nrOfBlue || swaps == 15) return swaps;

        int swapRed = nrOfRed       > 0 ? noOfSwaps(nrOfRed - 1, nrOfBlue + 1, nrOfWhite + 5, swaps + 1) : Integer.MAX_VALUE;
        int swapBlue = nrOfBlue     > 0 ? noOfSwaps(nrOfRed + 3, nrOfBlue - 1, nrOfWhite + 1, swaps + 1) : Integer.MAX_VALUE;
        int swapWhite = nrOfWhite   > 0 ? noOfSwaps(nrOfRed + 4, nrOfBlue + 2, nrOfWhite - 1, swaps + 1) : Integer.MAX_VALUE;

        return Math.min(Math.min(swapBlue, swapWhite), swapRed);
    }

}
