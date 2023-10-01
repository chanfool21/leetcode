package dynamicprogramming;

import java.util.Arrays;

public class MinimumCoinChange {

    public static int minCoins(int coins[], int n, int V)
    {
        // Your code goes here
        if(V == 0) {
            return 0;
        }

        Arrays.sort(coins);
        int dp[] = new int[V+1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1; i <= V; i++) {
            for(int j = 0; j < n; j++) {

                if(i >= coins[j]) {
                    dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
                }
            }
        }

        if(dp[V] == Integer.MAX_VALUE || dp[V] == Integer.MAX_VALUE-1) {
            return -1;
        }
        return dp[V];
    }

    public static void main(String[] args) {
        System.out.println(minCoins(new int [] {25, 10, 5} ,3, 30));
    }
}
