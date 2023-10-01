package dynamicprogramming;

public class MaximumGeneratedArray {

    public int getMaximumGenerated(int n) {
        /*
        You are given an integer n. A 0-indexed integer array nums of length n + 1 is generated in the following way:

nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums​​​.
3 = 2*1 + 1 -> i = 1, dp[1] + dp[2]
4

0 1 1 2 1 3 2 3

Input: n = 7
Output: 3
         */

        if(n <= 1) {
            return n;
        }

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(i%2 == 0) {
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[i/2] + dp[i/2 + 1];
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i <= n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumGeneratedArray().getMaximumGenerated(3));
    }
}
