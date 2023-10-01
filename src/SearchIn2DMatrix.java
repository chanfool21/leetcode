public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int i = 0;
        int j = c-1;

        while(j >= 0 && i < r) {
            if(matrix[i][j] == target) {
                return true;
             } else if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchIn2DMatrix().searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13));
    }
}
