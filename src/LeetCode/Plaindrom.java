package LeetCode;

import java.util.HashSet;

public class Plaindrom {

    public static boolean isPalindrom(int x){
        String number = Integer.toString(x);
        int right = number.length() - 1;
        for(int left = 0; left < number.length(); left++){
            if(right == left){
                return true;
            }
            if(number.charAt(left) != number.charAt(right - left)){
                return false;
            }
        }
        return true;
    }

    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        Object[] list = set.toArray();
        //nums = (int[]) list;
        return nums.length;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrom(121));
        System.out.println(isPalindrom(-121));
        System.out.println(isPalindrom(10));
    }
}
