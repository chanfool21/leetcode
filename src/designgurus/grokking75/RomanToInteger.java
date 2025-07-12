package designgurus.grokking75;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{
    static Map<Character, Integer> mp = new HashMap<>();
    static public void populateMap() {
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
    }

    public int romanToInt(String s) {

        RomanToInteger.populateMap();
        int n = s.length();
        if(n == 1) return mp.get(s.charAt(0));
        int i = n-2;

        int sum = mp.get(s.charAt(n-1));
        while(i >= 0) {
            if(mp.get(s.charAt(i)) < mp.get(s.charAt(i+1))) {
                sum -= mp.get(s.charAt(i));
            } else {
                sum += mp.get(s.charAt(i));
            }
            i--;
        }
        return sum;
    }
}
