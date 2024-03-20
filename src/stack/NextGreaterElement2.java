package stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[nums.length];

        for(int i = nums.length-1; i >= 0; i--) {
            stack.add(nums[i]);
        }

        for(int i = nums.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = new NextGreaterElement2().nextGreaterElements(new int[] {1,2,3,4,3});

        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
