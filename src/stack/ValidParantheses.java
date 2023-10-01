package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Map<Character, Character> isValidParanthesesMap = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                Character top = stack.peek();
                if(!isValidParanthesesMap.containsKey(s.charAt(i))) {
                    if(isValidParanthesesMap.containsKey(top) && isValidParanthesesMap.get(top) != s.charAt(i)) {
                        return false;
                    }
                    if(isValidParanthesesMap.containsKey(top))
                        stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        if(!stack.isEmpty()) return false;
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new ValidParantheses().isValid("))"));
    }
}
