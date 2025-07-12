package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] collidingAsteroids(int[] asteroids) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty()) {
                stack.add(asteroids[i]);
            } else {
                int top = stack.peek();
                if((top > 0 && asteroids[i] > 0) || (top < 0 && asteroids[i] < 0) || (top < 0 && asteroids[i] > 0)) {
                    stack.add(asteroids[i]);
                } else {
                    if(Math.abs(top) > Math.abs(asteroids[i])) {
                        continue;
                    } else if(Math.abs(top) == Math.abs(asteroids[i])) {
                        stack.pop();
                        continue;
                    }
                    boolean flag = false;
                    while(!stack.isEmpty() && (stack.peek() > 0 && asteroids[i] < 0 )) {
                        if(Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                            flag = true;
                            break;
                        }
                        if(Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                            flag = true;
                            stack.pop();
                            break;
                        }
                        stack.pop();
                    }
                    if(flag) continue;
                    stack.add(asteroids[i]);
                }
            }
        }

        int n = stack.size();
        int res[] = new int[n];
        int ctr = n-1;
        while(!stack.isEmpty()) {
            res[ctr--] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(new AsteroidCollision().collidingAsteroids(new int[] {-70, 100, 23, 42, -50, -75, 1, -2, -3})).forEach(System.out::println);
    }
}
