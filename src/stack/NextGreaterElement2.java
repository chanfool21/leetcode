package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> idxToGreaterElementMap = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < 2*n; i++) {
            int curIdx = i%n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[curIdx]) {
                idxToGreaterElementMap.put(stack.peek(), nums[curIdx]);
                stack.pop();
            }
            stack.add(curIdx);
        }

        while(!stack.isEmpty()) {
            if(!idxToGreaterElementMap.containsKey(stack.peek()))
                idxToGreaterElementMap.put(stack.peek(), -1);
            stack.pop();
        }

        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = idxToGreaterElementMap.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int res[] = new NextGreaterElement2().nextGreaterElements(new int[] {1,2,3,4,3});
        Arrays.stream(res).forEach(System.out::println);
    }
}
