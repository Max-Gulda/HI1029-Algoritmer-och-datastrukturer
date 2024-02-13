package TentaPlugg;

import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] streetsEx1 = {
                {'o', 's', 'o', 'o', 'o', 'o'},
                {'o', 'o', 'o', 'o', 's', 's'}, //3 1 5 3 5 4
                {'o', 'o', 'h', 'o', 'o', 'o'},
                {'s', 'o', 'o', 'o', 'o', 's'},
                {'o', 'o', 'o', 's', 'o', 'o'}};
        char[][] streetsEx2 = {
                {'s', 'o', 'o', 'o', 'o', 'o'},
                {'o', 's', 's', 'o', 's', 'o'},
                {'o', 's', 'o', 'o', 'o', 'o'},
                {'o', 'h', 'o', 'o', 'o', 's'}};
        char[][] streetsEx3 = {
                {'s', 'o', 'o', 'o', 'o', 's'},
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'o', 's', 'o', 'o', 'o', 's'},
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'h', 'o', 'o', 'o', 'o', 'o'}};
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx1));
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx2));
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx3));
    }

    private static int shortestPath(char[][] streets) {
        ArrayList<Point> s = new ArrayList<>();
        Point hotel = null;
        for (int i = 0, streetsLength = streets.length; i < streetsLength; i++) {
            char[] cA = streets[i];
            for (int j = 0, cALength = cA.length; j < cALength; j++) {
                char c = cA[j];
                if (c == 'o') continue;
                if (c == 'h') hotel = new Point(i, j);
                else if (c == 's') s.add(new Point(i, j));
            }
        }
        BitSet visited = new BitSet(s.size());
        visited.set(0,s.size(),false);
        if (hotel == null) throw new NoSuchElementException("No hotel?");
        return shortestPath(s, visited, 0, hotel);
    }

    private static int shortestPath(ArrayList<Point> s, BitSet v, int distance, Point previous) {
        if (v.cardinality() == s.size()) return distance;

        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < s.size(); i++) {
            if (v.get(i)) continue;
            Point current = s.get(i);
            //System.out.println("Previous point = (" + previous.x + "," + previous.y + ") current point = (" + current.x + "," + current.y + ")");
            v.set(i, true);
            int dist = Math.abs(previous.x - current.x) + Math.abs(previous.y - current.y);
            dist = shortestPath(s, v, distance + dist, current);
            v.set(i, false);
            shortestDistance = Math.min(dist, shortestDistance);
        }
        return shortestDistance;

    }

}
