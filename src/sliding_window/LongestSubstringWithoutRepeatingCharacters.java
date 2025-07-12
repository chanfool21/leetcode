package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Set<Character> visited = new HashSet<>();
        int start = 0;
        int end = 0;

        int res = Integer.MIN_VALUE;
        while(end < n) {
            while(visited.contains(s.charAt(end))) {
                visited.remove(s.charAt(start));
                start++;
            }
            visited.add(s.charAt(end));
            if(res < (end - start + 1)) {
                res = end - start+1;
            }
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
