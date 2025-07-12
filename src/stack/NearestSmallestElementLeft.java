package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NearestSmallestElementLeft {
    public int[] leftSmaller(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        int res[] = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                mp.put(stack.pop(), arr[i]);
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            mp.put(stack.pop(), -1);
        }

        for(int i = 0; i < n; i++) {
            res[i] = mp.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int res[] = new NearestSmallestElementLeft().leftSmaller(new int[] {1, 6, 2});
        Arrays.stream(res).forEach(System.out::println);
    }
}
