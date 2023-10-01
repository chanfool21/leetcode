package microsoft_leetcode_assesments;

import java.util.PriorityQueue;

public class RemoveBalloonFromRope {
    public int minCost(String colors, int[] neededTime) {
        int i = 1;
        int n = colors.length();
        int minCost = 0;
        boolean flag = false;
        while(i < n) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            while(i < n && colors.charAt(i-1) == colors.charAt(i)) {
                flag = true;
                pq.add(neededTime[i-1]);
                i++;
            }
            if(i <= n && flag == true) {
                pq.add(neededTime[i-1]);
                i--;
            }

            while(pq.size() > 1) {
                minCost+=pq.poll();
            }
            pq.clear();
            flag = false;
            i++;
        }

        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveBalloonFromRope().minCost("aabaa", new int[] {1,2,3,4,1}));
    }
}
