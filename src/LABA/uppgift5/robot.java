package LABA.uppgift5;

public class robot {

    private robot() {
    }

    private static String orderPackages(char[] packages, StringBuilder sb) {
        if (isCorrect(packages)) {
            return sb.toString(); // Return the sequence if the packages are ordered
        }
        if (sb.length() >= 15) return null; // Terminate if the sequence is too long

        // Explore both options and return the best result
        String resultSwap = orderPackages(swapFirst(packages.clone()), new StringBuilder(sb).append("b"));
        String resultPutLast = orderPackages(putLastFirst(packages.clone()), new StringBuilder(sb).append("s"));

        return resultSwap != null && (resultPutLast == null || resultSwap.length() < resultPutLast.length())
                ? resultSwap : resultPutLast;
    }

    public static String orderPackages(char[] packages) {
        return orderPackages(packages, new StringBuilder());
    }

    public static String orderPackages(String letters) {
        char[] temp = letters.toCharArray();
        return orderPackages(temp);
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
        String packages = "EDCBA";
        System.out.println("Moves: " + orderPackages(packages));
        //packages = "EBCAD";
        //System.out.println("Moves: " + orderPackages(packages));
        //packages = "DEBCA";
        //System.out.println("Moves: " + orderPackages(packages));
        //packages = "ADEBC";
        //System.out.println("Moves: " + orderPackages(packages));
        //packages = "CADEB";
        //System.out.println("Moves: " + orderPackages(packages));
        //packages = "ACDEB";
        //System.out.println("Moves: " + orderPackages(packages));
        //packages = "BACDE";
        //System.out.println("Moves: " + orderPackages(packages));
        //packages = "BACED";
        //System.out.println("Moves: " + orderPackages(packages));
    }
}
