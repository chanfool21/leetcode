package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dist[][] = new int[r][c];
        Queue<Pair> que = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    que.add(new Pair(i, j, 0));
                    dist[i][j] = 0;
                }
            }
        }

        Set<String> visited = new HashSet<>();
        while(!que.isEmpty()) {
            Pair current = que.poll();
            String key = current.i + "_" + current.j;
            if(visited.contains(key)) {
                continue;
            }

            visited.add(key);
            int x = current.i;
            int y = current.j;
            dist[x][y] = current.d;

            int di[] = {1, 0, -1, 0};
            int dj[] = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                int nx = x + di[i];
                int ny = y + dj[i];

                if(isSafe(nx, ny, r, c)) {
                    que.add(new Pair(nx, ny, current.d+1));
                }
            }
        }

        return dist;
    }

    class Pair {
        int i;
        int j;

        int d;
        Pair(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    boolean isSafe(int i, int j, int r, int c) {
        if(i >= r || i < 0 || j >= c || j < 0 ) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int grid[][] = new int[][]  { {0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1} };
        int result[][] = new DistanceOfNearestCellHavingOne().nearest(grid);

        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
