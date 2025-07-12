package graph;



import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int visited[][];
    boolean isSafe(int image[][], int i, int j, int m, int n) {
        if(i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 0) return true;
        else return false;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }

        bfs(image, sr, sc, color);
        return image;
    }


    void bfs(int image[][], int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        visited[sr][sc] = 1;

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pr = queue.poll();
            int i = pr.getKey();
            int j = pr.getValue();
            int tempColor = image[i][j];
            image[i][j] = color;

            if(isSafe(image, i, j+1,m, n) && image[i][j+1] == tempColor) {
                visited[i][j+1] = 1;
                queue.add(new Pair(i, j+1));
            }
            if(isSafe(image, i+1, j,m, n) && image[i+1][j] == tempColor) {
                visited[i+1][j] = 1;
                queue.add(new Pair(i+1, j));
            }
            if(isSafe(image, i-1, j,m, n) && image[i-1][j] == tempColor) {
                visited[i-1][j] = 1;
                queue.add(new Pair(i-1, j));
            }
            if(isSafe(image, i, j-1,m, n) && image[i][j-1] == tempColor) {
                visited[i][j-1] = 1;
                queue.add(new Pair(i, j-1));
            }

        }
    }

    public static void main(String[] args) {
        int a[][] = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
        int res[][] = new FloodFill().floodFill(a, 1, 1, 2);
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
