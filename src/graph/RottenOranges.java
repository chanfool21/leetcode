package graph;



import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int visited[][];
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        visited = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                visited[i][j] = 0;
            }
        }

        int minTime = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(visited[i][j] == 0 && grid[i][j] == 2) {
                    minTime = Math.max(minimumTimeToRotForAConnectedComponent(grid, i, j), minTime);
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return minTime;
    }


    boolean isSafe(int i, int j, int m, int n, int grid[][]) {
        if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1 && visited[i][j] == 0) {
            return true;
        } else {
            return false;
        }
    }
    int minimumTimeToRotForAConnectedComponent(int grid[][], int i, int j) {
        int ctr = -1;
        Queue<Pair<Integer, Pair<Integer, Integer>>> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (grid[k][l] == 2) {
                    queue.add(new Pair(grid[k][l], new Pair(k, l)));
                    visited[k][l] = 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            //Pair<Integer, Pair<Integer, Integer>> pair = queue.poll();
            ctr++;
            int sz = queue.size();
            for(int k = 0; k < sz; k++) {
                Pair<Integer, Pair<Integer, Integer>> pair = queue.poll();
                Pair<Integer, Integer> index = pair.getValue();
                int r = index.getKey();
                int c = index.getValue();
                grid[r][c] = 2;
                if(isSafe(r+1, c, m, n, grid)) {
                    visited[r+1][c] = 1;
                    queue.add(new Pair(grid[r+1][c], new Pair(r+1, c)));
                }
                if(isSafe(r-1, c, m, n, grid)) {
                    visited[r-1][c] = 1;
                    queue.add(new Pair(grid[r-1][c], new Pair(r-1, c)));
                }
                if(isSafe(r, c+1, m, n, grid)) {
                    visited[r][c+1] = 1;
                    queue.add(new Pair(grid[r][c+1], new Pair(r, c+1)));
                }
                if(isSafe(r, c-1, m, n, grid)) {
                    visited[r][c-1] = 1;
                    queue.add(new Pair(grid[r][c-1], new Pair(r, c-1)));
                }
            }

        }

        return ctr;
    }
    public static void main(String[] args) {
        int a[][] = new int[][] {{0,2,2}};
        System.out.println(new RottenOranges().orangesRotting(a));
    }
}
