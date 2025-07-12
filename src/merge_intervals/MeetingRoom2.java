package merge_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 1;
        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            if(pq.peek() > intervals[i][0]) {
                rooms++;
            } else {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        return rooms;
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRoom2().minMeetingRooms(new int[][] {{0,30},{5,10},{15,20}}));
    }

}
