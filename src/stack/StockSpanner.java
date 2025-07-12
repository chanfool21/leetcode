package stack;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> stack;
    List<Integer> prices;
    static int index = -1;
    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        index++;
        prices.add(price);
        if(stack.isEmpty()) {
            stack.add(index);
            return 1;
        } else {
            while(!stack.isEmpty() && prices.get(stack.peek()) <= price) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                stack.add(index);
                return index+1;
            } else {
                int res = index - stack.peek();
                stack.add(index);
                return res;
            }
        }
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(85));
        System.out.println(sp.next(76));
        System.out.println(sp.next(43));
        System.out.println(sp.next(26));
        System.out.println(sp.next(52));
    }
}
