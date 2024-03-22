package DailyChallenges;

import java.util.List;

public class ReverseWordsInStrings3 {
    public String reverseWords(String s) {
        int n = s.length();
        int l = 0;
        int h = n-1;

        StringBuilder sb = new StringBuilder(s);
        while(l < h) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(h));
            sb.setCharAt(h, temp);
            l++;
            h--;
        }

        s = sb.toString();
        String st[] = s.split(" ");
        String res = "";
        for(int i = st.length-1; i >= 0; i--) {
            if(i != 0) {
                res+=st[i] + " ";
            } else {
                res+=st[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInStrings3().reverseWords("Main nikla oh gaddi leke"));
    }
}
