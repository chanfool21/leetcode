package stack;

import java.util.Stack;

public class LargestPark {
    public int largestPark(boolean[][] land) {
        // Write your code here.
        int m = land.length;
        int n = land[0].length;

        int height[] = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            height[i] = 0;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == true) {
                    height[j] = 0;
                }
                if(i > 0) {
                    if(land[i][j] == false) {
                        height[j] += 1;
                    }
                } else {
                    if(land[i][j] == false) {
                        height[j] = 1;
                    }
                }
            }
            Stack<Integer> stack = new Stack<>();
            int previousLesserHeight[] = new int[n];
            int nextLesserHeight[] = new int[n];

            for(int k = 0; k < n; k++) {
                while(!stack.isEmpty() && height[stack.peek()] > height[k]) {
                    nextLesserHeight[stack.pop()] = k;
                }
                stack.add(k);
            }

            while(!stack.isEmpty()) {
                nextLesserHeight[stack.pop()] = n;
            }


            for(int k = n-1; k >= 0; k--) {
                while(!stack.isEmpty() && height[stack.peek()] > height[k]) {
                    previousLesserHeight[stack.pop()] = k;
                }
                stack.add(k);
            }


            while(!stack.isEmpty()) {
                previousLesserHeight[stack.pop()] = -1;
            }

            for(int k = 0; k < n; k++) {
                maxArea = Math.max(maxArea, height[k] * (nextLesserHeight[k] - previousLesserHeight[k] - 1));
            }
        }


        return maxArea;
    }

    public static void main(String[] args) {
//        System.out.println(new LargestPark().largestPark(new boolean[][] {
//                {false, true,  true,  true,  false},
//                {false, false, false, true,  false},
//                {false, false, false, false, false},
//                {false, true,  true,  true,  true}
//        }));
        System.out.println(new LargestPark().largestPark(new boolean[][] {
                {false}
        }));
    }
}
