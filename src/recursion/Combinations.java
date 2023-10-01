package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {


    void fnc(int idx, int n, int k, List<List<Integer>> result, LinkedList<Integer> currentList) {
        if (idx > n) {
            if (currentList.size() == k) {
                List<Integer> copy = new ArrayList<>();
                copy.addAll(currentList);
                result.add(copy);
            }
            return;
        }
        if (currentList.size() == k) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(currentList);
            result.add(copy);
            return;
        }

        for (int i = idx; i <= n; i++) {
            currentList.add(i);
            fnc(i + 1, n, k, result, currentList);
            currentList.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> currentList = new LinkedList<>();

        fnc(1, n, k, result, currentList);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(4,3);
        for(List res: result) {
            res.forEach(ele -> System.out.print(ele + " "));
            System.out.println();
        }
    }

}
