package stack;

import java.util.Stack;

public class MaximumAreaRectangleInBinaryMatrix {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int height[][] = new int[m][n];

        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == '1') height[0][i] = 1;
            else height[0][1] = 0;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') height[i][j] = 1 + height[i-1][j];
                else height[i][j] = 0;
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            result = Math.max(result, largestRectangleArea(height[i]));
        }
        return result;
    }

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
        MaximumAreaRectangleInBinaryMatrix maximumAreaRectangleInBinaryMatrix = new MaximumAreaRectangleInBinaryMatrix();
        char [][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = maximumAreaRectangleInBinaryMatrix.maximalRectangle(matrix);
        System.out.println(res);
    }
}
