package outbrain;

import java.util.Arrays;

public class LongestCommonPrefix {

    String getCommonPrefix(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int i = 0;
        int j = 0;

        String prefix = "";

        while(i < m && j < n) {
            if(str1.charAt(i) == str2.charAt(j)) {
                prefix += str1.charAt(i);
                i++;
                j++;
            } else {
                break;
            }
        }

        return prefix;
    }
    String findLongestCommonPrefix(String [] input) {
        String result = null;
        int n = input.length;
        if(n == 1) return input[0];
        Arrays.sort(input, (a,b) -> (a.length() - b.length()));


        int i = 1;
        String prefix = input[0];
        while(i < n) {
            prefix = getCommonPrefix(prefix, input[i]);
            if(prefix.length() == 0) return "";
            i++;
        }
        result = prefix;
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.findLongestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
