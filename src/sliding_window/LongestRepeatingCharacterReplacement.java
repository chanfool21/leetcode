package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    Character getMaximumFrequencyCharacter(Map<Character, Integer> freqMap) {
        Character result = '\0';
        int maxFreq = 0;
        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
            Character currentCharacter = entry.getKey();
            int currentFreq = entry.getValue();

            if(currentFreq > maxFreq) {
                result = currentCharacter;
                maxFreq = currentFreq;
            }
        }

        return result;

    }
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;

        int start = 0;
        int end = 0;

        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        int result = 0;
        while(end < n) {
            if(freqMap.containsKey(s.charAt(end))) {
                freqMap.put(s.charAt(end), freqMap.get(s.charAt(end)) + 1);
            } else {
                freqMap.put(s.charAt(end), 1);
            }

            Character maxFreqCharacter = getMaximumFrequencyCharacter(freqMap);
            int maxFrequency = freqMap.get(maxFreqCharacter);

            if((end - start + 1) - maxFrequency > k) {
                freqMap.put(s.charAt(start), freqMap.get(s.charAt(start)) -1);
                if(freqMap.get(s.charAt(start)) == 0) {
                    freqMap.remove(s.charAt(start));
                }
                start++;
            }

            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }
}
