package dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    int fnc(int i, int j, int m, int n, int dp[][]) {
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        } else if(i == 0 && j == 0) return 1;
        else if(dp[i][j] != -1) return dp[i][j];
        else {
            dp[i][j] = fnc(i-1, j, m, n, dp) + fnc(i, j-1, m, n, dp);
            return dp[i][j];
        }
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.setAll(row, col -> -1));

        return fnc(m-1, n-1, m, n, dp);
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }
}
