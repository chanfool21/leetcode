public class SumString {

    boolean fnc(String str, int i, int j, int m, int n) {
        if(m == n) {

        }
        return false;

    }
    boolean isSumString(String str) {
        /*
        12243660
            fnc(str, 0,
         */
        int n = str.length();
        return fnc(str, 0, 0, 0, n);

    }

    public static void main(String[] args) {
        /*
        “12243660” is a sum string.

        1,1 2,2 2,
Explanation : 24 + 36 = 60, 12 + 24 = 36

“1111112223” is a sum string.
Explanation: 111+112 = 223, 1+111 = 112

“2368” is not a sum string
         */


    }
}
