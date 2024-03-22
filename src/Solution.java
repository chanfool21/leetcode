import java.util.*;

public class Solution {
    public static int solution(String[] S, int K) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Step 2 & 3: Count the frequency of each letter across all strings
        for (String str : S) {
            for (char ch : str.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }
        
        // Step 4: Sort the frequency map by frequencies in descending order
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(sortedList, (a, b) -> b.getValue() - a.getValue());
        
        // Step 5 & 6: Iterate over the sorted frequency map to build strings
        int count = 0;
        for (Map.Entry<Character, Integer> entry : sortedList) {
            int freq = entry.getValue();
            if (freq <= K) {
                count++;
                K -= freq;
            } else {
                break;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        String[] S1 = {"abc", "abb", "cb", "a", "bbb"};
        int K1 = 2;
        System.out.println(solution(S1, K1)); // Output: 3

        String[] S2 = {"adf", "jibh", "jegi", "eij", "adf"};
        int K2 = 3;
        System.out.println(solution(S2, K2)); // Output: 2

        String[] S3 = {"abod", "efgh"};
        int K3 = 3;
        System.out.println(solution(S3, K3)); // Output: 0

        String[] S4 = {"bc", "edf", "fde", "dge", "abed"};
        int K4 = 4;
        System.out.println(solution(S4, K4)); // Output: 3
    }
}
