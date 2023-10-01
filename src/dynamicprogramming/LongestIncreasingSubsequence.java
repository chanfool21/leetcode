package dynamicprogramming;

import java.util.Arrays;

/*
    Todo
 */
public class LongestIncreasingSubsequence {

    int lis(int nums[] , int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        } else {

            int res = 1;

            for (int i = 1; i < n; i++) {
                res = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        res = Math.max(res, 1 + lis(nums, j + 1, dp));
                    }
                }
                dp[i+1] = res;
            }


        }

        return dp[n];
    }
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        lis(nums, nums.length, dp);
        return Arrays.stream(dp).max().getAsInt();
    }

    static int longestSubsequence(int size, int nums[]) {
        int dp[] = new int[size + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 1; i < size; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        //{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}));
    }
}
