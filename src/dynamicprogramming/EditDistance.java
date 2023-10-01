package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
    int fnc(String s1, String s2, int i, int j, int m, int n, Map<String, Integer> dp) {
        String key = i + "_" + j;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        if(i == m && j == n) {
             dp.put(key,0);
             return 0;
        }

        if(i == m) {
            dp.put(key,n-j);
            return n-j;
        } else if(j == n) {
            dp.put(key,m - i);
            return m - i;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            dp.put(key, fnc(s1, s2, i+1, j+1, m, n, dp) );
            return dp.get(key);
        } else {
            int r1 = fnc(s1,s2,i+1, j+1, m, n, dp);
            int r2 = fnc(s1, s2, i, j+1, m , n,dp);
            int r3 = fnc(s1, s2, i+1, j, m , n,dp);

            dp.put(key, 1+ Math.min(r1,Math.min(r2, r3)));
            return dp.get(key);
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Map<String, Integer> dp = new HashMap<>();
        return fnc(word1, word2, 0, 0, m, n, dp);
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("aab", "d"));
    }
}
