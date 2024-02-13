package F11.NB33;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {

    private static class QueueItem implements Comparable<QueueItem>{
        public int weight;
        public int index;

        public QueueItem(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        @Override
        public int compareTo(QueueItem o) {
            return this.weight - o.weight;
        }
    }

    public static int[] mst(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int[] previous = new int[graph.length];
        Arrays.fill(previous, -1);

        PriorityQueue<QueueItem> queue = new PriorityQueue<>();
        distance[0] = 0;
        queue.offer(new QueueItem(0, 0));

        while (!queue.isEmpty()) {
            QueueItem item = queue.poll();
            int currentIndex = item.index;
            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (int i = 0; i < graph.length; i++) {
                if (graph[currentIndex][i] != Integer.MAX_VALUE &&
                        !visited[i] &&
                        graph[currentIndex][i] < distance[i]) {
                    distance[i] = graph[currentIndex][i];
                    previous[i] = currentIndex;
                    queue.offer(new QueueItem(distance[i], i));
                }
            }
        }
        int hej = 0;
        for (int i :
                distance) {
            hej += i;

        }
        System.out.println("distance = " + hej);
        return previous;
    }


    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] weights = {
                {INF, 2, INF, INF, INF, 1, INF, INF},
                {2, INF, 2, 2, 4, INF, INF, INF},
                {INF, 2, INF, INF, 3, INF, INF, 1},
                {INF, 2, INF, INF, 3, 1, INF, INF},
                {INF, 4, 3, 3, INF, INF, 7, INF},
                {1, INF, INF, 1, INF, INF, 5, INF},
                {INF, INF, INF, INF, 7, 5, INF, 6},
                {INF, INF, 1, INF, INF, INF, 6, INF}
        };

        int[] previous = mst(weights);
        for(int i = 0; i < previous.length; i++){
            if (previous[i]==-1) System.out.println("Nod " + (char)(i+'A') + " var startnod");
            else System.out.println("Nod " + (char)(i+'A') + " kopplas till " + (char)(previous[i] + 'A'));
        }

        System.out.println(Arrays.toString(previous));
    }
}
