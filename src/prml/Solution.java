package prml;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int answer[] = new int[a.length];
        stack.push(0);

        for(int i = 1; i < a.length; i++) {
            while(!stack.empty() && a[stack.peek()] < a[i]) {
                int top = stack.peek();

                if(a[top] < a[i]) {
                    answer[top] = i-top;
                }

                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            int top = stack.peek();

            answer[top] = 0;

            stack.pop();
        }


        for(int i = 0; i < a.length; i++) {
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
    }
}