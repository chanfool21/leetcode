package DailyChallenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class StringMinExtraCharacters {

    int fnc(String s, int l, int h, HashSet<String> set, int dp[][]) {
        if(l > h) {
            return 0;
        } else if(dp[l][h] != -1) {
            return dp[l][h];
        }
        else {
            int res = Integer.MAX_VALUE;
            for(int i = l; i <= h; i++) {
                String firstPart = s.substring(l,i+1);
                int val = 0;
                if(set.contains(firstPart)) {
                    val = fnc(s, i+1, h, set, dp);
                } else {
                    val = firstPart.length() + fnc(s, i+1, h, set, dp);
                }
                res = Math.min(val, res);
            }
            dp[l][h] = res;
            return dp[l][h];
        }
    }
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        String substr = "";
        int dp[][] = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.setAll(row , col -> -1));
        HashSet<String> set = (HashSet<String>) Arrays.stream(dictionary).collect(Collectors.toSet());
        return fnc(s, 0, n-1, set, dp);
    }
    /*
    "dwmodizxvvbosxxw"
["ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"]
     */
    public static void main(String[] args) {
        System.out.println(new StringMinExtraCharacters().minExtraChar("dwmodizxvvbosxxw", new String[] {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"}));
    }
}
