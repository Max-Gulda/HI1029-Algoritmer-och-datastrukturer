package LABA.uppgift6;

import java.util.LinkedList;
import java.util.Queue;

public class robot {

    private static class Task {
        public char[] array;
        public int nrOfMoves;
        public StringBuilder moves;
        public Task(char[] array, int nrOfMoves, StringBuilder moves) {
            this.array = array;
            this.nrOfMoves = nrOfMoves;
            this.moves = moves;
        }
    }
    public static int orderPackages(char[] packages) {
        Queue<Task> queue = new LinkedList<>();
        queue.offer(new Task(packages, 0, new StringBuilder()));
        Task task;
        while (!queue.isEmpty()) {
            task = queue.poll();
            if (isCorrect(task.array)){
                System.out.println(task.moves.toString());
                return task.nrOfMoves;
            }
            if (task.nrOfMoves > 15) break;
            StringBuilder b = new StringBuilder(task.moves);
            b.append("B");
            StringBuilder s = new StringBuilder(task.moves);
            s.append("S");
            queue.offer(new Task(swapFirst(task.array), task.nrOfMoves + 1, b));
            queue.offer(new Task(putLastFirst(task.array), task.nrOfMoves + 1, s));
        }
        return -1;
    }

    public static int orderPackages(String packages){
        return orderPackages(packages.toCharArray());
    }

    private static boolean isCorrect(char[] packages) {
        return packages[0] == 'A' &&
                packages[1] == 'B' &&
                packages[2] == 'C' &&
                packages[3] == 'D' &&
                packages[4] == 'E';
    }

    private static char[] swapFirst(char[] packagesToSwap) {
        char[] packagesCopy = packagesToSwap.clone();
        char temp = packagesCopy[0];
        packagesCopy[0] = packagesCopy[1];
        packagesCopy[1] = temp;
        return packagesCopy;
    }

    private static char[] putLastFirst(char[] packagesToMove) {
        char[] packagesCopy = packagesToMove.clone();
        char temp = packagesCopy[packagesCopy.length - 1];
        for (int i = packagesCopy.length - 1; i > 0; i--) {
            packagesCopy[i] = packagesCopy[i - 1];
        }
        packagesCopy[0] = temp;
        return packagesCopy;
    }


    public static void main(String[] args) {
        char[] packages = {'E', 'D', 'C', 'B', 'A'};
        System.out.println("EDCBA takes " + orderPackages(packages) + " number of moves\n");

        //packages = new char[]{'B', 'A', 'C', 'D', 'E'};
        //System.out.println("BACDE takes " + orderPackages(packages) + " number of moves\n");
//
        //System.out.println("ABCDE takes " + orderPackages("ABCDE") + " number of moves\n");
    }
}
