package F13.NB45;

import java.util.Arrays;
import java.util.HashMap;

public class Majority {

    public static int findMajority(int[] a) {
        Arrays.sort(a);
        return findMajority(a, 0, a.length - 1);
    }

    private static int findMajority(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int mid = (left + right) / 2;
        int leftMajority = findMajority(a,left,mid);
        int rightMajority = findMajority(a,mid+1,right);

        if(leftMajority==rightMajority) return leftMajority;

        int leftCount = countFrequency(a,leftMajority,left,right);
        int rightCount = countFrequency(a,rightMajority,left,right);

        if(leftCount > (right-left + 1)/2){
            return leftMajority;
        }else if(rightCount > (right-left + 1)/2){
            return rightMajority;
        }else {
            return -1;
        }
    }

    private static int countFrequency(int[] a,int number, int left, int right){
        int times = 0;
        for(int i = left; i < right; i++){
            if(a[i] == number) times++;
        }
        return times;
    }
    public static int findMajorityN(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) > a.length / 2) {
                    return i;
                }
            } else {
                map.put(i, 1);
            }
        }
        return -1;
    }

    public static int findMajorityFastest(int[] a){
        int currentMax = a[0];
        int nrOfTimes = 1;
        for (int i = 1; i < a.length; i++) {
            if (currentMax == a[i]) {
                nrOfTimes++;
            } else {
                nrOfTimes--;
            }
            if (nrOfTimes == 0) {
                currentMax = a[i];
                nrOfTimes = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == currentMax) {
                count++;
            }
        }
        if (count > a.length / 2) {
            return currentMax;
        } else {
            return -1;
        }
    }



    public static void main(String[] args) {
        int[] list = {1, 1, 1, 2, 2, 3, 3, 7, 8, 9, 1, 1, 1, 1, 1};
        int result = findMajority(list);
        System.out.println(result);
    }
}
