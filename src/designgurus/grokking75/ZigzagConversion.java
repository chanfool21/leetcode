package designgurus.grokking75;

public class ZigzagConversion {
    public String convert(String s, int rowLimit) {
        char a[][] = new char[rowLimit][s.length()];
        int i = 0, j = 0;
        for(i = 0; i < rowLimit; i++) {
            for (j = 0; j < s.length(); j++) {
                a[i][j] = '-';
            }
        }

        i = 0;
        j = 0;
        int ctr = 0;
        while(ctr < s.length()) {
            while(i < rowLimit) {
                if(ctr >= s.length()) break;
                a[i][j] = s.charAt(ctr);
                i++;
                ctr++;
            }

            i-=2;
            i = Math.max(i, 0);
            j++;
            while(i >= 0 && j < s.length()) {
                if(ctr >= s.length()) break;
                a[i][j] = s.charAt(ctr);
                i--;
                j++;
                ctr++;
            }
            i+=2;
            i = Math.min(i, rowLimit-1);
        }

        String result = "";
        for(i = 0; i < rowLimit; i++) {
            for (j = 0; j < s.length(); j++) {
                if(a[i][j] != '-') result += a[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 3));
    }
}
