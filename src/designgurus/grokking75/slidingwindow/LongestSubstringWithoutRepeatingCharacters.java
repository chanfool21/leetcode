package designgurus.grokking75.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        // ToDo: Write Your Code Here.
        int l = 0;
        int r = 0;

        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int n = str.length();

        while(r < n) {
            Character currentChar = str.charAt(r);
            if(mp.containsKey(currentChar) && mp.get(currentChar) >= l) {

                l = mp.get(currentChar)+1;

            }
            mp.put(currentChar, r);
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abrkaabcdefghijjxxx"));
    }
}
