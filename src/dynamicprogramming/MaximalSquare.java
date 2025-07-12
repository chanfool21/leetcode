package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MaximalSquare {
    public static int maximalSquare(List<List<Integer>> matrix) {
        
        // WRITE YOUR BRILLIANT CODE HERE
//        int m = matrix.size();
//        int n = matrix.get(0).size();
//
//        int res = 0;
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                res = Math.max(res, fnc(i, j, m, n, matrix));
//            }
//        }
//        return res*res;
        return maximalSquareTabulation(matrix);
    }

    static int fnc(int i, int j, int m, int n,List<List<Integer>> matrix) {
        if(i >= m || i < 0 || j >= n || j < 0) {
            return 0;
        }
        
        return matrix.get(i).get(j) + Math.min(fnc(i, j-1, m, n, matrix), Math.min(fnc(i-1, j-1, m, n, matrix), fnc(i-1, j, m, n, matrix)));

    }

    public static int maximalSquareTabulation(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int dp[][] = new int[m][n];
        int maxSqrSize = 0;
        for(int i = 0; i < m; i++) {
            maxSqrSize = Math.max(maxSqrSize, matrix.get(i).get(0));
            dp[i][0] = matrix.get(i).get(0);
        }

        for(int j = 0; j < n; j++) {
            maxSqrSize = Math.max(maxSqrSize, matrix.get(0).get(j));
            dp[0][j] = matrix.get(0).get(j);
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j< n; j++) {
                if(matrix.get(i).get(j) == 1)
                    dp[i][j] = matrix.get(i).get(j) + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                else
                    dp[i][j] = 0;
                maxSqrSize = Math.max(maxSqrSize, dp[i][j]);
            }
        }

        return maxSqrSize*maxSqrSize;
    }

    /*
    [[1, 0, 1, 0, 0],
 [1, 0, 1, 1, 1],
 [1, 1, 1, 1, 0],
 [1, 0, 0, 1, 0]]
     */
    public static void main(String[] args) {
        int[][] inputArray = {
            {1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1},
            {0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1}
        };

        // Convert 2D array to List<List<Integer>>
        List<List<Integer>> matrix = new ArrayList<>();

        for (int[] row : inputArray) {
            List<Integer> currentRow = new ArrayList<>();
            for (int value : row) {
                currentRow.add(value);
            }
            matrix.add(currentRow);
        }

        System.out.println(maximalSquare(matrix));
    }
}
