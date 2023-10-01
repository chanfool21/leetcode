package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triangle {

    int fnc(List<List<Integer>>a, int i, int j, int n, int dp[][]) {
        if(i < 0 || i >= n || j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }

        if(i == 0 && j == 0) {
            return a.get(0).get(0);
        }

        if(dp[i][j] != -1) return dp[i][j];
        int fromUp = Math.min(fnc(a, i-1, j, n, dp), fnc(a, i-1, j-1, n, dp));
        if(fromUp == Integer.MAX_VALUE) {
            dp[i][j] =  Integer.MAX_VALUE;
        } else {
            dp[i][j] =  a.get(i).get(j) + fromUp;
        }

        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        if(n == 1) return triangle.get(0).get(0);

        int dp[][] = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.setAll(row , col -> -1));
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            res = Math.min(res, fnc(triangle, n-1, i, n, dp));
        }

        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                int val = sc.nextInt();
                row.add(val);
            }

            list.add(row);
        }
        /*
        4
        2
        3 4
        6 5 7
        4 1 8 3
         */
        System.out.println(new Triangle().minimumTotal(list));
    }

}
