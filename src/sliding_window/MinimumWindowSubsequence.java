package sliding_window;

public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;
        int start  = -1;
        int end = -1;
        int minWindowLength = Integer.MAX_VALUE;
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(i < n) {
            if(s1.charAt(i) == s2.charAt(j)) {
                if(start == -1) {
                    start = i;
                }
                if(j == m-1) {
                    end = i;
                    start = i;
                    while(j >= 0) {
                        if(s1.charAt(start) == s2.charAt(j)) {
                            j--;
                        }
                        start--;
                    }
                    start++;

                    if(minWindowLength > (end-start+1)) {
                        minWindowLength = end - start + 1;
                        res[0] = start;
                        res[1] = end;
                    }
                    i = start + 1;
                    j = 0;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
            }
        }
        if(res[0] == -1 || res[1] == -1) {
            return "";
        }
        return s1.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        String s1 = "ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl";
        String s2 = "ntimcimzah";
        String expectedResult = "nevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaph";
        System.out.println(new MinimumWindowSubsequence().minWindow(s1,s2));
    }
}