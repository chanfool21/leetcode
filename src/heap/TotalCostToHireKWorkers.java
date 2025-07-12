package heap;
import java.util.*;

public class TotalCostToHireKWorkers {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Pair> pqLeft = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.first < o2.first) return -1;
                else if(o1.first > o2.first) return 1;
                else {
                    if(o1.second < o2.second) return -1;
                    else return 1;
                }
            }
        });

        PriorityQueue<Pair> pqRight = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.first < o2.first) return -1;
                else if(o1.first > o2.first) return 1;
                else {
                    if(o1.second < o2.second) return -1;
                    else return 1;
                }
            }
        });

        int l = 0;
        int r = costs.length - 1;

        int i = 0;


        //31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58
        int result = 0;
        while(k > 0) {

            while(pqLeft.size() < candidates &&  l <= r) {
                pqLeft.add(new Pair(costs[l], l));
                l++;
            }

            while(pqRight.size() < candidates && l <= r) {
                pqRight.add(new Pair(costs[r], r));
                r--;
            }

            Pair leftMin = null;
            Pair rightMin = null;

            if(pqRight.isEmpty() && pqLeft.isEmpty()) break;
            leftMin = pqLeft.size() > 0?pqLeft.peek(): new Pair(Integer.MAX_VALUE, (int) 1e6);
            rightMin = pqRight.size() > 0? pqRight.peek(): new Pair(Integer.MAX_VALUE, (int) 1e6);


            if (leftMin.first <= rightMin.first) {
                pqLeft.poll();
                result += leftMin.first;
            } else {
                pqRight.poll();
                result += rightMin.first;
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TotalCostToHireKWorkers().totalCost(new int[] {28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34}, 32, 12));
    }
}
