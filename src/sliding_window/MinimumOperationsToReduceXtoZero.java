package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXtoZero {
    /*
    Intution: Qn asks to remove element from borders i.e 0 and n-1
    to reduce x to zero in minimum steps.
    If we think in a way that we have to reduce elements such that reduced element sum is x,
    then it means remaining element inside borders should be sum(array) -x.
            So if we find maximum subarray whose sum is sum(array) - x, we will find num of minimum steps to reduce x to 0
     */

    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum+=nums[i];
        }

        int target = totalSum - x;

        Map<Integer, Integer> mp = new HashMap<>();

        int res = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        int curSum = 0;
        mp.put(0, -1);
        while(end  < nums.length) {
            curSum += nums[end];
            if(!mp.containsKey(curSum)) {
                mp.put(curSum, end);
            }

            int diff = curSum - target;

            if(mp.containsKey(diff)) {
                start = mp.get(diff);
                if(res < (end-start))  {
                    res = end - start;
                }
            }

            end++;
        }
        if(res == Integer.MIN_VALUE) return -1;
        return nums.length - res;
    }

    public static void main(String[] args) {
        new MinimumOperationsToReduceXtoZero().minOperations(new int[] {5,6,7,8,9} , 4);
    }
}
