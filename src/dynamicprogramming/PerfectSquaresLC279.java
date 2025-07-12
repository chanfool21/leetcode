package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquaresLC279 {

    static boolean isPerfectSquare(int num) {
        // Using integer arithmetic to avoid floating-point precision issues
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static int perfectSquares(int n) {
//        if (isPerfectSquare(n)) return 1;
//        // Base cases
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//
//        int minSquares = Integer.MAX_VALUE;
//
//        // Try all perfect squares less than n
//        for (int i = 1; i*i <= n; i++) {
//            int remaining = n - (i*i);
//            int result = perfectSquares(remaining);
//            if (result != Integer.MAX_VALUE) {
//                minSquares = Math.min(minSquares, result + 1);
//            }
//        }
//
//        return minSquares;
        Map<Integer, Integer> dp = new HashMap<>();
        return fnc(n, dp);
    }

    static int fnc(int n, Map<Integer, Integer> dp) {
        if(dp.containsKey(n)) return dp.get(n);
//        if (isPerfectSquare(n)) return 1;
        // Base cases
        if (n == 0) return 0;
//        if (n == 1) return 1;

        int minSquares = Integer.MAX_VALUE;

        // Try all perfect squares less than n
        for (int i = 1; i*i <= n; i++) {
            int remaining = n - (i*i);
            int result = 1 + fnc(remaining, dp);
            if (result != Integer.MAX_VALUE) {
                minSquares = Math.min(minSquares, result + 1);
            }
        }

        dp.put(n, minSquares);
        return minSquares;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {9997};
        System.out.println(perfectSquares(9997));
//        for(int n : testCases) {
//            System.out.println("Input: " + n);
//            System.out.println("Output: " + perfectSquares(n));
//            System.out.println();
//        }
    }
}
