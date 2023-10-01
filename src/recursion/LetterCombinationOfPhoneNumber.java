package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    private static final Map<Integer, String> numberToLettersMap = new HashMap<Integer, String> ()
    {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

    void fnc(int idx, String digits, int n, String curString, List<String> response) {
        if(idx == n) {
            response.add(curString);
            return;
        }

        String str = numberToLettersMap.get(digits.charAt(idx) - '0');
        for(int i = 0; i < str.length(); i++) {
            fnc(idx+1, digits, n,curString + str.charAt(i), response);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String curString = "";
        if(digits.length() == 0) {
            return result;
        }
        fnc(0, digits, digits.length(), curString, result);
        return result;

    }

    public static void main(String[] args) {
        List<String> result = new LetterCombinationOfPhoneNumber().letterCombinations("23");
        result.forEach(str -> System.out.println(str));
    }
}
