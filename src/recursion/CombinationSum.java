package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    void fnc(int candidates[], int target, int curSum, int index, int n, LinkedList<Integer> curList, List<List<Integer>> result) {
        if(curSum == target) {
            List<Integer> copy = new ArrayList<>();
            for(int i = 0; i < curList.size(); i++) {
                copy.add(curList.get(i));
            }

            result.add(copy);
            return;
        }

        if(curSum > target || index >= n) {
            return;
        }

        /*
            2 3 6 7     -----> 7
            2

         */
        curList.add(candidates[index]);
        fnc(candidates, target, curSum+ candidates[index], index, n, curList, result);
        curList.removeLast();
        fnc(candidates, target, curSum, index+1, n, curList, result);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> curList = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        fnc(candidates, target, 0, 0, candidates.length, curList, result);
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
        for(List res: result) {
            res.forEach(ele -> System.out.println(ele));
            System.out.println("<=========== Watch it ============>");
        }
    }
}
