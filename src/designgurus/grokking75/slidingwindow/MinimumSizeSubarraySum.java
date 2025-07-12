package designgurus.grokking75.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        // ToDO: Write Your Code Here.

        int n = nums.length;
        int l = 0;
        int r = 0;

        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while(r < n) {
            currentSum += nums[r];
            while(currentSum >= target && l <= r) {
                minLength = Math.min(minLength, r - l + 1);
                currentSum-= nums[l];
                l++;
            }
            r++;
        }

        if(minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(15, new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
