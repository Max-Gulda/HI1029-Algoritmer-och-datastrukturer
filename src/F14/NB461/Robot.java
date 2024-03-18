package F14.NB461;

import java.util.HashMap;

public class Robot {

    private static HashMap<String, String> memo;

    public static String robotMachine(String letters) {
        memo = new HashMap<>();
        return orderPackages(letters, 0);
    }

    private static String orderPackages(String letters, int moves) {
        if (letters.equals("ABCDE")) return "";
        if(moves == 15) return "men detta går ju inte kalle!";

        if(memo.containsKey(letters)) return memo.get(letters);

        String swapFirstMoves = swapFirst(letters);
        String putLastFirstMoves = putLastFirst(letters);

        String resultSwap = orderPackages(swapFirstMoves, moves + 1) + 's';
        String resultPutLast = orderPackages(putLastFirstMoves, moves + 1) + 'b';

        String shortestPath = resultSwap.length() < resultPutLast.length() ? resultSwap : resultPutLast;
        if(shortestPath.length() < 16) memo.put(letters,shortestPath);

        return shortestPath;
    }


    private static String putLastFirst(String letters) {
        return letters.charAt(4) + letters.substring(0, 4);
    }

    private static String swapFirst(String letters) {
        return letters.charAt(1) + "" + letters.charAt(0) + letters.substring(2);
    }

    public static void main(String[] args) {
        String packages = "BECAD";
        long startTime = System.nanoTime();
        String moves = robotMachine(packages);
        System.out.println("Moves: " + moves + ", Length: " + moves.length());
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time = " + (double)elapsedTime/1000000000);
    }
}
