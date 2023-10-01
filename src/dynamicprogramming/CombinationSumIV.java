package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    int factorial(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    int countPossibleCombination(Map<Integer, Integer> mp) {
        int totalNumbers = 0;
        int duplicateFact = 1;
        if(mp.size() == 0) return 0;
        for(Integer value: mp.values()) {
            totalNumbers += value;
            duplicateFact *= factorial(value);
        }

        return factorial(totalNumbers) / duplicateFact;
    }
    //Incorrect recursion -> get it reviewed
    int fnc(int idx, int nums[], int n, int target, Map<Integer, Integer> mp, int dp[][]) {

        if(target < 0 || idx == n) return 0;
        if(dp[idx][target] != -1) {
            return dp[idx][target];
        }
        if(target == 0) {
            return  dp[idx][target] = countPossibleCombination(mp);
        }

        int include = 0;
        if(mp.containsKey(nums[idx])) {
            mp.put(nums[idx], mp.get(nums[idx])+1);
        } else {
            mp.put(nums[idx], 1);
        }

        include = fnc(idx, nums, n, target - nums[idx], mp, dp);
        if(mp.containsKey(nums[idx])) {
            mp.put(nums[idx], mp.get(nums[idx])-1);
            if(mp.get(nums[idx]) == 0) {
                mp.remove(nums[idx]);
            }
        }

        int exclude = fnc(idx + 1, nums, n, target, mp, dp);

        return dp[idx][target] = include + exclude;
    }

    int fnc1(int nums[] ,int target, int dp[]) {
        if(target == 0) {
            return 1;
        }

        if(target < 0) {
            return 0;
        }

        if(dp[target] != -1) {
            return dp[target];
        }


        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            ans+=fnc1(nums, target - nums[i], dp);
        }
        return dp[target] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
//        int dp[][] = new int[nums.length][target+1];
//        Arrays.stream(dp).forEach(row -> Arrays.setAll(row, col -> -1));
        //int res =  fnc(0, nums, nums.length, target, mp, dp);
        //return res;
        int dp[] = new int[target+1];
        Arrays.setAll(dp, col -> -1);
        return fnc1(nums, target, dp);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[] {5,1,8} , 24));
    }
}
