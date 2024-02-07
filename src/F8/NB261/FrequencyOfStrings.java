package F8.NB261;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FrequencyOfStrings {

    public static int freqOfMostCommon(String[] strings) {
        HashMap<String, Integer> hMap = new HashMap<>();
        int max = 0;
        for (String str : strings) {
            if (hMap.containsKey(str)) {
                int newMax = hMap.get(str) + 1;
                hMap.put(str, newMax);
                max = Math.max(newMax, max);
            } else {
                hMap.put(str, 1);
                if (max == 0) max = 1;
            }
        }
        return max;
    }

    public static int uniqueStrings(String[] strings){
        HashSet<String> hSet = new HashSet<>(Arrays.asList(strings));
        return hSet.size();
    }

    public static void main(String[] args) {
        String[] list = {"man", "gråter", "när", "man", "tänker", "när"};
        System.out.println(freqOfMostCommon(list));
        System.out.println(uniqueStrings(list));
    }

}
