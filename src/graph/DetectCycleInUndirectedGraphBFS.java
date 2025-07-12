package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphBFS {

    class Node {
        int val;
        int parent;
        Node(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited) {
        Node temp = new Node(src, -1);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(temp);

        while(!queue.isEmpty()) {

            Node curr = queue.poll();
            visited.add(curr.val);

            for(Integer node : adj.get(curr.val)) {
                if(node == curr.parent) {
                    continue;
                } else {
                    if(visited.contains(node)) {
                        return true;
                    } else {
                        queue.add(new Node(node, curr.val));
                    }
                }
            }
        }

        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashSet<Integer> visited = new HashSet<>();
        boolean result = false;
        for(int i = 0; i < V; i++) {
            if(!visited.contains(i)) {
                result |= detectCycle(i, adj, visited);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
