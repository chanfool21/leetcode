package sliding_window;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int end = 0;
        int start = 0;

        int n = nums.length;
        int curSum = 0;
        int res = Integer.MAX_VALUE;
        while(end < n) {
            curSum += nums[end];

            while(curSum >= target) {
                res = Math.min(res, (end-start+1));
                curSum -= nums[start];
                start++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
