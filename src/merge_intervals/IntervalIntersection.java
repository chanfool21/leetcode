package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    class Pair{
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[][] intervalIntersectionUnoptimized(int[][] firstList, int[][] secondList) {

        List<Pair> res = new ArrayList<>();
        for(int i = 0; i < firstList.length; i++) {
            Pair temp = new Pair(firstList[i][0], firstList[i][1]);
            for(int j = 0; j < secondList.length; j++) {
                if((temp.first <= secondList[j][0] && temp.second >= secondList[j][0]) ||
                        (secondList[j][0] <= temp.first && secondList[j][1] >= temp.first)){
                    Pair val = new Pair(Math.max(temp.first,secondList[j][0] ), Math.min(temp.second, secondList[j][1]));
                    res.add(val);
                }
            }
        }

        return res.stream().map(resultArray -> new int[] {resultArray.first, resultArray.second}).toArray(int[][] :: new);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;

        int i = 0;
        int j = 0;

        List<Pair> res = new ArrayList<>();
        while(i < n && j < m) {
            if((firstList[i][0] <= secondList[j][0] && firstList[i][1] >= secondList[j][0]) || (secondList[j][0] <= firstList[i][0] && secondList[j][1] >= firstList[i][0])) {
                Pair temp = new Pair(Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1]));
                res.add(temp);
            }

            if(firstList[i][1] <= secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.stream().map(resultArray -> new int[] {resultArray.first, resultArray.second}).toArray(int[][] :: new);
    }

    public static void main(String[] args) {
        int a[][] = new IntervalIntersection().intervalIntersection(new int[][] {{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}});
        Arrays.stream(a).forEach(ar -> System.out.println(ar[0] + "," + ar[1]));
    }
}
