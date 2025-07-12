package designgurus.grokking75.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {
    class Graph {
        int data[][];
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] wallsAndGates(int[][] rooms) {
        // ToDo: Write Your Code Here.

        int n = rooms.length;
        int m = rooms[0].length;
        Graph g = new Graph();
        g.data = rooms;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(rooms[i][j] == 0) {
                    Set<String> visited = new HashSet<>();
                    bfs(g, i, j, n, m, visited);
                }
            }
        }

        return g.data;
    }


    boolean isSafe(int i, int j, int m, int n, int data[][], Set<String> visited) {
        if(i >= 0 && i < m && j >= 0 && j < n && data[i][j] != -1 && data[i][j] != 0 && !visited.contains(i + "_"+ j)) {
            return true;
        } else {
            return false;
        }
    }
    void bfs(Graph g, int si, int sj, int m, int n, Set<String> visited) {
        int rooms[][] = g.data;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(si, sj));
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            int dx[] = new int[] {1, 0, -1, 0};
            int dy[] = new int[] {0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                if(isSafe(cur.x + dx[i], cur.y + dy[i], m, n,rooms, visited)) {
                    rooms[cur.x + dx[i]][cur.y + dy[i]] = Math.min(rooms[cur.x + dx[i]][cur.y + dy[i]],
                            1 + rooms[cur.x][cur.y]);
                    queue.add(new Point(cur.x + dx[i],cur.y + dy[i] ));
                    visited.add((cur.x + dx[i]) + "_" + (cur.y + dy[i]));
                }
            }
        }

        g.data = rooms;
    }


    public static void main(String[] args) {
        int a[][] = new int[][] {{2147483647, -1, 0}, {2147483647, 2147483647, 2147483647}, {2147483647, -1, 2147483647}};
        a = new WallsAndGates().wallsAndGates(a);

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
