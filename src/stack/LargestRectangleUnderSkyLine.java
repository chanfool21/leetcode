package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleUnderSkyLine {
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        int n = buildings.size();
        int previousLesserHeightRectangle[] = new int[n];
        int nextLesserHeightRectangle[] = new int[n];

        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && buildings.get(stack.peek()) > buildings.get(i)) {
                previousLesserHeightRectangle[stack.pop()] = i;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            previousLesserHeightRectangle[stack.pop()] = -1;
        }


        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && buildings.get(stack.peek()) > buildings.get(i)) {
                nextLesserHeightRectangle[stack.pop()] = i;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            nextLesserHeightRectangle[stack.pop()] = n;
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, buildings.get(i) * (nextLesserHeightRectangle[i] - previousLesserHeightRectangle[i] -1));
        }
        return maxArea == Integer.MIN_VALUE? 0: maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleUnderSkyLine().largestRectangleUnderSkyline(new ArrayList<>(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2))));
    }
}
