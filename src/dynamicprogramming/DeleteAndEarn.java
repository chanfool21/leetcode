package dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn {
    int fnc(List<Integer> list, int idx, int n, Map<Integer, Integer> countMap, Integer dp[]) {
        if (idx >= n) return 0;
        if(dp[idx] != null) return dp[idx];
        if (idx < n - 1 && list.get(idx + 1) != list.get(idx) + 1) {
            return dp[idx] = countMap.get(list.get(idx)) * list.get(idx) + fnc(list, idx + 1, n, countMap, dp);
        } else {
            return dp[idx] = Math.max(countMap.get(list.get(idx)) * list.get(idx) + fnc(list, idx + 2, n, countMap, dp), fnc(list, idx + 1, n, countMap, dp));
        }
    }

    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }

        List<Integer> uniqueList = countMap.keySet().stream().collect(Collectors.toList());
        uniqueList.sort((a,b) -> (a-b));
        int n = uniqueList.size();
        Integer dp[] = new Integer[n];
        int res = fnc(uniqueList, 0, n, countMap, dp);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1,2,3,15,16,17,18}));
    }
}
