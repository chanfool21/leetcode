package dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class FrogJumpLC403 {
    public boolean canCross(int[] stones) {
        // First check: if second stone is not at position 1, frog can't make first jump
        if (stones[1] != 1) return false;
        
        Set<Integer> stoneSet = Arrays.stream(stones).boxed().collect(Collectors.toSet());
        Map<String, Boolean> dp = new HashMap<>();
        return fnc(stoneSet, 1, stones[stones.length-1], 1, dp);
    }

    boolean fnc(Set<Integer> stoneSet, int idx, int dest, int k, Map<String, Boolean> dp) {
        if(idx > dest || idx < 0 || !stoneSet.contains(idx)) {
            return false;
        }
        if(idx == dest) {
            return true;
        }

        String key = idx + "_" + k;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        boolean result = false;
        // Try all possible next jumps: k-1, k, k+1
        for(int nextJump = k-1; nextJump <= k+1; nextJump++) {
            if(nextJump > 0) { // Only try positive jumps
                result = result || fnc(stoneSet, idx + nextJump, dest, nextJump, dp);
            }
        }

        dp.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        FrogJumpLC403 solution = new FrogJumpLC403();
        
        // Test cases
        int[][] testCases = {
            {0, 2},                          // Should return false
            {0, 1, 3, 5, 6, 8, 12, 17},     // Should return true
            {0, 1, 2, 3, 4, 8, 9, 11}       // Should return false
        };
        
        for(int[] test : testCases) {
            System.out.println("Input: " + Arrays.toString(test));
            System.out.println("Can cross: " + solution.canCross(test));
            System.out.println();
        }
    }
}
