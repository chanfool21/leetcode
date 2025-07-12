package stack;

import java.util.Stack;

public class DecodeStrings {

    boolean isIntegerString(String s) {
        if (s == null || s.length() != 1) {
            return false;
        }
        char c = s.charAt(0);
        return c >= '0' && c <= '9';
    }

    public static boolean isLowerCase(String str) {
        if (str == null || str.length() != 1) {
            return false;
        }
        char c = str.charAt(0);
        return Character.isLowerCase(c);
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == ']') {
                String currentString = "";
                int countInteger = 0;
                while(!stack.isEmpty()) {
                    String currentChar = stack.peek();
                    if(currentChar.equals("[")) {
                        stack.pop();
                        String countString = "";
                        while(!stack.isEmpty() && isIntegerString(stack.peek())) {
                            countString += stack.pop();
                        }

                        countInteger = Integer.parseInt(new StringBuilder(countString).reverse().toString());
                        break;
                    } else {
                        currentString += currentChar;
                        stack.pop();
                    }
                }
                String newString = "";
                for(int j = 0; j < countInteger; j++) {
                    newString+= currentString;
                }
                stack.add(newString);
            } else {
                stack.add(String.valueOf(s.charAt(i)));
            }

            i++;
        }

        String result = "";
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeStrings().decodeString("100[leetcode]"));
    }
}
