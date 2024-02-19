package F13.NB42;

import java.util.*;

public class PointMath {
    private static class Fpoint {
        public float x;
        public float y;

        public Fpoint(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float distance(Fpoint o){
            return (float) Math.sqrt((this.x - o.x)*(this.x - o.x) + (this.y - o.y)*(this.y - o.y));
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + ']';
        }
    }

    public static float minDistance(Fpoint[] a) {
        Fpoint[] xSort = Arrays.copyOf(a, a.length);
        Arrays.sort(xSort, (b, c) -> Float.compare(b.x, c.x));

        return minDistance(xSort, 0, a.length - 1);
    }


    private static float minDistance(Fpoint[] xSort, int left, int right) {
        if (right - left == 1) return xSort[left].distance(xSort[right]);
        if (right - left == 2) {
            float dist1 = xSort[left].distance(xSort[left + 1]);
            float dist2 = xSort[left + 1].distance(xSort[right]);
            float dist3 = xSort[left].distance(xSort[right]);
            return Math.min(dist1, Math.min(dist2, dist3));
        }

        int mid = (left + right) / 2;
        float leftMin = minDistance(xSort, left, mid);
        float rightMin = minDistance(xSort, mid + 1, right);
        float d = Math.min(leftMin, rightMin);


        ArrayList<Fpoint> temp = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(xSort[i].x - xSort[mid].x) < d) {
                temp.add(xSort[i]);
            }
        }

        temp.sort((a, b) -> Float.compare(a.y, b.y));

        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if(temp.get(j).y - temp.get(i).y > d) break;
                float dist = temp.get(i).distance(temp.get(j));
                if (dist < d) {
                    d = dist;
                }
            }
        }

        return d;
    }

    public static float calcDistNSquare(Fpoint[] a){
        float min = Float.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                min = Math.min(a[i].distance(a[j]), min);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        Fpoint[] points = new Fpoint[5];

        while (true) {
            System.out.print("Enter number of points: ");
            int nrOfPoints = scan.nextInt();
            if (nrOfPoints == 0) break;
            else {
                points = new Fpoint[nrOfPoints];
                for (int i = 0; i < nrOfPoints; i++) {
                    points[i] = new Fpoint(rand.nextFloat() * 2 - 1, rand.nextFloat() * 2 - 1);
                }
                System.out.println("List of points is: " + Arrays.toString(points));
                System.out.println("Minimum distance is: " + minDistance(points));
                System.out.println("Min distance is: " + calcDistNSquare(points));
            }
        }

        System.out.println("Closing simulation...");
    }
}
