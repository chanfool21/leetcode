package graph;

import java.util.*;

public class CloneGraphBFS {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node result = new Node(node.val);
        Node currentNode = null;
        Map<Node, Node> mp = new HashMap<>();
        mp.put(node, result);
        visited.add(node.val);
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            Node clone = mp.get(currentNode);
            //adjList = [[2,4],[1,3],[2,4],[1,3]]
            for(int i = 0; i < currentNode.neighbors.size(); i++) {
                    if (mp.containsKey(currentNode.neighbors.get(i))) {
                        Node newNode = mp.get(currentNode.neighbors.get(i));
                        clone.neighbors.add(newNode);
                    } else {
                        Node newNode = new Node(currentNode.neighbors.get(i).val);
                        clone.neighbors.add(newNode);
                        mp.put(currentNode.neighbors.get(i), newNode);
                    }
                if(!visited.contains(currentNode.neighbors.get(i).val)) {
                    queue.add(currentNode.neighbors.get(i));
                    visited.add(currentNode.neighbors.get(i).val);
                }
            }
        }

        return result;
    }

    public Node buildConnectedGraph(List<List<Integer>> adjList) {
        Map<Integer, Node> map = new HashMap<>();

        // Create nodes
        for (int i = 0; i < adjList.size(); i++) {
            map.put(i, new Node(i + 1)); // Assuming node values start from 1
        }

        // Create edges
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> neighbors = adjList.get(i);
            Node node = map.get(i);
            for (int neighborIndex : neighbors) {
                node.neighbors.add(map.get(neighborIndex - 1)); // Adjust index to start from 0
            }
        }

        return map.get(0); // Return the source node
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(2, 4));
        adjList.add(Arrays.asList(1, 3));
        adjList.add(Arrays.asList(2, 4));
        adjList.add(Arrays.asList(1, 3));

        Node source = new CloneGraphBFS().buildConnectedGraph(adjList);
        Node result = new CloneGraphBFS().cloneGraph(source);
        System.out.println("Source Node: " + result.val);
        System.out.println("Neighbors:");
        for (Node neighbor : result.neighbors) {
            System.out.println(neighbor.val);
        }

    }
}
