package array;

public class ZigzagConversion {
    public String convert(String s, int rowLimit) {
        int n = s.length();
        int ctr = 0;
        int r = 0;
        int c = 0;
        int colLimit = 1000;
        char res[][] = new char[rowLimit][colLimit];
        for(int i = 0; i < rowLimit; i++) {
            for(int j = 0; j < colLimit; j++) {
                res[i][j] = '_';
            }
        }

        while(true) {
            if(ctr == n) break;

            while(r < rowLimit && ctr < n) {
                res[r++][c] = s.charAt(ctr++);
            }
            if(r >= rowLimit) {
                r -= 2;
                c++;
                if(r < 0) {
                    r = 0;
                    continue;
                }
            }

            while(r >= 0 && c < colLimit && ctr < n) {
                res[r--][c++] = s.charAt(ctr++);
            }
            if(r < 0) {
                r = 1;
                if(c < colLimit) {
                    c -= 1;
                }
            }
        }

        String resultString = "";
        for(int i = 0; i < rowLimit; i++) {
            for(int j = 0; j < colLimit; j++) {
                if(res[i][j] == '_') {
                    continue;
                }
                resultString += res[i][j];
            }
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("AB", 1));
    }

}
