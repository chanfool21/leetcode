package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberLC198 {
    public int rob(int[] nums) {
        Map<Integer, Integer> dp = new HashMap<>();
        return fnc(nums, 0, dp);
    }

    int fnc(int nums[], int index, Map<Integer, Integer> dp) {
        if(index >= nums.length) {
            return 0;
        }
        int result = Math.max(nums[index] + fnc(nums, index + 2, dp), fnc(nums, index + 1, dp));
        dp.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberLC198().rob(new int[] {1,2,3,1}));
    }
}
