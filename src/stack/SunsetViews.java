package stack;

import graph.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = buildings.length;
        if(direction.equals("EAST")) {
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                    stack.pop();
                }
                stack.add(i);
            }


            while(!stack.isEmpty()) {
                result.add(stack.pop());
            }
            reverse(result);
            return result;

        } else {
            for(int i = n-1; i >= 0; i--) {
                while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                    stack.pop();
                }
                stack.add(i);
            }

            while(!stack.isEmpty()) {
                result.add(stack.pop());
            }

            //reverse(result);
            return result;
        }
    }

    void reverse(ArrayList<Integer>list) {
        int l = 0;
        int h = list.size()-1;

        while(l < h) {
            int temp = list.get(l);
            list.set(l, list.get(h));
            list.set(h, temp);
            l++;
            h--;
        }
    }
    public static void main(String[] args) {
        List<Integer> result = new SunsetViews().sunsetViews(new int[] {3, 5, 4, 4, 3, 1, 3, 2}, "WEST");
        result.stream().forEach(System.out::println);
    }
}
