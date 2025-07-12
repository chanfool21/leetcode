package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[a.length];

        for(int i = 0; i < a.length; i++) {
            while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
                res[stack.peek()] = (i-stack.peek());
                stack.pop();
            }

            stack.add(i);
        }

        while(!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }

        return res;
    }

    public static void main(String[] args) {
        int res[] = new DailyTemperatures().dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
        Arrays.stream(res).forEach(System.out::println);
    }
}
