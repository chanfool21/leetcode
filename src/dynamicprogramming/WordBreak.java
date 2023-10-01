package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> dict = (HashSet<String>) wordDict.stream().collect(Collectors.toSet());

        int n = s.length();
        boolean dp[][] = new boolean [n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = false;

                if(i == j) {
                    if(dict.contains(s.substring(i,i+1))) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(dict.contains(s.substring(i, j+1))) {
                    dp[i][j] = true;
                } else {
                    boolean res = dp[i][j];
                    for (int k = i; k <= j; k++) {
                        res = res || (dp[i][k] && dp[k + 1][j]);
                    }

                    dp[i][j] = res;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(dict.contains(s.substring(i, j+1))) {
                    dp[i][j] = true;
                } else {
                    boolean res = dp[i][j];
                    for (int k = i; k <= j; k++) {
                        res = res || (dp[i][k] && dp[k + 1][j]);
                    }

                    dp[i][j] = res;
                }
            }
        }

        return dp[0][n-1];
    }


    public boolean wordBreak1D(String s, List<String> wordDict) {
        HashSet<String> dict = (HashSet<String>) wordDict.stream().collect(Collectors.toSet());
        if(dict.contains(s)) {
            return true;
        }

        int n = s.length();
        boolean dp[] = new boolean[n];
        Arrays.fill(dp, false);
        if(dict.contains(s.substring(0,1))) {
            dp[0] = true;
        }

        for(int i = 1; i < n; i++) {
            if(dict.contains(s.substring(0, i +1))) {
                dp[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    dp[i] = dp[i] || (dp[j] && dict.contains(s.substring(j + 1, i + 1)));
                }
            }
        }

        return dp[n-1];
    }
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "cd", "d", "e");
        System.out.println(new WordBreak().wordBreak1D("leetcode", wordDict));
    }

}
