package LABA.uppgift5;

public class robot {

    private robot() {
    }
    private static int orderPackages(char[] packages, int nrOfMoves, StringBuilder sb, StringBuilder bestSequence) {
        if (isCorrect(packages)) {
            if (bestSequence.length() == 0 || sb.length() < bestSequence.length()) {
                bestSequence.setLength(0);
                bestSequence.append(sb);
            }
            return nrOfMoves;
        }
        if (nrOfMoves >= 15) return Integer.MAX_VALUE / 2;

        int moves = Integer.MAX_VALUE / 2;

        StringBuilder sbSwap = new StringBuilder(sb);
        sbSwap.append("b");
        moves = Math.min(moves, orderPackages(swapFirst(packages.clone()), nrOfMoves + 1, sbSwap, bestSequence));

        StringBuilder sbPutLast = new StringBuilder(sb);
        sbPutLast.append("s");
        moves = Math.min(moves, orderPackages(putLastFirst(packages.clone()), nrOfMoves + 1, sbPutLast, bestSequence));

        return moves;
    }

    public static String orderPackages(char[] packages) {
        StringBuilder sb = new StringBuilder();
        StringBuilder bestSequence = new StringBuilder();
        orderPackages(packages, 0, sb, bestSequence);
        return bestSequence.toString();
    }

    private static boolean isCorrect(char[] packages) {
        for (int i = 0; i < packages.length; i++) {
            if (packages[i] != 'A' + i) {
                return false;
            }
        }
        return true;
    }

    private static char[] swapFirst(char[] packagesToSwap) {
        char temp = packagesToSwap[0];
        packagesToSwap[0] = packagesToSwap[1];
        packagesToSwap[1] = temp;
        return packagesToSwap;
    }

    private static char[] putLastFirst(char[] packagesToMove) {
        char temp = packagesToMove[packagesToMove.length - 1];
        for (int i = packagesToMove.length - 1; i > 0; i--) {
            packagesToMove[i] = packagesToMove[i - 1];
        }
        packagesToMove[0] = temp;
        return packagesToMove;
    }

    public static void main(String[] args) {
        char[] packages = {'B', 'E', 'C', 'A', 'D'};
        System.out.println("Moves: " + orderPackages(packages));
    }
}
