package dynamicprogramming;

import java.util.Arrays;

public class UniquePaths2 {

    int fnc(int a[][] , int i, int j, int dp[][]) {
        if(i < 0 || j < 0) {
            return 0;
        }

        if(i == 0 && j == 0) {
            if(a[i][j] == 0) return 1;
            else return 0;
        }


        if(a[i][j] == 1) {
            return 0;
        } else if(dp[i][j] != -1) {
            return dp[i][j];
        } else {
            dp[i][j] = fnc(a, i-1, j, dp) + fnc(a, i, j-1, dp);
            return dp[i][j];
        }
    }
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int dp[][] = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.setAll(row, col -> -1));

        return fnc(a, m-1, n-1, dp);
    }

    public static void main(String[] args) {
        int a[][] = new int[][] {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(a));
    }
}
