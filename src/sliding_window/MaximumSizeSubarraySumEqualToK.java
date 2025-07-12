package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualToK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //this map contains sum as key and smallest index till where we found the sum
        int currentRunningSum = 0;
        int res = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            currentRunningSum += nums[i];

            if(!map.containsKey(currentRunningSum)) {
                map.put(currentRunningSum, i);
            }

            int diff = currentRunningSum - k;
            if(map.containsKey(diff)) {
                res = Math.max(res, (i - map.get(diff)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSizeSubarraySumEqualToK().maxSubArrayLen(new int[] {-2,-1,2,1},1 ));
    }
}
