package F12.NB36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Scheduler {
    private static class Activity implements Comparable<Activity>{
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return  "start = " + Integer.toString(start) + ", end = " + Integer.toString(end);
        }

        @Override
        public int compareTo(Activity o) {
            if(o == null) throw new NullPointerException();
            return Integer.compare(this.end, o.end);
        }
    }

    public static void planner(List<Activity> activityList) {
        List<Activity> sortedActivities = new ArrayList<>(activityList);
        Collections.sort(sortedActivities);

        List<Activity> selectedActivities = new ArrayList<>();
        Activity lastAdded = null;

        for (Activity currentActivity : sortedActivities) {
            if (lastAdded == null || currentActivity.start >= lastAdded.end) {
                selectedActivities.add(currentActivity);
                lastAdded = currentActivity;
            }
        }

        for (Activity a : selectedActivities) {
            System.out.println(a);
        }
    }


    public static void main(String[] args) {
        List<Activity> a = new ArrayList<>();
        a.add(new Activity(0, 3));
        a.add(new Activity(0, 4));
        a.add(new Activity(0, 1));
        a.add(new Activity(2, 4));
        planner(a);
    }
}
