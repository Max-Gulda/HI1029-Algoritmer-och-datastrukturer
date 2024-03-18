package F14.NB471;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Marbles {

    private static class marbles {
        private final int nrOfBlue, nrOfWhite, nrOfRed;

        public marbles(int nrOfBlue, int nrOfWhite, int nrOfRed) {
            this.nrOfBlue = nrOfBlue;
            this.nrOfWhite = nrOfWhite;
            this.nrOfRed = nrOfRed;
        }

        public boolean existBlue() {
            return nrOfBlue > 0;
        }

        public boolean existWhite() {
            return nrOfWhite > 0;
        }

        public boolean existRed() {
            return nrOfRed > 0;
        }

        public marbles exchangeBlue() {
            if (!existBlue()) return null;
            return new marbles(nrOfBlue - 1, nrOfWhite + 1, nrOfRed + 3);
        }

        public marbles exchangeWhite() {
            if (!existWhite()) return null;
            return new marbles(nrOfBlue + 2, nrOfWhite - 1, nrOfRed + 4);
        }

        public marbles exchangeRed() {
            if (!existRed()) return null;
            return new marbles(nrOfBlue + 1, nrOfWhite + 5, nrOfRed - 1);
        }

        public boolean done() {
            return nrOfBlue == nrOfRed && nrOfBlue == nrOfWhite;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            marbles m = (marbles) o;
            return nrOfBlue == m.nrOfBlue && nrOfWhite == m.nrOfWhite && nrOfRed ==
                    m.nrOfRed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nrOfBlue, nrOfWhite, nrOfRed);
        }
    }

    public static int marbles(int nrOfRed, int nrOfBlue, int nrOfWhite) {
        return noOfSwaps(new marbles(nrOfBlue, nrOfWhite, nrOfRed), 0, new HashMap<>());
    }

    private static int noOfSwaps(marbles currentMarbles, int swaps, HashMap<marbles, Integer> memo) {
        if (currentMarbles.done()) return 0;
        if (swaps == 50) return Integer.MAX_VALUE / 2;

        if (memo.containsKey(currentMarbles)) {
            System.out.println("Nu fuskar jag");
            return memo.get(currentMarbles);
        }

        int swapRed = Integer.MAX_VALUE, swapBlue = Integer.MAX_VALUE, swapWhite = Integer.MAX_VALUE;


        if (currentMarbles.existRed()) {
            marbles m = new marbles(currentMarbles.nrOfBlue, currentMarbles.nrOfWhite, currentMarbles.nrOfRed);
            m.exchangeRed();
            swapRed = noOfSwaps(m, swaps + 1, memo);
        }
        if (currentMarbles.existBlue()) {
            marbles m = new marbles(currentMarbles.nrOfBlue, currentMarbles.nrOfWhite, currentMarbles.nrOfRed);
            m.exchangeBlue();
            swapBlue = noOfSwaps(m, swaps + 1, memo);
        }
        if (currentMarbles.existWhite()) {
            marbles m = new marbles(currentMarbles.nrOfBlue, currentMarbles.nrOfWhite, currentMarbles.nrOfRed);
            m.exchangeWhite();
            swapWhite = noOfSwaps(m, swaps + 1, memo);
        }

        int min = Math.min(Math.min(swapBlue, swapWhite), swapRed);
        if (min != Integer.MAX_VALUE / 2) memo.put(currentMarbles, min);
        return min;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int blue;
        int red;
        int white;
        do {
            System.out.print("Enter number of blue marbles: ");
            blue = scan.nextInt();
            System.out.print("Enter number of white marbles: ");
            white = scan.nextInt();
            System.out.print("Enter number of red marbles: ");
            red = scan.nextInt();
            System.out.println(marbles(red, blue, white) + " swaps is needed!");
        } while (blue != 0 || red != 0 || white != 0);
    }

}
