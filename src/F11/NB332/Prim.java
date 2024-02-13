package F11.NB332;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prim {

    private static class QueueItem implements Comparable<QueueItem> {
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

    private static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] mst(ArrayList<ArrayList<Edge>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int[] previous = new int[graph.size()];
        Arrays.fill(previous, -1);

        PriorityQueue<QueueItem> queue = new PriorityQueue<>();
        distance[0] = 0;
        queue.offer(new QueueItem(0, 0));
        while(queue.size() != 0){
            QueueItem item = queue.poll();
            int currentIndex = item.index;
            if(visited[currentIndex]) continue;
            visited[currentIndex] = true;
            for(Edge e: graph.get(currentIndex)){
                if(!visited[e.to] && e.weight < distance[e.to]){
                    distance[e.to] = e.weight;
                    previous[e.to] = currentIndex;
                    queue.offer(new QueueItem(e.weight, e.to));
                }
            }
        }
        int minDist = 0;
        for(int i : distance){
            minDist += i;
        }
        System.out.println("Totalvikt: " + minDist);
        return previous;
    }


    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

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

        // Initiera grannlistan med tomma listor för varje nod
        for (int i = 0; i < weights.length; i++) {
            graph.add(new ArrayList<>());
        }

        // Konvertera viktmatrisen till en grannlista
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                if (weights[i][j] != INF) {
                    graph.get(i).add(new Edge(j, weights[i][j]));
                }
            }
        }

        // Kör MST algoritmen med grannlistan
        int[] previous = mst(graph);
        for (int i = 0; i < previous.length; i++) {
            if (previous[i] == -1) System.out.println("Nod " + (char) (i + 'A') + " var startnod");
            else System.out.println("Nod " + (char) (i + 'A') + " kopplas till " + (char) (previous[i] + 'A'));
        }
    }
}
