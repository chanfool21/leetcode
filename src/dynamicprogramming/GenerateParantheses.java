package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    void fnc(int n, int leftCount, int rightCount, String curString, List<String> result) {
        if(n == 1) {
            result.add("()");
            return;
        }

        if(leftCount > n) return;
        if(rightCount > leftCount) return;

        if(rightCount == n) {
            String temp = curString;
            result.add(temp);
            return;
        }

        fnc(n, leftCount+1, rightCount, curString + "(", result);
        fnc(n, leftCount, rightCount+1, curString + ")", result);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String curString = "";

        fnc(n, 0, 0, curString, result);
        return result;
    }

    public static void main(String[] args) {
        new GenerateParantheses().generateParenthesis(3).forEach(ele -> System.out.println(ele));
    }
}
