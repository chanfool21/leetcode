package greedy;

import java.util.Arrays;
/*

https://leetcode.com/problems/gas-station/discuss/3972439/Java-Solution-with-explanation-which-clears-all-your-doubt.
Idea behind this solution is to first check if there is a solution possible or not.
We first validate by comparing sum of total gas with total cost, to check if there is a valid solution possible for this or not.

If we get a confirmation if there is a solution possible, we start iterating on array to find the index of first station from where we can complete the whole secret.

How??

The Answer is by identifying the station where our fuel surplus or quantity achieved so far is dipping to negative. Thats where we reset our solution. Consider it similar to kadane's algo for a moment,
where we used to reset the current sum which we calculated till the current index if the current sum is going negative. Since its not contributing anything in our solution, which in our case means it not letting us reach the path.
Another point which we need to remember is that if there is a solution possible, after some point of time, current surplus of fuel will continue to be positive till the end of the stations.

A doubt might come that if in between surplus goes below 0, how do we get result?
Result can be achieved, because we are sure that there is a solution for sure, and lets say we got current surplus 0 at some point of time in the path, we will start from next index and from there to n, if current surplus is not dipping, that means we have some supporting gas station in between which gonna add up surplus to the current stack which will help us complete the whole circuit, because lets say if we get negative surplus in between, we are already resetting it to 0, which means if there is any big ass fuel station which gonna handle everything by its own , since there is a solution possible.
 */
public class GasStationRevisited {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSurplus = 0;

        for (int i = 0; i < gas.length; i++) {
            totalSurplus += gas[i] - cost[i];
        }

        if (totalSurplus < 0)
            return -1;

        int res = 0;
        int curSurplus = 0;

        for (int i = 0; i < gas.length; i++) {
            curSurplus += gas[i] - cost[i];

            if (curSurplus < 0) {
                curSurplus = 0;
                res = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GasStationRevisited().canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
    }
}
