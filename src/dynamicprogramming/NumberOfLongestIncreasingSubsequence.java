package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberOfLongestIncreasingSubsequence {
    public int numberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, 1);
        int track[] = new int[n];
        Arrays.fill(track,1);
        int maxIdx = 0;
        int maxDp = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        track[i] = track[j];
                    } else if(dp[i] == dp[j] + 1) {
                        track[i] += track[j];
                    }
                }
            }
            if(maxDp < dp[i]) {
                maxDp = dp[i];
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == maxDp) {
                res+=track[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfLongestIncreasingSubsequence().numberOfLIS(new int[] {2, 2, 2, 2, 2}));
    }
}
