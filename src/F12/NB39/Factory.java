package F12.NB39;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Factory {

    private static class Activity implements Comparable<Activity> {
        double start, end;

        public Activity(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ":" + end + "]";
        }

        @Override
        public int compareTo(Activity other) {
            return Double.compare(this.end, other.end);
        }
    }

    public static int findMinimumWorkers(Activity[] activities) {
        Arrays.sort(activities, (a1,a2) -> Double.compare(a1.start, a2.start));

        PriorityQueue<Activity> ongoingActivities = new PriorityQueue<>();
        int maxWorkers = 0;

        for (Activity activity : activities) {
            while (!ongoingActivities.isEmpty() && ongoingActivities.peek().end <= activity.start) {
                ongoingActivities.poll();
            }

            ongoingActivities.add(activity);

            maxWorkers = Math.max(maxWorkers, ongoingActivities.size());
        }

        return maxWorkers;
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1.0, 4.0),
                new Activity(2.0, 5.0),
                new Activity(6.0, 8.0),
                new Activity(3.0, 8.0),
                new Activity(5.0, 7.0)
        };

        int minWorkers = findMinimumWorkers(activities);
        System.out.println("Minsta antalet personer som behövs: " + minWorkers);
    }
}
