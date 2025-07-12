package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LargestDivisibleSubset {
    public static int findLargestSubset(List<Integer> nums) {
        // WRITE YOUR BRILLIANT CODE HERE
        nums.sort((a,b) -> (a-b));

        //return fnc(nums, new ArrayList<>(), 0) ;
        return findLargestSubsetDP(nums);
    }

    static int fnc(List<Integer> nums, List<Integer> curr, int index) {
        if(index >= nums.size()) {
            return curr.size();
        }

        int res = Integer.MIN_VALUE;
        if(curr.isEmpty() || nums.get(index) % curr.get(curr.size() - 1) == 0) {
            curr.add(nums.get(index));
            res = Math.max(res, fnc(nums, curr, index+1));
            curr.remove(curr.size() - 1);
        }

        res = Math.max(res, fnc(nums, curr, index+1));

        return res;
    }

    static int findLargestSubsetDP(List<Integer> nums) {
        int dp[] = new int[nums.size()];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(nums.get(i) % nums.get(j) == 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        if(res != 0) return res+1;
        return res;
    }

    static List<Integer> generateLargestSubsetDP(List<Integer> nums) {
        int dp[] = new int[nums.size()];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(nums.get(i) % nums.get(j) == 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        if(res == 0) return new ArrayList<>();

        int idx = nums.size()-1;
        for(int i = nums.size()-1; i >= 0; i--) {
            if(dp[i] == res) {
                idx = i;
            }
        }

        int cur = dp[idx];
        List<Integer> ls = new ArrayList<>();
        ls.add(nums.get(idx));
        for(int i = idx-1; i >= 0; i--) {
            if(dp[i] == cur-1 && (ls.isEmpty() || ls.get(ls.size() - 1) % nums.get(i) == 0)) {
                ls.add(nums.get(i));
                cur = cur-1;
            }
        }

        return ls;
    }

    public static void main(String[] args) {
        // Method 1: Using HashSet constructor with Arrays.asList
        int[] stones = {1, 2, 3, 2, 1};  // example array
        Set<Integer> set1 = new HashSet<>();
        for(int stone : stones) {
            set1.add(stone);
        }

        // Method 2: Using Arrays.asList
        Integer[] stonesInteger = {1, 2, 3, 2, 1};  // array must be Integer[], not int[]
        Set<Integer> set2 = new HashSet<>(Arrays.asList(stonesInteger));

        // Method 3: Using addAll with ArrayList
        Set<Integer> set3 = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int stone : stones) {
            list.add(stone);
        }
        set3.addAll(list);

        // Print results
        System.out.println("Set 1: " + set1);  // {1, 2, 3}
        System.out.println("Set 2: " + set2);  // {1, 2, 3}
        System.out.println("Set 3: " + set3);  // {1, 2, 3}
        
        // Original example
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(LargestDivisibleSubset.generateLargestSubsetDP(nums));
    }
}
