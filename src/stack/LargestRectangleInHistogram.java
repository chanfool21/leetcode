package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int nearestLowValueInLeft[] = new int[heights.length];
        int nearestLowValueInRight[] = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()) {
                nearestLowValueInLeft[i] = -1;
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    nearestLowValueInLeft[i] = -1;
                } else {
                    nearestLowValueInLeft[i] = stack.peek();
                }
            }
            stack.add(i);
        }

        stack.clear();

        for(int i = heights.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nearestLowValueInRight[i] = heights.length;
            } else {
                nearestLowValueInRight[i] = stack.peek();
            }
            stack.add(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(heights[i] * (nearestLowValueInRight[i] - nearestLowValueInLeft[i] - 1), maxArea);
        }

        return maxArea;

    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[] {2,4}));
    }
}
