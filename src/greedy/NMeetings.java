package greedy;

import java.util.ArrayList;
import java.util.List;

class Meeting {
    int start, end;
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class NMeetings {
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Meeting> meetingList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            meetingList.add(new Meeting(start[i], end[i]));
        }

        meetingList.sort((a, b) -> {
            return a.end - b.end;
        });

        Meeting prevMeeting = null;
        int maxMeeting = 0;
        for(Meeting meeting: meetingList) {
            if(prevMeeting == null) {
                prevMeeting = meeting;
            } else {
                if(prevMeeting.end < meeting.start) {
                    maxMeeting++;
                    prevMeeting = meeting;
                }
            }
        }

        return maxMeeting;
    }

    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[] {1,3,0,5,8,5}, new int[] {2,4,6,7,9,9}, 6));
    }
}
