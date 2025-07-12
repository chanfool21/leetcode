package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfSubarrayWithMinimums {
    long Mod = (long) (1e9) + 7;
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int result = 0;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int minIndex = stack.pop();
                int previousIndex = -1;
                if(!stack.isEmpty()) {
                    previousIndex = stack.peek();
                }
                Long countSubarrays = ((minIndex - previousIndex) * (i - minIndex)) % Mod;
                result += (arr[minIndex] * countSubarrays) % Mod;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            int minIndex = stack.pop();
            int previousIndex = -1;
            if(!stack.isEmpty()) {
                previousIndex = stack.peek();
            }
            Long countSubarrays = ((minIndex - previousIndex) * (n - minIndex)) % Mod;
            result += (arr[minIndex] * countSubarrays) % Mod;
        }

        return (int) (result%Mod);
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayWithMinimums().sumSubarrayMins(new int[] {3,1,2,4}));
    }
}
