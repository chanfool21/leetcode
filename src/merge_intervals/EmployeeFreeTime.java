package merge_intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFreeTime {

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> collectiveIntervalList = schedule.stream().flatMap(eachEmployeeSchedule -> eachEmployeeSchedule.stream()).collect(Collectors.toList());
        System.out.println(collectiveIntervalList);
        collectiveIntervalList.sort((a, b) -> (a.start - b.start));
        Interval previousInternal = collectiveIntervalList.get(0);
        int previousEnd = previousInternal.end;
        List<Interval> result = new ArrayList<>();
        for(int i = 1; i < collectiveIntervalList.size(); i++) {
            Interval currentInterval = collectiveIntervalList.get(i);
            if(previousEnd >= currentInterval.start) {
                previousEnd = Math.max(previousEnd, currentInterval.end);
            } else {
                result.add(new Interval(previousEnd, currentInterval.start));
                previousEnd = currentInterval.end;
            }
        }
        return result;
    }

    public List<List<Interval>> createIntervalList(int[][][] input) {
        List<List<Interval>> result = new ArrayList<>();

        for (int[][] innerList : input) {
            List<Interval> intervals = new ArrayList<>();
            for (int[] interval : innerList) {
                intervals.add(new Interval(interval[0], interval[1]));
            }
            result.add(intervals);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][][] input = {
                {{1,2},{5,6}},
                {{1,3}},
                {{4,10}}
        };
        List<List<Interval>> schedule = new EmployeeFreeTime().createIntervalList(input);
        System.out.println(new EmployeeFreeTime().employeeFreeTime(schedule));
    }
}
