package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class ActivitySelection {
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        List<Pair> pairList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            pairList.add(new Pair(start[i], end[i]));
        }

        pairList.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.end > o2.end) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        Pair prevPair = null;
        int res = 0;
        for(Pair pair: pairList) {
            if(prevPair == null) {
                prevPair = pair;
                res++;
            } else {
                if(prevPair.end <= pair.start) {
                    res++;
                    prevPair = pair;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(activitySelection(new int[] {11,12,5,2,13,83,66,6,8,41,47,6,68,4,21,19,19,2,23,9,74,54,14,46,21,18,8,10,27,14,48,83,25,57,38,24,86,28,16,26,19,83,8,35,34,48,22,11,43,13,59,7,28,7},
                new int[] {56,96,8,98,72,96,68,31,34,73,88,53,82,93,29,96,64,98,67,27,77,82,95,56,41,99,56,91,87,99,65,92,64,90,52,99,88,99,18,99,40,85,38,53,37,90,31,90,53,88,68,54,48,26},
                54));
    }
}

