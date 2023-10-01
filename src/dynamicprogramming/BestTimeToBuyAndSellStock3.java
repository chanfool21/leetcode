package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class BestTimeToBuyAndSellStock3 {
    int fnc(int a[], int i, int n, int k, int state, int txn, int[][][] dp) {

        if(txn == k) {
            return 0;
        }
        if(i == n) {
            return 0;
        }

        if(dp[i][state] [txn] != -1) {
            return dp[i][state][txn];
        }
        int r1 = 0;
        int r2 = 0;

        if(state == 1) {
            r1 = -a[i]+fnc(a, i+1, n, k,2, txn,  dp);
            r2 = fnc(a, i+1, n, k,state, txn, dp);
        } else if(state == 2){
            r1 = a[i]+fnc(a, i + 1, n,k, 1, txn+1, dp);
            r2 = fnc(a, i+1, n, k,state, txn, dp);
        }

        return dp[i][state][txn] = Math.max(r1,r2);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //HashMap<String, Integer> dp = new HashMap<>();
        int[][][] dp = new int[n+1][3][3];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 2; j++) {
                for(int k = 0; k <=2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int k = 2;
        int totalProfit = fnc(prices, 0, n, k,1, 0, dp);
        return totalProfit >= 0 ? totalProfit :  0;
    }

    public int maxProfitWithKTransaction(int k, int[] prices) {
        int n = prices.length;
        //HashMap<String, Integer> dp = new HashMap<>();
        int[][][] dp = new int[n+1][3][3];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 2; j++) {
                for(int l = 0; l <=2; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        int totalProfit = fnc(prices, 0, n, k, 1, 0, dp);
        return totalProfit >= 0 ? totalProfit :  0;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock3().maxProfitWithKTransaction(2, new int[] {3,3,5,0,0,3,1,4}));
    }

    /*

    Solution to get it reviewed:
    class Solution {

    int fnc(int a[], int i, int n, boolean buy, int txn, int totalProfit, HashMap<String, Integer> dp) {
        String key = String.valueOf(i+"_"+buy+ "_" + txn);

        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        if(txn == 2) {
            dp.put(key, totalProfit);
            return dp.get(key);
        }
        if(i == n && txn <= 2) {
            dp.put(key, totalProfit);
            return dp.get(key);
        }

        int r1 = Integer.MIN_VALUE, r2= Integer.MIN_VALUE, r3 = Integer.MIN_VALUE;
        if(buy) {
            r1 = fnc(a, i+1, n, false, txn, totalProfit-a[i], dp);
        } else {
            r2 = fnc(a, i + 1, n, true, txn+1, totalProfit + a[i], dp);
        }
        r3 = fnc(a, i+1, n, buy, txn, totalProfit, dp);
        dp.put(key, Math.max(r1, Math.max(r2, r3)));
        return dp.get(key);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        HashMap<String, Integer> dp = new HashMap<>();
        int totalProfit = fnc(prices, 0, n, true, 0, 0, dp);
        return totalProfit >= 0 ? totalProfit :  0;
    }
}
     */
}
