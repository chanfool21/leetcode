package greedy;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] + j >= i) {
                    if(nums[j] + j >= n-1) {
                        return 1 + dp[j];
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[j]);
                    }
                }
            }
        }

        return dp[n-1];
    }

    public int jumpGreedy(int[] nums) {
        int i = 0;
        int j = 0;

        if(nums.length == 0 || nums[0] == 0) {
            return 0;
        }

        int maxRange = 0;
        int res = 0;
        while(j < nums.length-1) {
            maxRange = 0;
            for(int idx = i; idx <= j && idx < nums.length; idx++) {
                maxRange = Math.max(maxRange, idx + nums[idx]);
            }
            i = j+1;
            j = maxRange;
            res+=1;
            if(j >= nums.length - 1) {
                return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jumpGreedy(new int[] {3,4,3,2,5,4,3}));
    }
}
