package LeetCode;

import java.util.HashMap;

public class Roma {
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num > 0){
            if (num >= values[i]){
                sb.append(romanNumerals[i]);
                num-=values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static int romanToInt(String s) {
        int val = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                val += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                val += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println("III = " + intToRoman(3));
        System.out.println("LVIII = " + intToRoman(58));
        System.out.println("MCMXCIV = " + intToRoman(1994));

        System.out.println("MCMXCIV = " + romanToInt("MCMXCIV"));

    }
}
