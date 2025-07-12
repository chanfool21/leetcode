package graph;

import java.util.*;

public class DetectCycleInUndirectedGraphDFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        int n = V;

        Set<Integer> visited = new HashSet<>();
        int prev = -1;
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                if(dfs(i, prev, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

boolean dfs(int current, int prev, Set<Integer> visited, List<Integer>[] adj) {
        visited.add(current);
        for(int i = 0; i < adj[current].size(); i++) {
            if(adj[current].get(i) == prev) continue;
            if(visited.contains(adj[current].get(i))) {
                return true;
            } else {
                if(dfs(adj[current].get(i), current, visited, adj)) {
                    return true;
                }
            }
        }
        visited.remove(current);
        return false;
}

    public static void main(String[] args) {
        DetectCycleInUndirectedGraphDFS obj = new DetectCycleInUndirectedGraphDFS();
        List<Integer>[] adj = new ArrayList[]{
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(0)),
                new ArrayList<>(Arrays.asList(0, 3)),
                new ArrayList<>(Arrays.asList(2))
        };
        System.out.println(obj.isCycle(adj.length, adj));
    }
}
