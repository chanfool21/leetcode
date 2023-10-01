package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class StringSubsequenceGame {
    static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    static void generateSubsequence(String s, int idx, int n, String curString, TreeSet<String> result) {
        if(idx == n) {
            if(!vowels.contains(curString.charAt(curString.length() -1)))
                result.add(curString);
            return;
        }

        generateSubsequence(s, idx+1, n, curString+s.charAt(idx), result);
        generateSubsequence(s, idx+1, n, curString, result);
    }
    static TreeSet<String> allPossibleSubsequences(String s) {
        // code here
        int n = s.length();
        TreeSet<String> result = new TreeSet<>();
        if(n == 0) return result;
        for(int i = 0; i < n; i++) {
            if(vowels.contains(s.charAt(i))) {
                generateSubsequence(s, i+1, n, "" + s.charAt(i), result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeSet<String> response = allPossibleSubsequences("aba");
        for(String str: response) {
            System.out.println(str);
        }
    }

}
