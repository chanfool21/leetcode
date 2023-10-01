package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

    boolean fnc(String s1, String s2, int i, int j, int m, int n, String s3, Map<String, Boolean> dp) {


        if(i == m && j == n) {
            return true;
        }

        String key = i + "_" + j;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        if(i == m) {
            if (s3.charAt(i+j) == s2.charAt(j))  {
                dp.put(key, fnc(s1, s2, i, j+1, m, n, s3, dp));
            }
            else {
                dp.put(key,false);
            }
            return dp.get(key);
        }

        if(j == n) {
            if (s3.charAt(i+j) == s1.charAt(i))  {
                dp.put(key, fnc(s1, s2, i+1, j, m, n, s3, dp));
            } else {
                dp.put(key,false);
            }
            return dp.get(key);
        }

        boolean r1 = false, r2 = false;
        if(s1.charAt(i) == s3.charAt(i+j)) {
            r1 = fnc(s1, s2, i+1, j, m, n, s3, dp);
        }
        if(s2.charAt(j) == s3.charAt(i+j)) {
            r2 = fnc(s1, s2, i, j+1, m, n, s3,dp);
        }

        boolean res = (r1 || r2);
        dp.put(key, res);
        return dp.get(key);

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        Map<String, Boolean> dp = new HashMap<>();
        return fnc(s1, s2, 0, 0,  m, n, s3, dp);
    }

    public static void main(String[] args) {

// s1 t1 s2 t2
// s1 t1 s2 t2 s3
// t1 s1 t2 s2 t3
// s1 t1 s2 t2 t3
// T'  s1 t4 s2 , here T' could be combination of t1,t2,t3 but they are coming together, they will form a big substring of s2, so |m-n| <=1 will never get violated

        System.out.println(new InterleavingString().isInterleave("aa", "ab", "abaa"));
    }
}
