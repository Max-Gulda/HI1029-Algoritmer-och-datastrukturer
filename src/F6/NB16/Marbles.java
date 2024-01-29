package F6.NB16;

import java.util.LinkedList;
import java.util.Queue;

public class Marbles {
    private static class Task{
        int nrOfRed, nrOfBlue, nrOfWhite,swaps;

        public Task(int nrOfRed, int nrOfBlue, int nrOfWhite, int swaps) {
            this.nrOfRed = nrOfRed;
            this.nrOfBlue = nrOfBlue;
            this.nrOfWhite = nrOfWhite;
            this.swaps = swaps;
        }
    }
    private static Queue<Task> queue;
    private Marbles(){}

    public static int marbles(int nrOfRed, int nrOfBlue, int nrOfWhite){
        return noOfSwaps(nrOfRed,nrOfBlue,nrOfWhite,0);
    }

    private static int noOfSwaps(int nrOfRed, int nrOfBlue, int nrOfWhite, int swaps){
        if(nrOfRed == nrOfBlue && nrOfWhite == nrOfBlue || swaps == 15) return swaps;

        int swapRed = nrOfRed > 0 ? noOfSwaps(nrOfRed-1, nrOfBlue + 1, nrOfWhite +5, swaps + 1) : Integer.MAX_VALUE;
        int swapBlue = nrOfBlue > 0 ? noOfSwaps(nrOfRed + 3, nrOfBlue -1, nrOfWhite + 1, swaps + 1) : Integer.MAX_VALUE;
        int swapWhite = nrOfWhite > 0 ? swapWhite = noOfSwaps(nrOfRed+4, nrOfBlue+2, nrOfWhite - 1, swaps + 1) : Integer.MAX_VALUE;

        return Math.min(Math.min(swapBlue, swapWhite), swapRed);
    }

    public static int marblesImproved(int nrOfRed, int nrOfBlue, int nrOfWhite){
        queue = new LinkedList<>();
        queue.offer(new Task(nrOfRed, nrOfBlue, nrOfWhite, 0));
        Task task;
        while(!queue.isEmpty()){
            task = queue.poll();
            if(task.swaps > 15) return Integer.MAX_VALUE;
            if(task.nrOfBlue == task.nrOfRed && task.nrOfRed == task.nrOfWhite) return task.swaps;
            if (task.nrOfRed > 0) queue.offer(new Task(task.nrOfRed-1, task.nrOfBlue+1, task.nrOfWhite+5, task.swaps + 1));
            if (task.nrOfBlue > 0) queue.offer(new Task(task.nrOfRed + 3, task.nrOfBlue - 1, task.nrOfWhite + 1, task.swaps + 1));
            if (task.nrOfWhite > 0) queue.offer(new Task(task.nrOfRed +4, task.nrOfBlue+2, task.nrOfWhite - 1, task.swaps + 1));
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(marblesImproved(0,2,5));
    }
}
