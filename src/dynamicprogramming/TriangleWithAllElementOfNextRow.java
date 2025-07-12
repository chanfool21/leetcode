package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class TriangleWithAllElementOfNextRow {
    public static int minimumTotal(List<List<Integer>> triangle) {
        // WRITE YOUR BRILLIANT CODE HERE

        return fnc(0, 0, triangle.size(), triangle);
    }

    static int fnc(int i, int j, int m, List<List<Integer>> triangle) {
        if(i >= m ) return 0;

        int sum = triangle.get(i).get(j);
        if(i == m-1) return sum;
        int res = Integer.MAX_VALUE;
        for(int k = 0; k < triangle.get(i+1).size(); k++) {
            res = Math.min(res, fnc(i+1, k, m, triangle));
        }

        return res + sum;
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

        System.out.println(TriangleWithAllElementOfNextRow.minimumTotal(triangle));
    }
}
