package twopointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        int m = s.length();
        int n = t.length();

        if(m == 0) return true;

        while(i < m && j < n) {
            if(t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
            if(i == m) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("ab", "adcb"));
    }
}
