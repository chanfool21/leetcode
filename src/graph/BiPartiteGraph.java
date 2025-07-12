package graph;

import java.util.*;

public class BiPartiteGraph {
    public boolean isMColorable(int V, List<List<Integer>> adj, int C) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(i, new ArrayList<>());
        }

        for(int i = 0; i < adj.size(); i++) {
            List<Integer> edge = adj.get(i);
            int src = edge.get(0);
            int dest = edge.get(1);

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        Map<Integer, Integer> colors = new HashMap<>();

        for(int i = 0; i < V; i++) {
            if(!colors.containsKey(i)) {
                if(!dfs(i, colors, C, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int cur, Map<Integer, Integer> colors, int C, List<List<Integer>> adj) {
        for(int color = 0; color < C; color++) {
            boolean canUse = true;
            for(int neighbor : adj.get(cur)) {
                if(colors.getOrDefault(neighbor, -1) == color) {
                    canUse = false;
                    break;
                }
            }
            if(canUse) {
                colors.put(cur, color);
                boolean allColored = true;
                for(int neighbor : adj.get(cur)) {
                    if(!colors.containsKey(neighbor)) {
                        if(!dfs(neighbor, colors, C, adj)) {
                            allColored = false;
                            break;
                        }
                    }
                }
                if(allColored) return true;
                colors.remove(cur); // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1)),
                new ArrayList<>(Arrays.asList(0, 3)),
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(2, 3))
        );
        int V = 4;
        int C = 2; // For bipartite, use 2 colors
        System.out.println(new BiPartiteGraph().isMColorable(V, adj, C));
    }
}
