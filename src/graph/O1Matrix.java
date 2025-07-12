package graph;



import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {
    int distance[][];
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        distance = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    distance[i][j] = 0;
                    bfs(mat, i, j, m, n);
                }
            }
        }

        return distance;
    }

    boolean isSafe(int i, int j, int m, int n) {
        if(i>=0 && i < m && j >= 0 && j < n) return true;
        else return false;
    }
    void bfs(int mat[][], int i, int j, int m, int n) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(i, j));

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pr = queue.poll();
            int r = pr.getKey();
            int c = pr.getValue();

            if(isSafe(r, c+1, m, n) && distance[r][c+1] > 1 + distance[r][c]) {
                if(mat[r][c+1] == 0) {
                    distance[r][c+1] = 0;
                } else {
                    distance[r][c+1] = 1 + distance[r][c];
                }
                queue.add(new Pair(r, c+1));
            }
            if(isSafe(r, c-1, m, n) && distance[r][c-1] > 1 + distance[r][c]) {
                if(mat[r][c-1] == 0) {
                    distance[r][c-1] = 0;
                } else {
                    distance[r][c-1] = 1 + distance[r][c];
                }
                queue.add(new Pair(r, c-1));
            }
            if(isSafe(r+1, c, m, n) && distance[r+1][c] > 1 + distance[r][c]) {
                if(mat[r+1][c] == 0) {
                    distance[r+1][c] = 0;
                } else {
                    distance[r+1][c] = 1 + distance[r][c];
                }
                queue.add(new Pair(r+1, c));
            }
            if(isSafe(r-1, c, m, n) && distance[r-1][c] > 1 + distance[r][c]) {
                if(mat[r-1][c] == 0) {
                    distance[r-1][c] = 0;
                } else {
                    distance[r-1][c] = 1 + distance[r][c];
                }
                queue.add(new Pair(r-1, c));
            }
        }
    }

    public static void main(String[] args) {
        int res[][] = new O1Matrix().updateMatrix(new int[][] {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}});
        int m = res.length;
        int n = res[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
