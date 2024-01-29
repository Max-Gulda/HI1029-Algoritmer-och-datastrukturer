import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPair(new int[] {3,4,1,7,9,5,3,6},13)));
        System.out.println(Arrays.toString(findPair(new int[] {3,4,1,7,9,5,3,6},14)));
        System.out.println(Arrays.toString(findPair(new int[] {2,4,6,1,7,12,4,3},12)));
        System.out.println(Arrays.toString(findPair(new int[] {2,4,6,7,12,4,3,6},12)));

    }

    private static int[] findPair(int[] a, int sum) {
        HashSet<Integer> map = new HashSet<>();
        for(int num : a){
            int complement = sum - num;
            if (map.contains(complement)){
                return new int[] {complement, num};
            }
            map.add(num);
        }
        return null;
    }
}