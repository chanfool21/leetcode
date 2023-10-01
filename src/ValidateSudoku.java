import java.util.HashSet;

public class ValidateSudoku {

    boolean isValidRows(char [][] board) {
        int n = board.length;

        for(int i = 0; i < n; i++) {
            HashSet<Character> row = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    if(row.contains(board[i][j])) {
                        return false;
                    } else {
                        row.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

    boolean isValidColumns(char [][] board) {
        int n = board.length;

        for(int j = 0; j < n; j++) {
            HashSet<Character> col = new HashSet<>();
            for(int i = 0; i < n; i++) {
                if(board[i][j] != '.') {
                    if(col.contains(board[i][j])) {
                        return false;
                    } else {
                        col.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

    boolean isValidSmallBoards(char [][] board) {
        int n = board.length;

        for(int i = 0; i < n; i+=3) {
            for(int j = 0; j < n; j+=3) {
                HashSet<Character> subBoard = new HashSet<>();
                for(int k = i; k < i+3; k++) {
                    for(int l = j; l < j+3; l++) {
                        if(board[k][l] != '.') {
                            if(subBoard.contains(board[k][l])) {
                                return false;
                            } else {
                                subBoard.add(board[k][l]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        return isValidColumns(board) && isValidRows(board) && isValidSmallBoards(board);
    }

    public static void main(String[] args) {
        char board[][] = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new ValidateSudoku().isValidSudoku(board));
    }
}
