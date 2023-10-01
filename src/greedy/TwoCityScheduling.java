package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    //Sorting cities on the basis of the different of cost a, cost b because on one end a will be lesser, and on next end b will lesser to pick
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ((o1[0] - o1[1]) > (o2[0] - o2[1])) {
                    return  1;
                } else {
                    return -1;
                }
            }
        });

        int totalCost = 0;

        for(int i = 0; i < costs.length/2; i++) {
            totalCost += costs[i][0] + costs[costs.length - i - 1][1];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        System.out.println(new TwoCityScheduling().twoCitySchedCost(new int[][] {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));
    }
}
