package dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock5 {

    int fnc(int buy, int arr[], int index, int n, int fee, int dp[][]) {
        if(index == n) {
            return 0;
        }

        if(dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if(buy == 1) {
            return dp[index][buy] = Math.max(-arr[index] + fnc(0, arr, index+1, n, fee, dp), fnc(buy, arr, index+1, n, fee, dp));
        } else {
            return dp[index][buy] = Math.max(arr[index] + fnc(1, arr, index+1, n, fee, dp) - fee, fnc(buy, arr, index+1, n, fee, dp));
        }
    }


    int fncNonRec(int[] arr, int n, int fee) {
        int dp[][] = new int[n][2];
        for(int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if(j == 0) {
                    if (i == n - 1) {
                        dp[i][j] = Math.max(arr[i], 0) -fee;
                    } else {
                        dp[i][j] = Math.max(arr[i] + dp[i+1][1] -fee, dp[i+1][j]);
                    }
                } else {
                    if(i == n-1) {
                        dp[i][j] = Math.max(-arr[i], 0);
                    } else {
                        dp[i][j] = Math.max(-arr[i] + dp[i][0], dp[i+1][1]);
                    }

                }
            }
        }

        return dp[0][1];
    }
    public int stockBuySell(int[] arr, int n, int fee) {
//        int dp[][] = new int[n][2];
//
//        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
//         return fnc(1, arr, 0, n, fee, dp);
        return fncNonRec(arr, n, fee);
    }

    public static void main(String[] args) {
        int arr[] = new int[] {10, 3, 7, 5, 1, 3};
        int n = arr.length;
        int fee = 3;

        System.out.println(new BestTimeToBuyAndSellStock5().stockBuySell(arr, n , fee));
    }
}
