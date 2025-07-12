package graph;

public class NumberOfIslands {
    static int visited[][];
    public int numIslands(char[][] g) {
        int m = g.length;
        int n = g[0].length;

        visited =new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }

        int island = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(g[i][j] == '1' && visited[i][j] != 1) {
                    dfs(g, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    boolean isSafe(char g[][], int i, int j) {
        int m = g.length;
        int n = g[0].length;

        if(i >= 0 && i < m && j >= 0 && j < n && visited[i][j] != 1 && g[i][j] == '1') {
            return true;
        }

        return false;
    }

    void dfs(char g[][], int i, int j) {
        visited[i][j] = 1;
        if(isSafe(g, i+1, j)) {
            dfs(g, i+1, j);
        }
        if(isSafe(g, i, j+1)) {
            dfs(g, i, j+1);
        }
        if(isSafe(g, i-1, j)) {
            dfs(g, i-1, j);
        }
        if(isSafe(g, i, j-1)) {
            dfs(g, i, j-1);
        }
    }

    public static void main(String[] args) {
        char a[][] = new char[][] {  {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(new NumberOfIslands().numIslands(a));
    }
}
