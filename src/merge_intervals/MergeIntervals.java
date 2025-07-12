package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[][] merge(int[][] a) {
        if(a.length <= 1) return a;
        Arrays.sort(a , (ob1, ob2) -> (ob1[0] - ob2[0]));

        List<Pair> res = new ArrayList<>();
        Pair temp = new Pair(a[0][0], a[0][1]);

        for(int i = 1; i < a.length; i++) {
            if(a[i][0] <= temp.second) {
                temp.second = Math.max(a[i][1],temp.second);
            } else {
                res.add(temp);
                temp = new Pair(a[i][0], a[i][1]);
            }

            if(i == a.length - 1) {
                res.add(temp);
            }
        }



        int[][] resultArray = res.stream()
                .map(pair -> new int[]{pair.first, pair.second})
                .toArray(int[][]::new);
        return resultArray;
    }

    public static void main(String[] args) {
        int a[][] = new MergeIntervals().merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
        Arrays.stream(a).forEach(a1 -> System.out.println(a1[0]+ "," + a1[1]));
    }
}
