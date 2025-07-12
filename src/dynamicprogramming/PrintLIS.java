package dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintLIS {
        public List<Integer> longestIncreasingSubsequence(int[] arr) {
            LinkedList<Integer> result = new LinkedList<>();

            int n = arr.length;
            if(n == 1) {
                result.add(arr[0]);
                return result;
            }

            int dp[] = new int[n];
            Arrays.fill(dp, 1);

            dp[0] = 1;
            int track[] = new int[n];

            for(int i = 1; i < n; i++) {
                track[i] = i;
                for(int j = 0; j < i; j++) {
                    if(arr[i] > arr[j]) {
                        if(dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            track[i] = j;
                        }
                    }
                }
            }

            int curMax = Integer.MIN_VALUE;
            int curI = n-1;

            for(int i = 0; i < n; i++) {
                if(curMax < dp[i]) {
                    curMax = dp[i];
                    curI = i;
                }
            }


            while(track[curI] != curI) {
                result.addFirst(arr[curI]);
                curI = track[curI];
            }
            result.addFirst(arr[curI]);
            return result;
        }

    public static void main(String[] args) {
        List<Integer> result = new PrintLIS().longestIncreasingSubsequence(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80});
        result.forEach(System.out::println);
    }

}


