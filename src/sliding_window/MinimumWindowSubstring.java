package sliding_window;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0) + 1);
        }

        int expectedDistinctCharCount = mp.size();

        int start = 0;
        int end = 0;

        int n = s.length();
        Map<Character, Integer> currentMap = new HashMap<>();
        int currentCharSet = 0;
        String res = "";
        int resLen = Integer.MAX_VALUE;
        while (end < n) {
            char endChar = s.charAt(end);
            currentMap.put(endChar, currentMap.getOrDefault(endChar, 0) + 1);
            if (currentMap.get(endChar).equals(mp.get(endChar))) {
                currentCharSet++;
            }

            while (currentCharSet == expectedDistinctCharCount && start <= end) {
                if ((end - start + 1) < resLen) {
                    res = s.substring(start, end + 1);
                    resLen = end - start + 1;
                }
                char startChar = s.charAt(start);
                if (mp.containsKey(startChar)) {
                    currentMap.put(startChar, currentMap.get(startChar) - 1);
                    if (currentMap.get(startChar) < mp.get(startChar)) {
                        currentCharSet--;
                    }
                }
                start++;
            }
            end++;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
