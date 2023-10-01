package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);

        if(n == 0) {
            return temp;
        }

        List<Integer> prev = temp;
        for(int i = 1; i <= n; i++) {
            List<Integer> curList = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    curList.add(prev.get(j));
                } else if(j == i) {
                    curList.add(prev.get(j-1));
                } else {
                    curList.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev = curList;
        }

        return prev;
    }

    public static void main(String[] args) {
        List<Integer> res = new PascalTriangle2().getRow(4);
        res.forEach(a -> System.out.println(a));
    }
}
