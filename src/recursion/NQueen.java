package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    boolean isSafeRow(int board[][], int j, int n) {
        for (int i = 0; i < n; i++) {
            if (board[j][i] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean isSafeColumn(int board[][], int j, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean isSafeDiagonal(int board[][], int i, int j, int n) {
        int r = i;
        int c = j;

        while (r < n && c < n) {
            if (board[r][c] == 1)
                return false;
            r++;
            c++;
        }

        r = i;
        c = j;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1)
                return false;
            r--;
            c--;
        }

        r = i;
        c = j;
        while (r >= 0 && c < n) {
            if (board[r][c] == 1)
                return false;
            r--;
            c++;
        }

        r = i;
        c = j;
        while (r < n && c >= 0) {
            if (board[r][c] == 1)
                return false;
            r++;
            c--;
        }

        return true;
    }

    boolean isValidMove(int board[][], int i, int j, int n) {
        if (isSafeColumn(board, j, n) && isSafeRow(board, i, n) && isSafeDiagonal(board, i, j, n)) {
            return true;
        } else {
            return false;
        }
    }

    void solver(int i, int j, int n, int curQueen, int board[][], List<List<String>> result) {

        if (curQueen == n) {
            System.out.println("found the solution");
            List<String> temp = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                String string = "";
                for (int col = 0; col < n; col++) {
                    if (board[row][col] == 0) {
                        string += ".";
                    } else {
                        string += "Q";
                    }
                }
                temp.add(string);
            }

            result.add(temp);
            return;
        }

        for (int r = 0; r < n; r++) {
            if (isValidMove(board, r, j, n)) {
                board[r][j] = 1;
                solver(r, j + 1, n, curQueen + 1, board, result);
                board[r][j] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        solver(0, 0, n, 0, board, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new NQueen().solveNQueens(4);
        for (List ls : result) {
            ls.forEach(ele -> System.out.println(ele));
            System.out.println("<==================>");
        }
    }
}
