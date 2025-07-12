package dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LongestIncreasingSubsequenceRecursion {

    public static int longestSubseqLen(List<Integer> nums) {

        if(nums.size() == 0) return 0;
//        int lis = 1;
//        for(int i = 0; i < nums.size(); i++) {
//            lis = Math.max(lis, fnc(nums, i));
//        }
//        return lis;
        return longestSubLenDP(nums);
    }


    public static int longestSubLenDP(List<Integer> nums) {
        int dp[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            dp[i] = 1;
        }

        int lis = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(nums.get(i) > nums.get(j)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }

    static int fnc(List<Integer> nums, int idx) {
        int lis = 1;
        for(int j = 0; j < idx; j++) {
            if(nums.get(j) < nums.get(idx)) {
                lis = Math.max(lis, 1 + fnc(nums, j));
            }
        }

        return lis;
    }



    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(longestSubseqLen(numsList));
    }
    
}

