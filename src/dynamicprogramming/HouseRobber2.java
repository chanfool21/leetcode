package dynamicprogramming;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int dp1[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        dp1[0] = 0;
        dp1[1] = nums[1];

        if(n <= 2)
            return dp[n-1];

        for(int i = 2; i < n; i++) {
            //one which does not have dp[0]
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
            dp1[i] = Math.max(dp1[i-1], nums[i] + dp1[i-2]);
        }



        return Math.max(dp[n-2],dp1[n-1]);

    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber2().rob(new int[] {2,3,2}));
    }
}
