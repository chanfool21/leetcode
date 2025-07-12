package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DivisorGameLC1025 {
    public static boolean divisorGame(int n) {
        boolean firstPlayerChance = true;
        Map<String, Boolean> dp = new HashMap<>();
        return fnc(n, firstPlayerChance, dp);
    }

    static boolean fnc(int n, boolean firstPlayerChance, Map<String, Boolean> dp) {
        // Base cases
        if(n == 1) return false;  // Whoever gets 1 loses
        if(n == 2) return firstPlayerChance;  // First player wins with 2
        if(n == 3) return !firstPlayerChance;  // Second player wins with 3

        String key = n + "_" + firstPlayerChance;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        // Try all possible moves
        for(int j = 1; j < n; j++) {
            if(n % j == 0) {
                // If current player can make a move that leads to opponent's loss
                // then this is a winning position for current player
                if(!fnc(n-j, !firstPlayerChance, dp)) {
                    dp.put(key, true);
                    return true;
                }
            }
        }

        // If no winning move exists, this is a losing position
        dp.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {2, 3, 4, 5, 45};
        for(int n : testCases) {
            System.out.println("Input: " + n);
            System.out.println("Output: " + divisorGame(n));
            System.out.println();
        }
    }
}
