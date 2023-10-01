package contest.sep23.weekly2;
import java.util.*;

public class DeterMineIfACellIsReachableInTime {
    class Pair{
        int x;
        int y;
        int count;

        Pair(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
//        if(sx == fx && sy == fy) {
//            if(t == 1) return false;
//            return true;
//        }
//
//        int m = Math.max(Math.abs(sx-fx), Math.abs(sy-fy));
//        if(m <= t) return true;
//        else return false;
        return BFS(sx, sy, fx, fy, t);
    }

    public boolean BFS(int start_x, int start_y , int target_x, int target_y, int t){

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start_x, start_y, 1));
        Map<String, Integer> mp = new HashMap<>();

        while(q.size()>0){

            Pair rem = q.remove();
            int x = rem.x;
            int y = rem.y;
            int count = rem.count;

            if(!mp.containsKey(x+"_"+y) ){

                mp.put(x+ "_" + y, 1);

                if(x==target_x && y== target_y && rem.count <= t)
                    return true;

                q.add(new Pair(x-1, y, count+1 ));
                q.add(new Pair(x-1, y+1, count+1));
                q.add(new Pair(x, y+1 , count+1));
                q.add(new Pair(x+1, y+1, count+1));
                q.add(new Pair(x+1, y, count+1));
                q.add(new Pair(x+1, y-1, count+1));
                q.add(new Pair(x, y-1, count+1));
                q.add(new Pair(x-1, y-1, count+1));

            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DeterMineIfACellIsReachableInTime().isReachableAtTime(1,1,1,3,2));
    }
}
