package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            int res[][] = new int[1][2];
            res[0][0] = newInterval[0];
            res[0][1] = newInterval[1];
            return res;
        }
        Pair temp = new Pair(newInterval[0], newInterval[1]);
        List<Pair> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(temp.second < intervals[i][0]) {
                res.add(temp);
                temp = new Pair(intervals[i][0], intervals[i][1]);
            } else {
                if(temp.first > intervals[i][1]) {
                    res.add(new Pair(intervals[i][0], intervals[i][1]));
                } else {
                    temp.first = Math.min(temp.first, intervals[i][0]);
                    temp.second = Math.max(temp.second, intervals[i][1]);
                }
            }

            if(i == intervals.length-1) {
                res.add(temp);
            }
        }

        return res.stream().map(result -> new int[] {result.first, result.second}).toArray(int[][]:: new);
    }

    public static void main(String[] args) {
        int a[][] = new InsertIntervals().insert(new int[][] {{1,3}, {6,9}}, new int[] {2,5});
        Arrays.stream(a).forEach(ar -> System.out.println(ar[0] + "," + ar[1]));
    }
}
