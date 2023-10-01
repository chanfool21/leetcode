package graph;

import java.util.*;

class Edge{
    int destination;
    int weight;

    public Edge(int dest, int wt) {
        this.destination = dest;
        this.weight = wt;
    }
}



//Incorrect approach, not dijsktra
public class NetworkDelayTime {
    void createGraph(int time[][], Map<Integer, List<Edge>> graph) {
        for(int i = 0; i < time.length; i++) {
            int source = time[i][0];
            int destination = time[i][1];
            int weight = time[i][2];

            if(graph.containsKey(source)) {
                graph.get(source).add(new Edge(destination, weight));
            } else {
                List<Edge> edgeList = new ArrayList<>();
                edgeList.add(new Edge(destination, weight));
                graph.put(source, edgeList);
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int time[] = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);

        time[k] = 0;

        Map<Integer, List<Edge>> graph = new HashMap<>();
        createGraph(times, graph);

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        int cnt = n;
        while(!q.isEmpty() && cnt > 0) {
            int curNode = q.poll();
            cnt--;
            if(graph.containsKey(curNode)) {
                for(Edge edge: graph.get(curNode)) {
                    int node = edge.destination;
                    int wt = edge.weight;

                    time[node] = Math.min(time[node], wt + time[curNode]);
                    q.add(node);
                }
            }
        }

        int minimumTime = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            if(time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            minimumTime = Math.max(minimumTime, time[i]);
        }

        return minimumTime;


    }

    public static void main(String[] args) {
        int n = 2;
        int k = 2;

        int time[][] = new int[][] {{1,2,1}, {2,1,3}};
        System.out.println(new NetworkDelayTime().networkDelayTime(time, n, k));
    }
}
