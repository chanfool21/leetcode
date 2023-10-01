package microsoft_leetcode_assesments;
import java.util.*;

public class GoodPair {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, List<Integer> > mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                mp.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mp.put(nums[i], list);
            }
        }
        int cnt = 0;
        for(Map.Entry<Integer, List<Integer>> entry: mp.entrySet()) {
            List<Integer> list = entry.getValue();
            if(list.size() >= 2) {

                for(int i = 0; i < list.size(); i++) {
                    for(int j = i+1; j < list.size(); j++) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new GoodPair().numIdenticalPairs(new int[] {1,2,3,1,1,3}));
    }
}
