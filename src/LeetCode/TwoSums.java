package LeetCode;

import java.util.HashMap;

public class TwoSums {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] list = new int[]{2,7,11,15};
        System.out.println(twoSum(list, 9));
    }
}
