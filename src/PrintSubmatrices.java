public class PrintSubmatrices {
    public static int printAllSubmatrices(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int res = 0;
        for (int rowStart = 0; rowStart < numRows; rowStart++) {
            for (int colStart = 0; colStart < numCols; colStart++) {
                for (int rowEnd = rowStart; rowEnd < numRows; rowEnd++) {
                    for (int colEnd = colStart; colEnd < numCols; colEnd++) {
                        // Print the submatrix directly in the nested loops
                        int cnt = 0;
                        for (int i = rowStart; i <= rowEnd; i++) {
                            for (int j = colStart; j <= colEnd; j++) {
                                if(matrix[i][j] == 1) {
                                    cnt++;
                                }
                            }
                        }
                        if(cnt == (rowEnd - rowStart + 1) * (colEnd - colStart + 1)) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("All submatrices of the given matrix:");
        printAllSubmatrices(matrix);
    }

}
