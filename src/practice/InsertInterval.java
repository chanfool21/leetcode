package practice;

import java.util.ArrayList;
import java.util.List;

class Pair{

    Pair() {

    }

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int start;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int end;
}
public class InsertInterval {
    /*
    Input: intervals = [[1,3],[4,5],[6,7],[8,10],[12,16]],
           newInterval = [1,2]
           [1,1]
    Output: [[1,2],[3,10],[12,16]]
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<Pair> ls = new ArrayList<>();


        //Adding into the list all the intervals which come before the newinterval by comparing start of the the cur ele and new interval start
        int i = 0;
        for( ;i < intervals.length; i++) {
            if(intervals[i][0] <= newInterval[0]) {
                ls.add(new Pair(intervals[i][0], intervals[i][1]));
            } else {
                break;
            }
        }

        //Add new interval and then merge other intervals with the list
        if(!ls.isEmpty() && newInterval[0] <= ls.get(ls.size()-1).getEnd()) {
            ls.set(ls.size()-1, new Pair(ls.get(ls.size()-1).getStart(), Math.max(ls.get(ls.size()-1).getEnd(), newInterval[1])));
        } else {
            ls.add(new Pair(newInterval[0], newInterval[1]));
        }


        for(; i < intervals.length; i++) {
            if(intervals[i][0] <= ls.get(ls.size()-1).getEnd()) {
                ls.set(ls.size()-1, new Pair(ls.get(ls.size()-1).getStart(), Math.max(ls.get(ls.size()-1).getEnd(), intervals[i][1])));
            } else {
                ls.add(new Pair(intervals[i][0], intervals[i][1]));
            }
        }

        return ls.stream().map(pair -> new int[]{pair.getStart(), pair.getEnd()}).toArray(int[][] :: new);

    }

    public static void main(String[] args) {
        int res[][] = new InsertInterval().insert(new int[][] {{1,5}}, new int[] {1,7});
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }
}
