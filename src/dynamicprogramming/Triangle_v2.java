package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle_v2 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        // WRITE YOUR BRILLIANT CODE HERE
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = 0;
                if(i == m-1) {
                    dp[i][j] = triangle.get(i).get(j);
                }
            }
        }

        for(int i = m-2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String[][] triangleString = {
                {"2"},
                {"3", "4"},
                {"6", "5", "7"},
                {"4", "1", "8", "3"}
        };

        List<List<Integer>> triangle = new ArrayList<>();

        for (String[] row : triangleString) {
            List<Integer> currentRow = new ArrayList<>();
            for (String numStr : row) {
                currentRow.add(Integer.parseInt(numStr));
            }
            triangle.add(currentRow);
        }

        System.out.println(Triangle_v2.minimumTotal(triangle));
    }
}
