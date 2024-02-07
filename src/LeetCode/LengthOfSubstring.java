package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfSubstring {
    public static int lengthOfLongestSubstring(String s, int h) { //70,62
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            map.put(c, end);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringHelper(s, 0, s.length());
    }

    private static int lengthOfLongestSubstringHelper(String s, int start, int end) {
        if (start >= end) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                return Math.max(i - start, lengthOfLongestSubstringHelper(s, map.get(c) + 1, end));
            }
            map.put(c, i);
        }
        return end - start;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
