package graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfEnclaves {
    public int numberOfEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Set<String> visited = new HashSet<>();
        //int matrix[][] = new int[r][c];
        int bx[] = {0, r-1};
        int by[] = {0, c-1};
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < by.length; j++) {
                String key = i + "_" + by[j];
                if(!visited.contains(key) && grid[i][by[j]] == 1)  {
                    dfs(i, by[j], r, c, grid, visited);
                }
            }
        }

        for(int j = 0; j < c; j++) {
            for(int i = 0; i < bx.length; i++) {
                String key = bx[i] + "_" + j;
                if(!visited.contains(key) && grid[bx[i]][j] == 1)  {
                    dfs(bx[i], j, r, c, grid, visited);
                }
            }
        }

        int result = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    boolean isSafe(int i, int j, int r, int c, int grid[][]) {
        if(i < 0 || i >= r || j <0 || j >=  c || grid[i][j] != 1) {
            return false;
        }

        return true;
    }
    void dfs(int x, int y, int r, int c, int grid[][], Set<String> visited) {
        String key = x + "_" + y;
        if(visited.contains(key)) {
            return;
        }
        visited.contains(key);
        grid[x][y] = -1;
        int di[] = {1, 0, -1, 0};
        int dj[] = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {
            int nx = x + di[i];
            int ny = y + dj[i];
            if(isSafe(nx, ny, r, c, grid)) {
                dfs(nx, ny, r, c, grid, visited);
            }
        }
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]  {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        System.out.println(new NumberOfEnclaves().numberOfEnclaves(grid));
    }
}
