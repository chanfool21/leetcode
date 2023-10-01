package contest.sep23Weekly1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperationToMakeASpecialNumber {
    public int minimumOperations(String num) {

        String temp = "";
        int res = 0;
        try {
            if (new BigInteger(num).mod(new BigInteger(String.valueOf(25))).equals(BigInteger.ZERO)) return 0;
            Queue<String> q = new LinkedList<>();

            HashSet<String> set = new HashSet<>();

            q.offer(num);


            while (!q.isEmpty()) {
                int size = q.size();

                res++;

                for (int i = 0; i < size; i++) {
                    String val = q.poll();
                    if (new BigInteger(val).mod(new BigInteger(String.valueOf(25))).equals(BigInteger.ZERO)) return res;

                    if (set.contains(val)) continue;

                    set.add(val);

                    for (int j = 0; j < val.length(); j++) {
                        String cur = val.substring(0, j) + val.substring(j + 1, val.length());
                        temp = cur;
                        if (cur.length() > 0 && new BigInteger(cur).mod(new BigInteger(String.valueOf(25))).equals(BigInteger.ZERO)) return res;
                        if (cur.length() > 0)
                            q.offer(cur);
                    }
                }


            }
        } catch (Exception ex) {
            System.out.println(temp);
        }
        return res;
    }

    public int minimumOperations1(String num) {
        int n = num.length();
        if(n == 1 && num.charAt(0) == '0') return 0;
        HashSet<String> set = new HashSet<>(Arrays.asList("0","00", "25", "75", "50"));
        int minRes = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(set.contains(String.valueOf(num.charAt(i)) + String.valueOf(num.charAt(j)))) {
                    minRes = Math.min(minRes, (j-i-1) + (n-j-1));
                }
            }
        }

        int zeroCount = 0;
        for(int i = 0; i < n; i++) {
            if(num.charAt(i) == '0') {
                zeroCount++;
            }
        }
        minRes = Math.min(minRes, n - zeroCount);
        return minRes;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperationToMakeASpecialNumber().minimumOperations1("10"));
    }
}
