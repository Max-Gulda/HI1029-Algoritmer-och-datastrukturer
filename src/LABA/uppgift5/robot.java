package LABA.uppgift5;

public class robot {

    private robot(){

    }

    private static int orderPackages(char[] packages, int nrOfMoves){
        if(isCorrect(packages)) return nrOfMoves;
        if (nrOfMoves == 15) return Integer.MAX_VALUE/2;
        int swapFirst = orderPackages(swapFirst(packages), nrOfMoves + 1);
        int putLastFirst = orderPackages(putLastFirst(packages), nrOfMoves + 1);
        return Math.min(swapFirst, putLastFirst);
    }
    public static int orderPackages(char[] packages){
        char[] copyOfPackages = packages.clone();
        return orderPackages(copyOfPackages, 0);
    }
    private static boolean isCorrect(char[] packages){
        return  packages[0] == 'A' &&
                packages[1] == 'B' &&
                packages[2] == 'C' &&
                packages[3] == 'D' &&
                packages[4] == 'E';
    }
    private static char[] swapFirst(char[] packagesToSwap){
        char[] packagesCopy = packagesToSwap.clone();
        char temp = packagesCopy[0];
        packagesCopy[0] = packagesCopy[1];
        packagesCopy[1] = temp;
        return packagesCopy;
    }

    private static char[] putLastFirst(char[] packagesToMove){
        char[] packagesCopy = packagesToMove.clone();
        char temp = packagesCopy[packagesCopy.length - 1];
        for(int i = packagesCopy.length - 1; i > 0; i--){
            packagesCopy[i] = packagesCopy[i-1];
        }
        packagesCopy[0] = temp;
        return packagesCopy;
    }


    public static void main(String[] args) {
        char[] packages = {'B', 'E', 'C', 'A', 'D'};


        System.out.println(orderPackages(packages));
    }
}
