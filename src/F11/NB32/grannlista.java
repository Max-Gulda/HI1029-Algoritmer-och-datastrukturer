package F11.NB32;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class grannlista {
    private HashMap<Character, List<Node>> adjacencyList;

    private class Node {
        public int to;
        public int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public grannlista(String fileName) throws FileNotFoundException {
        adjacencyList = new HashMap<>();
        readGraphFromFile(fileName);
    }

    private void readGraphFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(" ");
            char from = parts[0].charAt(0);
            int to = (int) (parts[1].charAt(0) - 'A');
            int cost = Integer.parseInt(parts[2]);
            if (adjacencyList.containsKey(from)) {
                adjacencyList.get(from).add(new Node(to, cost));
            } else {
                List<Node> temp = new ArrayList<>();
                temp.add(new Node(to, cost));
                adjacencyList.put(from, temp);
            }
        }
        scan.close();
    }

    public String shortestPath(char startNodeChar, char endNodeChar) {
        int startNode = startNodeChar - 'A';
        int endNode = endNodeChar - 'A';

        int[] distances = new int[adjacencyList.size()];
        int[] predecessors = new int[adjacencyList.size()];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);
        distances[startNode] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentNodeIndex = currentNode.to;

            if (adjacencyList.containsKey((char) (currentNodeIndex + 'A'))) {
                for (Node neighbor : adjacencyList.get((char) (currentNodeIndex + 'A'))) {
                    int newDist = distances[currentNodeIndex] + neighbor.cost;
                    if (newDist < distances[neighbor.to]) {
                        distances[neighbor.to] = newDist;
                        predecessors[neighbor.to] = currentNodeIndex;
                        queue.add(new Node(neighbor.to, newDist));
                    }
                }
            }
        }

        if (distances[endNode] == Integer.MAX_VALUE) {
            return "No path exists";
        } else {
            StringBuilder path = new StringBuilder();
            for (int at = endNode; at != -1; at = predecessors[at]) {
                path.append(" >- ").append((char)(at + 'A'));
            }
            path.delete(0,4);
            path = path.reverse();
            path.append(" (Length = ").append(distances[endNode]).append(")");
            return path.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, List<Node>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            for (Node n : entry.getValue()) {
                sb.append("(").append((char) ('A' + n.to)).append(",").append(n.cost).append(") ");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        grannlista g = new grannlista("src/F11/NB32/test.txt");
        System.out.println(g);
        System.out.println(g.shortestPath('A', 'C'));

    }


}
