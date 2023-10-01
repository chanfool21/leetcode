package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TrainEvent {
    int time;
    char type;

    TrainEvent(int time, char type) {
        this.time = time;
        this.type = type;
    }
}

public class MinimumNumberOfPlatform {

    //Idea to solve this problem is to collect all the events of train, be it arrival or departure.
    // When an arrival even occurs, increase the plat count by 1, and when departure even occur, decrease the plat count.
    //Initialize its value by 1


    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        List<TrainEvent> trainEventList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            trainEventList.add(new TrainEvent(arr[i], 'A'));
            trainEventList.add(new TrainEvent(dep[i], 'D'));
        }

//        trainEventList.sort((a,b) -> {
//            return a.time - b.time;
//        });

        trainEventList.sort(new Comparator<TrainEvent>() {
            @Override
            public int compare(TrainEvent o1, TrainEvent o2) {
                if(o1.time > o2.time) {
                    return 1;
                } else if(o1.time < o2.time) {
                    return -1;
                } else {
                    if(o1.type == 'D') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        int minPlatform = 0;
        int res = 0;
        //TrainEvent prevEvent = null;
        for(TrainEvent event: trainEventList) {
//            if(prevEvent == null) {
//                prevEvent = event;
//            } else {
//                if(prevEvent.type != event.type && prevEvent.time == event.time) {
//                    if(event.type == 'A') {
//
//                    }
//                }
//            }

            if(event.type == 'A') {
                minPlatform++;
            } else {
                minPlatform--;
            }
            res = Math.max(minPlatform, res);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPlatform(new int[] {900, 910}, new int[] {910, 930}, 2));
    }
}
