package stack;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstring {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'B' ) {
                if(!stack.isEmpty() && stack.peek() == 'A') {
                    stack.pop();
                    continue;
                }
            } else if(s.charAt(i) == 'D') {
                if(!stack.isEmpty() && stack.peek() == 'C') {
                    stack.pop();
                    continue;
                }
            }
            stack.add(s.charAt(i));
        }

        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumStringLengthAfterRemovingSubstring().minLength("ABFCACDB"));
    }
}
