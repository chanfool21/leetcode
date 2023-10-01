package google_leetcode_assessments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSubmatricesWithAllOne {
    public int numSubmat(int[][] mat) {
        int res = 0;

        int numRows = mat.length;
        int numCols = mat.length;
        /*
                1 1
                1 1

                0 0
                0 1

         */

        for (int startRow = 0; startRow < numRows; startRow++) {
            for (int startCol = 0; startCol < numCols; startCol++) {
                for (int endRow = startRow; endRow < numRows; endRow++) {
                    for (int endCol = startCol; endCol < numCols; endCol++) {
                        // Create and process the submatrix
                        int submatrixRows = endRow - startRow + 1;
                        int submatrixCols = endCol - startCol + 1;


                        int cnt = 0;
                        for (int i = startRow; i <= endRow; i++) {
                            for (int j = startCol; j <= endCol; j++) {
                                if(mat[i][j] == 1) {
                                    cnt++;
                                }
                            }
                        }
                        if(cnt == (submatrixCols*submatrixRows)) {
                            res++;
                        }

                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] mat = new int[][] {{1,0,1}, {1,1,0}, {1,1,0} };

        System.out.println(new CountOfSubmatricesWithAllOne().numSubmat(mat));
    }
}
