package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber2LC213 {
    public int rob(int[] nums) {
        int n = nums.length;
        //Map<Integer, Integer> dp = new HashMap<>();
        return Math.max(nums[0] + fnc(nums, 2, true, new HashMap<>()),
                fnc(nums, 1 , false, new HashMap<>()));
    }

    int fnc(int nums[], int index, boolean firstTaken, Map<Integer, Integer> dp) {
        if(index == nums.length - 1 && firstTaken || index >= nums.length) {
            return 0;
        }

        if(dp.containsKey(index)) return dp.get(index);
        int result =  Math.max(nums[index] + fnc(nums, index + 2, firstTaken, dp),
                fnc(nums, index+1 , firstTaken, dp));
        dp.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber2LC213().rob(new int[] {1,3,1,3,100}));
    }
}
