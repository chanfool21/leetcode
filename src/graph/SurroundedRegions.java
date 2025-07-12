package graph;

import java.util.Arrays;

public class SurroundedRegions {
    int visited[][];
    public void solve(char[][] g) {
        int m = g.length;
        int n = g[0].length;

        visited = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(visited[i], 0);


        for(int j = 0; j < n; j++) {
            int row = 0;
            if(g[row][j] == 'O' && visited[row][j] == 0) {
                dfs(g, row, j, m, n);
            }

            row = m-1;
            if(g[row][j] == 'O' && visited[row][j] == 0) {
                dfs(g, row, j, m, n);
            }
        }

        for(int i = 0; i < m; i++) {
            int col = 0;
            if(g[i][col] == 'O' && visited[i][col] == 0) {
                dfs(g, i, col, m, n);
            }

            col = n-1;
            if(g[i][col] == 'O' && visited[i][col] == 0) {
                dfs(g, i, col, m, n);
            }
        }



        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == 'O') {
                    g[i][j] = 'X';
                }

                if(g[i][j] == 'T') {
                    g[i][j] = 'O';
                }
            }
        }

    }

    boolean isBoundaryElement(int i, int j, int m, int n) {
        if(i == m-1 || i == 0 || j == 0 || j == n-1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isSafe(char g[][], int i, int j, int m, int n) {
        if(i >= 0 && i < m && j >= 0 && j < n && g[i][j] == 'O' && visited[i][j] == 0) {
            return true;
        }
        return false;
    }

    void dfs(char g[][], int i, int j, int m, int n) {
        if(isSafe(g, i, j, m, n)) {
            g[i][j] = 'T';
            visited[i][j] = 1;
            dfs(g, i + 1, j, m, n);
            dfs(g, i, j + 1, m, n);
            dfs(g, i - 1, j, m, n);
            dfs(g, i, j - 1, m, n);
        }
    }

    public static void main(String[] args) {
        char g[][] = new char[][] {{'O'}};
        new SurroundedRegions().solve(g);
    }
}
