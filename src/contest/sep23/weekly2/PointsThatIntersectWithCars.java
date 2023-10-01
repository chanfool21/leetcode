package contest.sep23.weekly2;
import java.util.*;
public class PointsThatIntersectWithCars {
    public int merge(List<List<Integer>> intervals) {

        // sort our intervals
        intervals.sort((a,b) -> (a.get(0) - b.get(0)));

        ArrayList<int[]> ans  =  new ArrayList<>();
        // intial range
        int start  =  intervals.get(0).get(0);
        int end =  intervals.get(0).get(1);

        int  i =1;
        while(i<intervals.size()){
            int s = intervals.get(i).get(0);
            int e = intervals.get(i).get(1);
            // next interval start is smaller than prev end and array is sorted
            // so these two internal can merge
            if( s<=end  ) {
                // so merge both intervals
                end =  Math.max(end,e);
            }
            else{ // if merge not possible , then insert prev interval into list
                ans.add(new int[]{start,end});
                start = s;
                end =  e;
            }
            i++;
        }

        ans.add(new int[] {start,end});

        int arr[][] =  new int[ans.size()][];
        for(i=0;i<ans.size();i++) {
            int a[] =  new int[2];
            for(int j=0;j<2;j++) {
                a[j] =  ans.get(i)[j];
            }
            arr[i] =  a;
        }

        int ans1 = 0;
        for(i = 0; i < arr.length; i++) {
            ans1 += arr[i][1] - arr[i][0] + 1;
        }
        return   ans1;

        // or
        //  return ans.toArray(new int[0][]);



    }
    public int numberOfPoints(List<List<Integer>> nums) {
        int res = merge(nums);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> num = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(3);

        num.add(temp);
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(5);
        temp1.add(8);
        num.add(temp1);


        System.out.println(new PointsThatIntersectWithCars().numberOfPoints(num));
    }
}
